package codility.lesson.lesson4_Counting_Elements.FrogRiverOne;

public class FrogRiverOne {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = new int[] {1,3,1,4,2,3,5,4};
        int X = 5;
        System.out.println(s.solution(X, A));
    }
}

class Solution {
    public int solution(int X, int[] A) {
        // Implement your solution here
        boolean[] visited = new boolean[X+1];
        int checkSum = 0;
        int targetSum = X * (X + 1) / 2;

        for (int idx = 0; idx < A.length; idx++) {
            int pos = A[idx];

            if (pos <= X && !visited[pos]) {
                visited[pos] = true;
                checkSum += pos;

                if (checkSum == targetSum) {
                    return idx;
                }
            }
        }

        return -1;
    }
}