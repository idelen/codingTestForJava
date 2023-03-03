package leetcode.No1_TwoSum;

import java.util.Arrays;


class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int firstIdx = 0; firstIdx < nums.length - 1; firstIdx++) {
            for (int secondIdx = firstIdx + 1; secondIdx < nums.length; secondIdx++) {
                if (nums[firstIdx] + nums[secondIdx] == target) {
                    return new int[] {firstIdx, secondIdx};
                }
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] ars) {
        Solution s = new Solution();
        //입력요소를 선언해줘야 출력값이 나옴
        int[][] numsList = {
            {2, 7, 11, 15},
            {3, 2, 4},
            {3, 3}
        };
        int[] targetList = {
            9, 6, 6
        };

        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(s.twoSum(numsList[i], targetList[i])));
        }
    }
}
