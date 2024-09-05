package codility.lesson.lesson4_Counting_Elements.MaxCounters;

import java.util.Arrays;

public class MaxCounters {
    public static void main(String[] args) {
        Solution s = new Solution();
        int N = 5;
        int[] A = new int[] {3,4,4,6,1,4,4};
        System.out.println(Arrays.toString(s.solution(N, A)));
    }
}

class Solution {
    public int[] solution(int N, int[] A) {
        // Implement your solution here
        int[] counter = new int[N];
        int maxCount = 0;
        int totalMax = 0;

        for (int num : A) {
            if (num == N + 1) {
                if (maxCount != 0) {
                    totalMax += maxCount;
                    maxCount = 0;
                    counter = new int[N];
                }
            } else {
                counter[num - 1]++;
                maxCount = Math.max(maxCount, counter[num-1]);
            }
        }

        for (int i = 0; i < N; i++) {
            counter[i] += totalMax;
        }

        return counter;
    }
}
