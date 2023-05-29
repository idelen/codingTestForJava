package leetcode.No1406_StoneGame3;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private static int LENGTH;
    private static int[] stones;

    private static Map<Integer, Integer> scoreMap;
    public String stoneGameIII(int[] stoneValue) {
        LENGTH = stoneValue.length;
        stones = stoneValue.clone();
        scoreMap = new HashMap<>();

        int score = dfs(0);

        if (score > 0) {
            return "Alice";
        } else if (score < 0) {
            return "Bob";
        } else {
            return "Tie";
        }

    }

    private int dfs(int i) {
        if (i >= LENGTH) {
            return 0;
        }

        if (scoreMap.containsKey(i)) {
            return scoreMap.get(i);
        }

        int result = Integer.MIN_VALUE;

        for (int j=i; j < Math.min(i+3, LENGTH); j++) {
            result = Math.max(result, stoneSum(i, j) - dfs(j+1));
        }

        scoreMap.put(i, result);

        return result;
    }

    private int stoneSum(int i, int j) {
        int sumResult = 0;
        for (int num = i; num <= j; num++) {
            sumResult += stones[num];
        }
        return sumResult;
    }

}
