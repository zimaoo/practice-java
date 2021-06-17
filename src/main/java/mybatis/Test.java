package mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author zhangxinpeng
 * @date 2021/6/15
 */
public class Test {
    private static String path = "";
    public static void main(String[] args) throws Exception {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(path));
        SqlSession sqlSession = sqlSessionFactory.openSession();
    }
}
