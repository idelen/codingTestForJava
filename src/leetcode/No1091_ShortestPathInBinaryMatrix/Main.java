package leetcode.No1091_ShortestPathInBinaryMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        List<int[][]> gridList = Arrays.asList(new int[][] {{0,1},{1,0}},
            new int[][] {{0,0,0},{1,1,0},{1,1,0}},
            new int[][] {{1,0,0},{1,1,0},{1,1,0}},
            new int[][] {{0,0,1,0},{1,0,1,0},{1,1,0,1},{0,0,0,0}}
        );

        for (int t = 0; t < gridList.size(); t++) {
            System.out.println(s.shortestPathBinaryMatrix(gridList.get(t)));
        }

    }
}

class Solution {

    private static List<int[]> directions = Arrays.asList(new int[] {0, 1}, new int[] {1, 1}, new int[] {1, 0}, new int[] {1, -1},
        new int[] {0, -1}, new int[] {-1, -1}, new int[] {-1, 0}, new int[] {-1, 1});
    public int shortestPathBinaryMatrix(int[][] grid) {
        int result = 0;
        int n = grid.length;

        if (grid[0][0] != 0 || grid[n-1][n-1] != 0) {
            result = -1;
        } else {
            int[][] visited = new int[n][n];
            List<int[]> queue = new ArrayList<>();
            queue.add(new int[] {0, 0});
            visited[0][0] = 1;

            while (!queue.isEmpty()) {
                result++;
                List<int[]> newQueue = new ArrayList<>();

                for (int[] nowCur : queue) {
                    for (int[] direction : directions) {
                        if (!isWall(nowCur, direction, n)) {
                            int x = nowCur[0] + direction[0];
                            int y = nowCur[1] + direction[1];

                            if (x == n-1 && y == n-1) {
                                newQueue = Collections.emptyList();
                                return result+1;
                            }

                            if (grid[x][y] == 0 && visited[x][y] == 0) {
                                newQueue.add(new int[] {x, y});
                                visited[x][y] = 1;
                            }
                        }
                    }
                }

                queue = newQueue;
            }

        }

        return result;
    }

    private boolean isWall(int[] cur, int[] direction, int n) {
        int x = cur[0] + direction[0];
        int y = cur[1] + direction[1];

        return x < 0 || x >= n || y < 0 || y >= n;
    }

}