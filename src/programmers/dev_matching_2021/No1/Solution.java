package programmers.dev_matching_2021.No1;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        int zeroCount = 0;
        int winCount = 0;

        for (int i = 0; i < lottos.length; i++) {
            int lotto = lottos[i];

            if (lotto == 0) {
                zeroCount++;
            } else {
                for (int j = 0; j < win_nums.length; j++) {
                    if (lotto == win_nums[j]) {
                        winCount++;
                    }
                }
            }
        }

        if (zeroCount == 6) {
            answer = new int[]{1, 6};
        } else if (winCount == 6) {
            answer = new int[]{1, 1};
        } else {
            answer = new int[]{calRank(winCount + zeroCount), calRank(winCount)};
        }
        return answer;
    }

    private int calRank(int winCount) {
        if (winCount < 2) {
            return 6;
        } else {
            return 7 - winCount;
        }
    }
}