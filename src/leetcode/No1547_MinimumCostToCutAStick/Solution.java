package leetcode.No1547_MinimumCostToCutAStick;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

    Map<List<Integer>, Integer> map;

    public int minCost(int n, int[] cuts) {
        map = new HashMap<>();
        return cost(cuts, 0, n);
    }

    public int cost(int cuts[], int l, int r) {
        List<Integer> ind = Arrays.asList(l, r);
        if (map.containsKey(ind))
            return map.get(ind);
        int min = Integer.MAX_VALUE;
        for (int i : cuts) {
            if (i <= l || i >= r)
                continue;
            int temp = cost(cuts, l, i) + cost(cuts, i, r);
            min = Math.min(temp + r - l, min);
        }
        if (min == Integer.MAX_VALUE) {
            min = 0;
        }
        map.put(ind, min);
        return min;
    }
}

// ===== Wrong Solution( time over) ====
//    private List<int[]> allCuts;
//    public int minCost(int n, int[] cuts) {
//        allCuts = new ArrayList<>();
//        Set<List<Integer>> sticks;
//        int result = Integer.MAX_VALUE;
//
//        permutation(cuts, 0, cuts.length, cuts.length);
//
//        for (int[] cut : allCuts) {
//            sticks = new HashSet<>();
//            sticks.add(Arrays.asList(0, n));
//            int nowResult = 0;
//
//            for (int cdx : cut) {
//                for (List<Integer> stick : sticks) {
//                    int start = stick.get(0);
//                    int end = stick.get(1);
//
//                    if (cdx > start && cdx < end) {
//                        nowResult += (end - start);
//
//                        sticks.remove(stick);
//                        sticks.add(Arrays.asList(start, cdx));
//                        sticks.add(Arrays.asList(cdx, end));
//                        break;
//                    }
//                }
//            }
//
//            result = Math.min(result, nowResult);
//        }
//
//        return result;
//
//    }
//
//    public void permutation(int[] arr, int depth, int n, int r) {
//        if (depth == r) {
//            allCuts.add(arr.clone());
//            System.out.println(arr);
//            return;
//        }
//
//        for (int i = depth; i < n; i++) {
//            swap(arr, depth, i);
//            permutation(arr, depth + 1, n, r);
//            swap(arr, depth, i);
//        }
//    }
//
//    public void swap(int[] arr, int depth, int i) {
//        int temp = arr[depth];
//        arr[depth] = arr[i];
//        arr[i] = temp;
//    }
//}
