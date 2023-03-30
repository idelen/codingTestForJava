package leetcode.No87_ScrambleString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {

    private HashMap<String, Set<String>> memo = new HashMap<>();
    private String TARGET;

    public boolean isScramble(String s1, String s2) {
        TARGET = s2;
        Set<String> result = scramble(s1, s1.length());
        if (result.contains(s2)) {
            return true;
        } else {
            return false;
        }
    }

    private Set<String> scramble(String target, int length) {
        Set<String> result = new HashSet<>();

        if (length == 1) {
            result.add(target);
            return result;
        }

        for (int i = 1; i < length; i++) {
            String s1 = target.substring(0, i);
            String s2 = target.substring(i);

            Set<String> s1Scramble;
            Set<String> s2Scramble;

            if (!memo.containsKey(s1)) {
                s1Scramble = scramble(s1, s1.length());
                memo.put(s1, s1Scramble);
            } else {
                s1Scramble = memo.get(s1);
            }

            if (!memo.containsKey(s2)) {
                s2Scramble = scramble(s2, s2.length());
                memo.put(s2, s2Scramble);
            } else {
                s2Scramble = memo.get(s2);
            }
            result.addAll(combi(s1Scramble, s2Scramble));
        }

        return result;
    }

    private Set<String> combi(Set<String> s1List, Set<String> s2List) {
        Set<String> combiResult = new HashSet<>();

        Iterator<String> s1Iterator = s1List.iterator();

        while(s1Iterator.hasNext()) {
            String s1 = s1Iterator.next();
            Iterator<String> s2Iterator = s2List.iterator();
            while(s2Iterator.hasNext()) {
                String s2 = s2Iterator.next();
                String combine1 = s1 + s2;
                String combine2 = s2 + s1;

                if (TARGET.contains(combine1)) {
                    combiResult.add(combine1);
                }

                if (TARGET.contains(combine2)) {
                    combiResult.add(combine2);
                }
            }
        }

        return combiResult;
    }
}
