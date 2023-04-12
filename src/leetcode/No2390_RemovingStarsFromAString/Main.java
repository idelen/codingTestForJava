package leetcode.No2390_RemovingStarsFromAString;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        List<String> sList = Arrays.asList("leet**cod*e", "erase*****");

        for (String value : sList) {
            System.out.println(s.removeStars(value));
        }
    }
}
