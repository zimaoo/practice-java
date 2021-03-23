package lang.spi;

/**
 * @author zhangxinpeng
 * @date 2021/3/23
 */
public class AliPayment implements Payment {
    @Override
    public boolean pay(int amount) {
        System.out.println(String.format("=> Paid by alipay ￥%d", amount));
        return true;
    }
}
