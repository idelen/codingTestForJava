package baekjoon.P1656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue maxHeap = new PriorityQueue(N/2 + 2);
		PriorityQueue minHeap = new PriorityQueue(N/2 + 1);


		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(br.readLine());

			if (maxHeap.isEmpty()) {
				maxHeap.maxPush(number);
			} else {
				int maxHeapTop = maxHeap.getTopValue();

				if (maxHeapTop > number) {
					maxHeap.maxPush(number);
				} else {
					if (minHeap.isEmpty()) {
						minHeap.minPush(number);
					} else {
						int minHeapTop = minHeap.getTopValue();
						if (minHeapTop < number) {
							minHeap.minPush(number);
						} else {
							maxHeap.maxPush(number);
						}
					}
				}

				// 리밸런싱
				if (maxHeap.index < minHeap.index) {
					int minPop = minHeap.minPop();
					maxHeap.maxPush(minPop);
				} else if (maxHeap.index > minHeap.index + 1) {
					int maxPop = maxHeap.maxPop();
					minHeap.minPush(maxPop);
				}
			}

			System.out.println(maxHeap.getTopValue());
		}
	}
}

class PriorityQueue {
	int[] heap;
	int index;
	int maxSize;

	public PriorityQueue(int size) {
		this.heap = new int[size + 1];
		this.maxSize = size;
		this.index = 0;
	}

	public void maxPush(int number) {
		if (index >= maxSize) {
			return;
		}
		heap[++index] = number;

		for (int i = index; i > 1; i /= 2) {
			if (heap[i/2] < heap[i]) {
				swap(i, i/2);
			} else {
				break;
			}
		}
	}

	public void minPush(int number) {
		if (index >= maxSize) {
			return;
		}
		heap[++index] = number;

		for (int i = index; i > 1; i /= 2) {
			if (heap[i/2] > heap[i]) {
				swap(i, i/2);
			} else {
				break;
			}
		}
	}

	public int maxPop() {
		if (index < 1) {
			return Integer.MIN_VALUE;
		}
		int result = heap[1];
		heap[1] = heap[index];
		heap[index--] = Integer.MIN_VALUE;

		for (int i = 1; i * 2 <= index; ) {
			if (heap[i] > heap[i*2] && heap[i] > heap[i*2+1]) {
				break;
			} else if (heap[i*2] > heap[i*2+1]) {
				swap(i, i*2);

				i = i*2;
			} else {
				swap(i, i*2+1);

				i = i*2 + 1;
			}
		}
		return result;
	}

	public int minPop() {
		if (index < 1) {
			return Integer.MIN_VALUE;
		}
		int result = heap[1];
		heap[1] = heap[index];
		heap[index--] = Integer.MAX_VALUE;

		for (int i = 1; i * 2 <= index; ) {
			if (heap[i] < heap[i*2] && heap[i] < heap[i*2+1]) {
				break;
			} else if (heap[i*2] < heap[i*2+1]) {
				swap(i, i*2);

				i = i*2;
			} else {
				swap(i, i*2+1);

				i = i*2 + 1;
			}
		}
		return result;
	}

	public boolean isEmpty() {
		return index == 0;
	}

	public int getTopValue() {
		return heap[1];
	}

	private void swap(int idx, int jdx) {
		int temp = heap[idx];
		heap[idx] = heap[jdx];
		heap[jdx] = temp;
	}
}