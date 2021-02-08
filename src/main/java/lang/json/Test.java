package lang.json;

import com.alibaba.fastjson.JSON;

/**
 * @author zhangxinpeng
 * @date 2020/11/25
 */
public class Test {
    private static int perfectScore = 30;
    private static int basicScore = 10;
    private static int perfectWidth = 78;
    private static int failScoreCoefficient = 20;

    public static void main(String[] args) {
        String uid = "110468781";
        String result = "467_0|429_1|598_1|431_1|";
        String gameInfoStr = "{\"systemInfo\":{\"k\":1.0,\"basicScore\":10,\"perfectScore\":30,\"failScoreCoefficient\":20,\"rulerDuration\":15},\"userInfo\":{\"remainedRevivalTimes\":5,\"nextRevivalCurrencyType\":2,\"nextRevivalCost\":20,\"points\":2654,\"rulerNum\":0},\"cuboidInfo\":[{\"width\":238,\"distance\":388,\"movingRange\":0,\"speed\":0},{\"width\":215,\"distance\":365,\"movingRange\":0,\"speed\":0},{\"width\":242,\"distance\":392,\"movingRange\":0,\"speed\":0},{\"width\":198,\"distance\":348,\"movingRange\":0,\"speed\":0},{\"width\":190,\"distance\":340,\"movingRange\":0,\"speed\":0},{\"width\":157,\"distance\":307,\"movingRange\":0,\"speed\":0},{\"width\":188,\"distance\":338,\"movingRange\":0,\"speed\":0},{\"width\":240,\"distance\":390,\"movingRange\":0,\"speed\":0},{\"width\":229,\"distance\":379,\"movingRange\":0,\"speed\":0},{\"width\":196,\"distance\":346,\"movingRange\":0,\"speed\":0},{\"width\":192,\"distance\":342,\"movingRange\":0,\"speed\":0},{\"width\":182,\"distance\":332,\"movingRange\":0,\"speed\":0},{\"width\":171,\"distance\":321,\"movingRange\":0,\"speed\":0},{\"width\":193,\"distance\":343,\"movingRange\":0,\"speed\":0},{\"width\":234,\"distance\":384,\"movingRange\":0,\"speed\":0},{\"width\":203,\"distance\":353,\"movingRange\":0,\"speed\":0},{\"width\":227,\"distance\":377,\"movingRange\":0,\"speed\":0},{\"width\":152,\"distance\":302,\"movingRange\":0,\"speed\":0},{\"width\":209,\"distance\":359,\"movingRange\":0,\"speed\":0},{\"width\":211,\"distance\":361,\"movingRange\":0,\"speed\":0}]}";
        CheckResult checkResult = check(uid, result, gameInfoStr);
        System.out.println(JSON.toJSONString(checkResult));
    }

    public static CheckResult check(String uid, String result, String gameInfoStr) {
        GameInfo gameInfo = JSON.parseObject(gameInfoStr, GameInfo.class);
        String[] resultArr = result.split("\\|");

        int roundPoints = 0;
        int roundId = 1;
        for (int i = 0; i < resultArr.length; i++) {
            String[] timeAndUseRuler = resultArr[i].split("_");
            int stickLength = Integer.parseInt(timeAndUseRuler[0]);
            GameInfo.Cuboid cuboid = gameInfo.getCuboidInfo().get(i);
            String opResult = "fall";

            // 命中完美区域
            int edgeWidth = (cuboid.getWidth() - perfectWidth) / 2;
            if (stickLength >= cuboid.getDistance() + edgeWidth && stickLength <= cuboid.getDistance() + edgeWidth + perfectWidth) {
                roundPoints += perfectScore;
                opResult = "perfect_pass";
            } else if (stickLength > cuboid.getDistance() && stickLength <= cuboid.getDistance() + cuboid.getWidth()) { // 命中普通区域
                roundPoints += basicScore;
                opResult = "normal_pass";
            }
            System.out.println(String.format("%d:%d", i, roundPoints));
        }

        boolean succeed = resultArr.length == gameInfo.getCuboidInfo().size();
        if (!succeed) {
            roundPoints = roundPoints * failScoreCoefficient / 100;
        }

        // 更新榜单
        return new CheckResult(succeed, roundPoints, roundPoints);
    }
}
