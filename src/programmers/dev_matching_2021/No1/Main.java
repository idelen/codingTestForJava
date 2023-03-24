package programmers.dev_matching_2021.No1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        List<int[]> lottosList = Arrays.asList(
            new int[]{44, 1, 0, 0, 31, 25},
            new int[]{0, 0, 0, 0, 0, 0},
            new int[]{45, 4, 35, 20, 3, 9},
            new int[]{1, 2, 3, 4, 5, 6}
        );

        List<int[]> winNumsList = Arrays.asList(
            new int[]{31, 10, 45, 1, 6, 19},
            new int[]{38, 19, 20, 40, 15, 25},
            new int[]{20, 9, 3, 45, 4, 35},
            new int[]{7, 8, 9, 10, 11, 12}
        );

        for (int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(s.solution(lottosList.get(i), winNumsList.get(i))));
        }
    }
}
