package actor;

import java.lang.reflect.Method;
import java.util.concurrent.CompletableFuture;

/**
 * Actor Model中的邮件封装类
 * @author zhangxinpeng
 * @date 2021/1/29
 */
public class Mail {
    private CompletableFuture<Object> future = new CompletableFuture<>();
    private  Actor threadFrom;
    private Method method;
    private Object[] params;
    Object result;

    public Mail(Thread threadFrom, Method method, Object[] params) {
        this.threadFrom = threadFrom instanceof Actor ? (Actor)threadFrom : null;
        this.method = method;
        this.params = params;
    }

    public CompletableFuture<Object> getFuture() {
        return future;
    }

    public void setFuture(CompletableFuture<Object> future) {
        this.future = future;
    }

    public Actor getThreadFrom() {
        return threadFrom;
    }

    public void setThreadFrom(Actor threadFrom) {
        this.threadFrom = threadFrom;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
