package spring.aop.invoke;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author zhangxinpeng
 * @date 2020/3/7
 */
@Component
@Slf4j
public class DataServiceRunner implements ApplicationRunner {
    @Autowired
    private DataService dataService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        dataService.insert("A");
        dataService.printAllData();

        try {
            dataService.insertAndRollback("B");
        } catch (RuntimeException e) {
            log.error("run: e {}", e.getClass().getSimpleName());
        }
        dataService.printAllData();

        dataService.invokeByThis();
        dataService.printAllData();

        dataService.invokeBySelf();
        dataService.printAllData();

        dataService.invokeByAppCtx();
        dataService.printAllData();

        dataService.invokeByAopContext();
        dataService.printAllData();
    }
}
