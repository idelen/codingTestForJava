package baekjoon.P11438;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] depth;
	static int[][] parent;
	static int maxH;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		List<Integer>[] treeMap = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			treeMap[i] =  new ArrayList<>();
		}

		StringTokenizer st = null;
		for (int i = 0 ; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			treeMap[a].add(b);
			treeMap[b].add(a);
		}

		maxH = (int) Math.ceil(Math.log(N) / Math.log(2));
		parent = new int[N + 1][maxH + 1];
		parent[1][0] = 1;
		depth = new int[N + 1];

		init(1, 0, 0, treeMap);

		fillAllParents(parent);

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			System.out.println(findLCA(a, b));
		}

		System.out.println();
	}

	private static void init(int cursor, int h, int paInt, List<Integer>[] treeMap) {
		depth[cursor] = h;
		for (int child : treeMap[cursor]) {
			if (child != paInt) {
				init(child, h + 1, cursor, treeMap);
				parent[child][0] = cursor;
			}
		}
	}

	private static void fillAllParents(int[][] parent) {
		for (int h = 1; h < parent[0].length; h++) {
			for (int cursor = 2; cursor < parent.length; cursor++) {
				parent[cursor][h] = parent[parent[cursor][h-1]][h-1];
			}
		}
	}

	private static int findLCA(int a, int b) {
		int ah = depth[a];
		int bh = depth[b];

		if(ah < bh) {
			int tmp = a;
			a = b;
			b = tmp;
		}

		for (int i=maxH; i>=0; i--) {
			if(Math.pow(2, i) <= depth[a] - depth[b]){
				a = parent[a][i];
			}
		}
		if(a==b) return a;

		for(int i=maxH; i>=0; i--) {
			if(parent[a][i] != parent[b][i]) {
				a = parent[a][i];
				b = parent[b][i];
			}
		}
		return parent[a][0];
	}
}