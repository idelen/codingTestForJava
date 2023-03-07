package leetcode.No13_RomantoInteger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    private List<String> oneNumbers = Arrays.asList("IV", "IX", "XL", "XC", "CD", "CM");
    private Map<String, Integer> romanMap = new HashMap<String, Integer>() {{
        put("I", 1);
        put("IV", 4);
        put("V", 5);
        put("IX", 9);
        put("X", 10);
        put("XL", 40);
        put("L", 50);
        put("XC", 90);
        put("C", 100);
        put("CD", 400);
        put("D", 500);
        put("CM", 900);
        put("M", 1000);
    }};

    public int romanToInt(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && oneNumbers.contains(s.substring(i, i+2))) {
                result += romanMap.get(s.substring(i, i+2));
                i++;
            } else {
                result += romanMap.get(s.substring(i, i+1));
            }
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        List<String> romanList = Arrays.asList("III", "LVIII", "MCMXCIV");

        romanList.stream()
            .map(s::romanToInt)
            .forEach(System.out::println);
    }
}
