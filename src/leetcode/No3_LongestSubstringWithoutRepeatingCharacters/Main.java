package leetcode.No3_LongestSubstringWithoutRepeatingCharacters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int count = 0;
        int code = 0;
        char text;
        int cutIdx = 0;
        int result = 0;
        StringBuilder subString = new StringBuilder();
        boolean[] flag = new boolean[128];

        for (int i = 0; i < s.length(); i++) {
            text = s.charAt(i);
            code = (int) text;
            subString.append(text);

            if ( !flag[code] ) {
                flag[code] = true;
                count++;
            } else {
                cutIdx = subString.indexOf(String.valueOf(text));

                for (int j = 0; j<= cutIdx; j++) {
                    flag[(int) subString.substring(j, j+1).charAt(0)] = false;
                }
                subString.delete(0, cutIdx + 1);
                flag[code] = true;
                result = Math.max(result, count);
                count -= cutIdx;
            }
        }
        return Math.max(result, count);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        List<String> inputList = Arrays.asList("abcabcbb", "bbbbb", "pwwkew", "dvdf");

        inputList.stream()
            .map(s::lengthOfLongestSubstring)
            .forEach(System.out::println);
    }
}
