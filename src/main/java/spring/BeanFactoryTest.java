package spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileUrlResource;

import java.net.MalformedURLException;

/**
 * @author zhangxinpeng
 * @date 2021/1/6
 */
public class BeanFactoryTest {
    public static void main(String[] args) throws MalformedURLException {
        // BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        BeanFactory beanFactory = new XmlBeanFactory(new FileUrlResource("/Users/wanba/IdeaProjects/practice-java/src/main/java/spring/beans.xml"));
        TestBean testBean = (TestBean)beanFactory.getBean("testBean");
        System.out.println(testBean.getDesc());
    }
}
