package spring.aop.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author zhangxinpeng
 * @date 2020/3/11
 */
@Slf4j
@Component
public class AsyncServiceRunner implements ApplicationRunner {
    @Autowired
    private AsyncService asyncService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("# doAsync started");
        asyncService.doAsync();
        log.info("# doAsync finished");

        log.info("# invokeByThis started");
        asyncService.invokeByThis();
        log.info("# invokeByThis finished");

        log.info("# invokeBySelf started");
        asyncService.invokeBySelf();
        log.info("# invokeBySelf finished");
    }
}
