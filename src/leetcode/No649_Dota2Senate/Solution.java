package leetcode.No649_Dota2Senate;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public String predictPartyVictory(String senate) {
        int radiantCount = 0;
        int direCount = 0;
        boolean isEnd = false;
        List<String> result = Arrays.asList("Radiant", "Dire");
        char[] senates = senate.toCharArray();

        while(!isEnd) {
            isEnd = true;

            for (int idx = 0; idx < senates.length; idx++) {
                char t = senates[idx];

                if (t == 'R') {
                    if (direCount > 0) {
                        direCount--;
                        senates[idx] = 'B';
                        isEnd = false;
                    } else {
                        radiantCount++;
                    }
                } else if (t == 'D') {
                    if (radiantCount > 0) {
                        radiantCount--;
                        senates[idx] = 'B';
                        isEnd = false;
                    } else {
                        direCount++;
                    }
                }
            }
        }

        if (radiantCount > 0) {
            return result.get(0);
        } else {
            return result.get(1);
        }

    }
}
