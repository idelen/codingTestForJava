package leetcode.No649_Dota2Senate;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        List<String> senateList = Arrays.asList("RD", "RDD");

        senateList.forEach(senate -> System.out.println(s.predictPartyVictory(senate)));
    }

}
