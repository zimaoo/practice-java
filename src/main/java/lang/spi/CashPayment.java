package lang.spi;

/**
 * 现金支付
 * @author zhangxinpeng
 * @date 2021/3/23
 */
public class CashPayment implements Payment {
    @Override
    public boolean pay(int amount) {
        System.out.println(String.format("=> Paid by cash ￥%d", amount));
        return true;
    }
}
