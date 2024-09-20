package leetcode.No4_MedianOfTwoSortedArrays;

import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
		System.out.println(s.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
		System.out.println(s.findMedianSortedArrays(new int[]{2, 2, 4, 4}, new int[]{2, 2, 2, 4, 4}));
		System.out.println(s.findMedianSortedArrays(new int[]{3}, new int[]{-2,-1}));
	}
}

class Solution {
	static PriorityQueue<Integer> maxHeap;
	static PriorityQueue<Integer> minHeap;
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		minHeap = new PriorityQueue<>();

		for (int num : nums1) {
			addToHeap(num);
		}

		for (int num : nums2) {
			addToHeap(num);
		}

		if (maxHeap.isEmpty()) {
			return (double) 0;
		}

		if (maxHeap.size() == minHeap.size()) {
			return (double) (maxHeap.peek() + minHeap.peek()) / 2;
		} else {
			return (double) maxHeap.peek();
		}
	}

	private static void addToHeap(int num) {
		if (maxHeap.isEmpty()) {
			maxHeap.add(num);
			return;
		}
		int maxTop = maxHeap.peek();

		if (num < maxTop) {
			maxHeap.offer(num);
		} else if (minHeap.isEmpty() || num > minHeap.peek()) {
			minHeap.offer(num);
		} else {
			maxHeap.offer(num);
		}

		if (maxHeap.size() > minHeap.size() + 1) {
			minHeap.offer(maxHeap.poll());
		} else if (maxHeap.size() < minHeap.size()) {
			maxHeap.offer(minHeap.poll());
		}
	}
}