package actor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Proxy;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author zhangxinpeng
 * @date 2021/1/29
 */
public class Actor extends Thread {
    private static final ConcurrentHashMap<Class<?>, Object> actorMap = new ConcurrentHashMap<>();
    private final LinkedBlockingQueue<Mail> mailBox = new LinkedBlockingQueue<>();

    protected Actor() {
        Class<? extends Actor> clazz = getClass();
        Class<?>[] implementedList = clazz.getInterfaces();
        if (implementedList.length <= 0) {
            throw new IllegalStateException("非法Actor");
        }
        Object proxy = Proxy.newProxyInstance(clazz.getClassLoader(), implementedList, (__, method, params) -> {
            Mail mail = new Mail(Thread.currentThread(), method, params);
            mailBox.put(mail);
            return mail.getFuture();
        });
        for (Class<?> implemented : implementedList) {
            Object oldActor = actorMap.putIfAbsent(implemented, proxy);
            if (oldActor != null) {
                throw new IllegalStateException("duplicated actor " + implemented.getName()
                        + " in " + clazz.getName() + " and " + oldActor.getClass().getName());
            }
        }
        start();
    }

    public static void init(Class<? extends Actor> actorClass) throws Exception {
        Constructor<? extends Actor> ctor = actorClass.getDeclaredConstructor();
        ctor.setAccessible(true);
        ctor.newInstance();
    }

    public static <I> I getActor(Class<I> interfaceClass) {
        return (I)actorMap.get(interfaceClass);
    }

    protected boolean onInterrupted() {
        return true;
    }

    protected void onException(Throwable e) {
        e.printStackTrace();
    }

    @Override
    public void run() {
        while (true) {
            try {
                for (; ; ) {
                    Mail mail = mailBox.take();
                    Object res = mail.result;
                    if (res == null) {
                        res = mail.getMethod().invoke(this, mail.getParams());
                        if (res instanceof CompletableFuture) {
                            res = ((CompletableFuture<?>) res).getNow(null);
                        }
                        if (mail.getThreadFrom() != null) {
                            mail.result = res != null ? res : mailBox;
                            mail.getThreadFrom().mailBox.put(mail);
                        } else {
                            mail.getFuture().complete(res);
                        }
                    } else {
                        mail.getFuture().complete(res != mailBox ? res : null);
                    }
                }
            } catch (InterruptedException e) {
                interrupted(); // clear status
                if (onInterrupted()) {
                    break;
                }
            } catch (Throwable e) {
                onException(e);
            }
        }
    }
}
