package leetcode.No407_TrappingRainWater2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.trapRainWater(new int[][] {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}}));
		System.out.println(s.trapRainWater(new int[][] {{3,3,3,3,3},{3,2,2,2,3},{3,2,1,2,3},{3,2,2,2,3},{3,3,3,3,3}}));
	}
}

class Solution {
	public int trapRainWater(int[][] heightMap) {
		int result = 0;

		int m = heightMap.length;
		int n = heightMap[0].length;
		int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		boolean[][] visited = new boolean[m][n];

		// {x, y, h}
		PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparing(a -> a[2]));

		for (int i = 0; i < m; i++) {
			priorityQueue.offer(new int[]{i, 0, heightMap[i][0]});
			priorityQueue.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
			visited[i][0] = true;
			visited[i][n - 1] = true;
		}
		for (int j = 0; j < n; j++) {
			priorityQueue.offer(new int[]{0, j, heightMap[0][j]});
			priorityQueue.offer(new int[]{m - 1, j, heightMap[m - 1][j]});
			visited[0][j] = true;
			visited[m - 1][j] = true;
		}

		while (!priorityQueue.isEmpty()) {
			int[] poll = priorityQueue.poll();
			int x = poll[0], y = poll[1];

			for (int[] direction : directions) {
				int nx = x + direction[0], ny = y + direction[1];
				if (nx > 0 && nx < m && ny > 0 && ny < n && !visited[nx][ny]) {
					visited[nx][ny] = true;
					int nowHeight = heightMap[nx][ny];

					result += Math.max(0, poll[2] - nowHeight);
					priorityQueue.offer(new int[]{nx, ny, Math.max(nowHeight, poll[2])});
				}
			}

		}
		return result;
	}
}
