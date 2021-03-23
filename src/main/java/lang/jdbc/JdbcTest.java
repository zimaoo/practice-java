package lang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * JDBC测试类
 *
 * @author zhangxinpeng
 * @date 2021/3/23
 */
public class JdbcTest {
    public static void main(String[] args) throws Exception {
        // 0. 注册驱动（3种方式），具体见DriverManager接口详解，MySQL可以不用写
        // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        // Class.forName("com.mysql.jdbc.Driver");
        // 1. 获取连接（3个重载）
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "232323");
        // 2. 创建对象
        Statement statement = connection.createStatement();
        // 3. 执行语句
        ResultSet resultSet = statement.executeQuery("SELECT * FROM contact");
        // 4. 处理结果
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
            System.out.println(resultSet.getString(4));
            System.out.println(resultSet.getString(5));
        }
        // 5. 释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
