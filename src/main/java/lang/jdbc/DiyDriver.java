package lang.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.SQLException;

/**
 * @author zhangxinpeng
 * @date 2021/3/23
 */
public class DiyDriver extends Driver {

    /**
     * Construct a new driver and register it with DriverManager
     *
     * @throws SQLException if a database error occurs.
     */
    public DiyDriver() throws SQLException {
        System.out.println("=> Using Diy Driver");
    }
}
