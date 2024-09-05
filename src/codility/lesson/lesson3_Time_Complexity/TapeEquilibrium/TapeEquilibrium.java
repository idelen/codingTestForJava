package codility.lesson.lesson3_Time_Complexity.TapeEquilibrium;

public class TapeEquilibrium {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = new int[] {3,1,2,4,3};
        System.out.println(s.solution(A));

    }
}

class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        long minDifference = Long.MAX_VALUE;

        long totalSum = 0;

        for (int num : A) {
            totalSum += num;
        }

        long head = 0;
        long tail = totalSum;

        for (int p = 0; p < A.length - 1; p++) {
            head += A[p];
            tail -= A[p];

            minDifference = Math.min(minDifference, Math.abs(head - tail));
        }

        return (int) minDifference;
    }
}