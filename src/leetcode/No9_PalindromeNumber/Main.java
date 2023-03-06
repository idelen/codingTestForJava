package leetcode.No9_PalindromeNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public boolean isPalindrome(int x) {
        String xString = String.valueOf(x);
        int left = 0, right = xString.length() - 1;

        while (left < right) {
            if (xString.charAt(left) != xString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        List<Integer> xList = Arrays.asList(121, -121, 10);
        xList.stream()
            .map(s::isPalindrome)
            .forEach(System.out::println);
    }
}
