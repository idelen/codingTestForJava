package codility.lesson.lesson3_Time_Complexity.PermMissingElem;

public class PermMissingElem {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] A = new int[] {1, 3, 2, 5};
        System.out.println(s.solution(A));
    }
}

class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        long sum = 0;
        long N = A.length;

        for (int num : A) {
            sum += num;
        }

        return (int) ((N + 1) * (N + 2) / 2 - sum);
    }
}


