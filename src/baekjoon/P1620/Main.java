package baekjoon.P1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] start = br.readLine().split(" ");
		int N = Integer.parseInt(start[0]);
		int M = Integer.parseInt(start[1]);

		String[] numberToName = new String[N+1];
		HashTable<String, Integer> nameToNumber = new HashTable<>();

		for (int i = 1; i < N + 1; i++) {
			String name = br.readLine();
			numberToName[i] = name;
			nameToNumber.put(name, i);
		}

		for (int i = 0; i < M; i++) {
			String question = br.readLine();

			try {
				System.out.println(numberToName[Integer.parseInt(question)]);
			} catch (NumberFormatException e) {
				System.out.println(nameToNumber.get(question));
			}

		}
	}
}

class ListNode<T> {
	T data;
	ListNode<T> next;

	public ListNode(T data) {
		this.data = data;
		this.next = null;
	}
}

class MyLinkedList<T> {
	int size;
	ListNode<T> head;

	public MyLinkedList() {
		head = null;
		size = 0;
	}

	public MyLinkedList(T data) {
		head = new ListNode<>(data);
		size = 1;
	}

	public void add(T data) {
		if (head == null) {
			head = new ListNode<>(data);
		} else {
			ListNode<T> cur = head;

			while (cur.next != null) {
				cur = cur.next;
			}

			cur.next = new ListNode<>(data);
		}
	}
}

class HashNode<K, V> {
	K key;
	V value;

	public HashNode(K key, V value) {
		this.key = key;
		this.value = value;
	}
}

class HashTable<K, V> {
	static int DEFAULT_SIZE = 128;

	MyLinkedList<HashNode<K, V>>[] buckets;
	int size;
	int bucketSize;

	public HashTable() {
		buckets = new MyLinkedList[DEFAULT_SIZE];
		size = 0;
		bucketSize = DEFAULT_SIZE;
	}

	public void put(K key, V value) {
		int index = hash(key);
		MyLinkedList<HashNode<K, V>> bucket = buckets[index];

		if (bucket == null) {
			bucket = new MyLinkedList<>();
			buckets[index] = bucket;
		}

		ListNode<HashNode<K, V>> cur = bucket.head;
		while (cur != null) {
			if (cur.data.key.equals(key)) {
				cur.data.value = value;
				return;
			}
			cur = cur.next;
		}

		bucket.add(new HashNode<>(key, value));
	}

	public V get(K key) {
		int index = hash(key);

		MyLinkedList<HashNode<K, V>> bucket = buckets[index];

		if (bucket == null) {
			return null;
		}

		ListNode<HashNode<K, V>> cur = bucket.head;
		while (cur != null) {
			if (cur.data.key.equals(key)) {
				return cur.data.value;
			}
			cur = cur.next;
		}
		return null;
	}

	private int hash(K key) {
		int hash = 0;
		for (char c : key.toString().toCharArray()) {
			hash += (int) c;
		}
		return hash % this.bucketSize;
	}
}