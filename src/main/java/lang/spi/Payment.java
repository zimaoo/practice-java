package lang.spi;

/**
 * 付费接口
 * @author zhangxinpeng
 * @date 2021/3/23
 */
public interface Payment {
    /**
     * 支付
     * @param amount 金额
     * @return
     */
    boolean pay(int amount);
}
