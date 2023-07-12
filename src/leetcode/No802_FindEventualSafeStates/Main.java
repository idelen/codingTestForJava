package leetcode.No802_FindEventualSafeStates;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution802 s = new Solution802();

        System.out.println(s.eventualSafeNodes(new int[][] {{1,2},{2,3},{5},{0},{5},{},{}}));
        System.out.println(s.eventualSafeNodes(new int[][] {{},{0,2,3,4},{3},{4},{}}));
    }
}


class Solution802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        Set<Integer> terminalSet = new HashSet<>();
        Map<Integer, Set<Integer>> reverseGraph = new HashMap<>();
        List<Integer> queue = new ArrayList<>();

        for (int idx = 0; idx < n; idx++) {
            int[] edge = graph[idx];

            if (edge.length == 0) {
                terminalSet.add(idx);
                queue.add(idx);
            } else {
                for (int node : edge) {
                    Set<Integer> tmp = reverseGraph.getOrDefault(node, new HashSet<>());
                    tmp.add(idx);
                    reverseGraph.put(node, tmp);
                }
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.remove(0);
            Set<Integer> nodes = reverseGraph.getOrDefault(cur, new HashSet<>());

            for (int node : nodes) {
                if (terminalSet.contains(node)) {
                    continue;
                }

                int[] childNodes = graph[node];
                boolean isSafe = true;

                for (int child : childNodes) {
                    if (!terminalSet.contains(child)) {
                        isSafe = false;
                        break;
                    }
                }

                if (isSafe) {
                    terminalSet.add(node);
                    queue.add(node);
                }
            }
        }

        List<Integer> answer = new ArrayList<>(terminalSet);
        Collections.sort(answer);

        return answer;
    }
}