package spring.aop.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import spring.aop.invoke.AopTestApplication;

/**
 * @author zhangxinpeng
 * @date 2020/3/11
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableAsync
public class AsyncTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(AsyncTestApplication.class, args);
    }
}
