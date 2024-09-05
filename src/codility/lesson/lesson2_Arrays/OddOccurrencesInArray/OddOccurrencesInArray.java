package codility.lesson.lesson2_Arrays.OddOccurrencesInArray;

import java.util.HashSet;
import java.util.Set;

public class OddOccurrencesInArray {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] A = new int[] {9, 3, 9, 3, 9, 7, 9};
        System.out.println(s.solution(A));
    }
}

class Solution {
    public int solution(int[] A) {
        // Implement your solution here

        Set<Integer> checker = new HashSet<>();

        for (int num : A) {
            if (checker.contains(num) ) {
                checker.remove(num);
            } else {
                checker.add(num);
            }
        }

        return checker.stream().findFirst().get();
    }
}
