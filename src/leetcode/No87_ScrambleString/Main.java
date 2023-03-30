package leetcode.No87_ScrambleString;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        List<String> s1List = Arrays.asList("great", "abcde", "a", "abcdbdacbdac", "ab", "abcd");
        List<String> s2List = Arrays.asList("rgeat", "caebd", "a", "bdacabcdbdac", "ab", "badc");

        for (int i = 0; i < s1List.size(); i++) {
            System.out.println(s.isScramble(s1List.get(i), s2List.get(i)));
        }
    }
}
