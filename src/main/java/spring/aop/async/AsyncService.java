package spring.aop.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author zhangxinpeng
 * @date 2020/3/11
 */
@Component
@Slf4j
public class AsyncService {
    @Autowired
    @Lazy
    private AsyncService asyncService;

    @Async
    public void doAsync() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("ThreadName: {}", Thread.currentThread().getName());
    }

    public void invokeByThis() {
        doAsync();
    }

    public void invokeBySelf() {
        asyncService.doAsync();
    }
}
