package lang.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author zhangxinpeng
 * @date 2021/3/23
 */
public class SPITest {
    public static void main(String[] args) {
        ServiceLoader<Payment> serviceLoader = ServiceLoader.load(Payment.class);
        Iterator<Payment> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            iterator.next().pay(100);
        }
    }
}
