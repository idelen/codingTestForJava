package baekjoon.P2042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] starts = br.readLine().split(" ");
		int N = Integer.parseInt(starts[0]);
		int M = Integer.parseInt(starts[1]);
		int K = Integer.parseInt(starts[2]);

		long[] numbers = new long[N];

		for (int i = 0; i < N; i++) {
			numbers[i] = Long.parseLong(br.readLine());
		}

		SegmentTree st = new SegmentTree(N);
		st.init(numbers, 1, 0, N-1);

		for (int i = 0; i < M+K; i++) {
			String[] commands = br.readLine().split(" ");

			int a = Integer.parseInt(commands[0]);
			int b = Integer.parseInt(commands[1]);
			long c = Long.parseLong(commands[2]);

			if (a == 1) {
				st.update(1, 0, N-1, b-1, c - numbers[b-1]);
			} else if (a == 2) {
				System.out.println(st.sum(1, 0, N-1, b-1, (int) c-1));
			}
		}
	}
}

class SegmentTree{
	long tree[];
	int treeSize;

	public SegmentTree(int N) {
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		this.treeSize = (int) Math.pow(2, h + 1);
		tree = new long[treeSize];
	}

	public long init(long[] arr, int cursor, int start, int end) {

		if (start == end) {
			return tree[cursor] = arr[start];
		}

		tree[cursor] = init(arr, cursor*2, start, (start + end) / 2)
			+ init(arr, cursor*2 + 1, (start + end) / 2 + 1, end);

		return tree[cursor];
	}

	public void update(int cursor, int start, int end, int idx, long diff) {
		if (idx < start || end < idx) {
			return;
		}

		tree[cursor] += diff;

		if (start != end) {
			update(cursor*2, start, (start + end) / 2, idx, diff);
			update(cursor*2 + 1, (start + end) / 2 + 1, end, idx, diff);
		}
	}

	public long sum(int cursor, int start, int end, int left, int right) {
		if (left > end || right < start) {
			return 0;
		}

		if (left <= start && end <= right) {
			return tree[cursor];
		}

		return sum(cursor * 2, start, (start + end) / 2, left, right) +
			sum(cursor*2 + 1, (start + end) / 2 + 1, end, left, right);
	}


}