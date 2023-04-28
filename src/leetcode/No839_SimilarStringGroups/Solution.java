package leetcode.No839_SimilarStringGroups;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int numSimilarGroups(String[] strs) {
        int N = strs.length;
        int groupCnt = 0;

        int[] groupNumber = new int[N];

        List<Integer> queue = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            if (groupNumber[i] == 0) {
                groupCnt++;
                queue.add(i);
            }

            while (!queue.isEmpty()) {
                int cur = queue.remove(0);

                groupNumber[cur] = groupCnt;

                for (int idx = 0; idx < N; idx++) {
                    if (groupNumber[idx] != 0) {
                        continue;
                    }

                    if (validate(strs[cur], strs[idx])) {
                        groupNumber[idx] = groupCnt;
                        queue.add(idx);
                    }
                }
            }
        }

        return groupCnt;
    }

    private boolean validate(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        char s1;
        char s2;
        int cnt = 0;
        char diffChar = '-';

        for (int idx = 0; idx < str1.length(); idx++) {
            s1 = str1.charAt(idx);
            s2 = str2.charAt(idx);

            if (s1 != s2) {
                cnt++;

                if (cnt == 1) {
                    diffChar = s2;
                } else if (cnt == 2) {
                    if (diffChar != s1) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
