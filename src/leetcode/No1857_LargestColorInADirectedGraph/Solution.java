package leetcode.No1857_LargestColorInADirectedGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private Map<Integer, ArrayList<Integer>> graph;
    private Map<Integer, Map<Character, Integer>> dp;
    private String COLORS;
    private Integer N;

    public int largestPathValue(String colors, int[][] edges) {
        N = colors.length();
        COLORS = colors;
        graph = new HashMap<>();
        dp = new HashMap<>();

        int[] inDegrees = new int[N];
        int result = 0;

        for (int[] edge : edges) {
            ArrayList<Integer> temp = new ArrayList<>();
            if (graph.containsKey(edge[0])) {
                temp = graph.get(edge[0]);
            }
            temp.add(edge[1]);
            graph.put(edge[0], temp);
            inDegrees[edge[1]] += 1;
        }

        List<Integer> queue = new ArrayList<>();

        for (int i = 0; i < inDegrees.length; i++) {
            int inDegree = inDegrees[i];

            if (inDegree == 0) {
                queue.add(i);
            }
        }

        List <Integer> topologySort = new ArrayList<>();
        boolean[] sortVisited = new boolean[N];

        while (!queue.isEmpty()) {
            int index = queue.remove(0);

            if (!sortVisited[index]) {
                topologySort.add(index);
                sortVisited[index] = true;

                if (graph.containsKey(index)) {
                    for (Integer child: graph.get(index)) {
                        inDegrees[child] -= 1;
                        if(inDegrees[child] == 0 && !sortVisited[child]) {
                            queue.add(child);
                        }
                    }
                }
            }
        }

        for (boolean visited: sortVisited) {
            if (!visited) {
                return -1;
            }
        }

        for (int idx = topologySort.size() - 1; idx >= 0 ; idx--) {
            int node = topologySort.get(idx);
            char color = COLORS.charAt(node);

            if (graph.containsKey(node)) {
                for (Integer child: graph.get(node)) {
                    Map<Character, Integer> nowMap = new HashMap<>(dp.get(child));

                    if (nowMap.containsKey(color)) {
                        nowMap.put(color, nowMap.get(color) + 1);
                    } else {
                        nowMap.put(color, 1);
                    }

                    for (Character nowColorKey: nowMap.keySet()) {
                        int count = nowMap.get(nowColorKey);

                        Map<Character, Integer> temp;

                        if (dp.containsKey(node)) {
                            temp = dp.get(node);
                            if (temp.containsKey(nowColorKey)) {
                                int max_count = dp.get(node).get(nowColorKey);
                                if (max_count > count) {
                                    count = max_count;
                                }
                            }
                        } else {
                            temp = new HashMap<>();
                        }
                        temp.put(nowColorKey, count);
                        dp.put(node, temp);
                    }
                }
            } else {
                Map<Character, Integer> temp = new HashMap<>();
                temp.put(color, 1);
                dp.put(node, temp);
            }
        }

        for (Integer key: dp.keySet()) {
            for (Integer count :dp.get(key).values()) {
                if (result < count) {
                    result = count;
                }
            }
        }

        return result;
    }
}
