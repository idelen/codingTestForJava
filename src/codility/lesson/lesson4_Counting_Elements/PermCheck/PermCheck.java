package codility.lesson.lesson4_Counting_Elements.PermCheck;

public class PermCheck {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] A = new int[] {1,3,4,2};
        System.out.println(s.solution(A));
    }
}

class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        int N = A.length;
        boolean[] visited = new boolean[N + 1];
        int cnt = 0;

        for (int num : A) {
            if (num <= N && !visited[num]) {
                visited[num] = true;
                cnt++;
            }
        }

        return cnt == N ? 1 : 0;
    }
}