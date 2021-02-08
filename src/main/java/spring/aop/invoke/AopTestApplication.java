package spring.aop.invoke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhangxinpeng
 * @date 2020/3/7
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableAspectJAutoProxy(exposeProxy = true)
public class AopTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(AopTestApplication.class, args);
    }
}
