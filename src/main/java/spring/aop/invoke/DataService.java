package spring.aop.invoke;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhangxinpeng
 * @date 2020/3/7
 */
@Component
@Slf4j
public class DataService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataService dataService;

    @Autowired
    private ApplicationContext applicationContext;

    @Transactional(rollbackFor = RuntimeException.class)
    public void insert(String nickName) {
        jdbcTemplate.update("INSERT INTO aop_test(nickname) VALUES(?)", nickName);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void insertAndRollback(String nickName) {
        log.info("insertAndRollback: nickname {}", nickName);
        jdbcTemplate.update("INSERT INTO aop_test(nickname) VALUES(?)", nickName);
        throw new RuntimeException();
    }

    public void printAllData() {
        log.info("### printAllData started ###");
        jdbcTemplate.queryForList("SELECT * FROM aop_test").forEach(e -> log.info("nickname {}", e.get("nickname")));
        log.info("### printAllData finished ###");
    }

    /**
     * 事务不生效
     */
    public void invokeByThis() {
        try {
            insertAndRollback("C");
        } catch (RuntimeException e) {
            log.error("invokeByThis: e {}", e.getClass().getSimpleName());
        }
    }

    /**
     * 解决方法一
     */
    public void invokeBySelf() {
        try {
            dataService.insertAndRollback("D");
        } catch (RuntimeException e) {
            log.error("invokeBySelf: e {}", e.getClass().getSimpleName());
        }
    }

    /**
     * 解决方法二
     */
    public void invokeByAppCtx() {
        try {
            ((DataService) applicationContext.getBean("dataService")).insertAndRollback("E");
        } catch (RuntimeException e) {
            log.error("invokeByAppCtx: e {}", e.getClass().getSimpleName());
        }
    }

    /**
     * 方法三
     */
    public void invokeByAopContext() {
        try {
            ((DataService) AopContext.currentProxy()).insertAndRollback("F");
        } catch (RuntimeException e) {
            log.error("invokeByAopContext: e {}", e.getClass().getSimpleName());
        }
    }
}
