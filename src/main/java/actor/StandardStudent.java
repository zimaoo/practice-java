package actor;

/**
 * @author zhangxinpeng
 * @date 2021/1/29
 */
public class StandardStudent extends Actor implements Student {
    private StandardStudent() {
        setName("谷成毅");
    }

    @Override
    public void figure(int n, int m) {
        getActor(Calculator.class).add(n, m).thenAccept(r -> {
            System.out.println(String.format("%s: %s + %d = %d", currentThread().getName(), n, m, r));
            System.exit(0);
        });
        System.out.println(currentThread().getName() + "，题太难，计算器来做");
    }
}
