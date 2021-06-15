package lang;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author zhangxinpeng
 * @date 2021/2/8
 */
public class BitTest {
    public static void main(String[] args) {
//        testSelectionKey();
//        addItem(1);
//        for(int i = 0; i < 100; i++) {
//            System.out.println(getRandom(2, 6));
//        }

//
//        Integer[] activeBuffArr = new Integer[]{1, 2, 3};
//        String s = StringUtils.join(activeBuffArr, ",");
//        System.out.println(s);
//        List<Item> l = new ArrayList<>();
//        l.add(new Item("1", 3));
//        l.add(new Item("1", 2));
//        l.add(new Item("2", 3));
//        System.out.println(JSON.toJSONString(l.subList(0, 1)));
//        List<Item> unique = l.stream().collect(
//                Collectors.collectingAndThen(
//                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Item::getUid))), ArrayList::new));
//        System.out.println(JSON.toJSONString(unique));

        // String json = "[{\"castleEventType\":1,\"data\":\"2\",\"fromAvatarUrl\":\"https://qiniustatic.wodidashi.com/FrCcPbHcOnTo9uDQlNzLMOAEORmx?imageView/2/w/200/h/200\",\"fromGender\":\"m\",\"fromUid\":\"116210622\",\"fromUsername\":\"zhang04\",\"time\":1622448155969,\"toUid\":\"101408566\"}]";
//        String json = "[]";
//        List<CastleEvent> attackEventList = JSON.parseArray(json, CastleEvent.class);
//        attackEventList = attackEventList.stream().sorted((o1, o2) -> (int)(o1.getTime() - o2.getTime())).collect(
//                Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(CastleEvent::getFromUid))), ArrayList::new)
//        ).subList(0, attackEventList.size() >= 6 ? 6 : attackEventList.size());
//        System.out.println(attackEventList);

//        List<Integer> l = new ArrayList<>();
//        l.add(1);
//        l.add(2);
//        l.add(3);
//        Iterator iterator = l.iterator();
//        while (iterator.hasNext()) {
//            iterator.next();
//            iterator.remove();
//        }
//        System.out.println(l);
        Integer a = null;
        int b;
        b = a;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CastleEvent {
        /**
         * 事件触发来源用户
         */
        private String fromUid;

        /**
         * 事件触发来源用户名
         */
        private String fromUsername;

        /**
         * 事件触发来源头像
         */
        private String fromAvatarUrl;

        /**
         * 挑事者性别
         */
        private String fromGender;

        private String toUid;

        private int castleEventType;

        /**
         * 在不同事件中有不同含义
         * 偷取事件中表示金币数量
         * 抢劫事件中表示被抢工人名称
         * 攻击事件中表示攻击部位
         */
        private String data;

        /**
         * 事件发生时间
         */
        private long time;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Item {
        private String uid;
        private int time;
    }

    private static void addItem(int amount) {
        int shieldAmount = 3;
        int total = amount + shieldAmount;
        int maxShieldAmount = 3;
        if(total > maxShieldAmount) {
            amount = maxShieldAmount - shieldAmount;
            int surplusShield = total - maxShieldAmount;
            // 兑换游戏币数量
            int exchangedCurrency = surplusShield * 1000;
            System.out.println("exchangedCurrency: " + exchangedCurrency);
        }
        System.out.println("amount: " + amount);
    }

    public static void testSelectionKey() {
        System.out.println(SelectionKey.OP_READ);
        System.out.println(SelectionKey.OP_WRITE);
        System.out.println(SelectionKey.OP_CONNECT);
        System.out.println(SelectionKey.OP_ACCEPT);
    }

    public static int getRandom(int min, int max){
        Random random = new Random();
        int s = random.nextInt(max) % (max - min + 1) + min;
        return s;
    }
}
