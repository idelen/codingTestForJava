package codility.lesson.lesson4_Counting_Elements.MissingInteger;

public class MissingInteger {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = new int[] {-1,-3};
        System.out.println(s.solution(A));
    }
}

class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        int N = A.length;
        boolean[] checker = new boolean[N+2];

        for (int num : A) {
            if (0 < num && num <= N && !checker[num]) {
                checker[num] = true;
            }
        }

        for (int idx = 1 ; idx < N + 2; idx++) {
            if (!checker[idx]) {
                return idx;
            }
        }

        return 0;
    }
}
