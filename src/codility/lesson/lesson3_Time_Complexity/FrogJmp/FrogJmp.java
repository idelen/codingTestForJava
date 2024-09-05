package codility.lesson.lesson3_Time_Complexity.FrogJmp;

public class FrogJmp {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(10, 85, 30));
    }
}

class Solution {
    public int solution(int X, int Y, int D) {
        // Implement your solution here
        // x + n * D = Y
        // n = (y - x) / D
        int share = (Y - X) / D;
        int fix = (Y - X) % D > 0 ? 1 : 0;
        return share + fix;
    }
}

