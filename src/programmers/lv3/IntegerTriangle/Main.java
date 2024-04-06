package programmers.lv3.IntegerTriangle;

// https://school.programmers.co.kr/learn/courses/30/lessons/43105?language=java

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}; // answer : 30

        Solution s = new Solution();

        System.out.println(s.solution(triangle));
    }
}
/*
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5
 */

class Solution {
    private static Integer MAX_X;
    private int[][] triangle;

    private int[][] dp;

    public int solution(int[][] triangle) {
        int answer = 0;
        this.triangle = triangle;
        MAX_X = triangle.length;
        dp = new int[MAX_X][triangle[MAX_X - 1].length];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                dp[i][j] = -1;
            }
        }

        dp[0][0] = findMaxSum(0, 0);

        return dp[0][0];
    }

    public Integer findMaxSum(int x, int y) {
        if (x == MAX_X) {
            return 0;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        int leftSum = findMaxSum(x + 1, y);
        int rightSum = findMaxSum(x + 1, y + 1);
        int maxSum = triangle[x][y] + Math.max(leftSum, rightSum);

        dp[x][y] = maxSum;

        return maxSum;
    }
}
