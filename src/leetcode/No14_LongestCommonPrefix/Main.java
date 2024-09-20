package leetcode.No14_LongestCommonPrefix;

import java.util.Objects;

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		// System.out.println(s.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
		// System.out.println(s.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
		System.out.println(s.longestCommonPrefix(new String[]{""}));
	}
}

class Solution {
	public String longestCommonPrefix(String[] strs) {
		Trie trie = new Trie();
		for (String str : strs) {
			if (Objects.equals(str, "")) {
				return "";
			}
			trie.insert(str);
		}

		return trie.commonPrefix();
	}
}

class TrieNode {
	TrieNode[] children = new TrieNode[26];
	boolean isEnd;

	public TrieNode() {
		for (int i = 0; i < 26; i++) {
			children[i] = null;
		}
	}
}

class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode node = root;

		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (node.children[index] == null) {
				node.children[index] = new TrieNode();
			}
			node = node.children[index];
		}
		node.isEnd = true;
	}

	public String commonPrefix() {
		StringBuilder sb = new StringBuilder();

		TrieNode node = root;

		while (node != null && !node.isEnd) {
			int childCount = 0;
			int index = 0;

			for (int i = 0; i < 26; i++) {
				if (node.children[i] != null) {
					childCount++;
					index = i;
				}
			}

			if (childCount != 1) {
				break;
			}

			sb.append((char) ('a' + index));
			node = node.children[index];
		}

		return sb.toString();
	}
}