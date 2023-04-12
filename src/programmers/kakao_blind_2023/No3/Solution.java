package programmers.kakao_blind_2023.No3;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private boolean isEnd;
    StringBuilder tree;

    public int[] solution(long[] numbers) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<>();
        String binaryNumber;

        for (long number : numbers) {
            isEnd = false;

            // step1 : make binary
            binaryNumber = Long.toBinaryString(number);

            // step2 : convert tree
            int size = binaryNumber.length();
            int depth = 1;
            int treeSize = 1;

            while (true) {
                if (treeSize < size) {
                    treeSize += Math.pow(2, depth++);
                } else {
                    break;
                }
            }

            tree = new StringBuilder("");

            for (int gap = 0; gap < treeSize - size; gap++) {
                tree.append("0");
            }

            tree.append(binaryNumber);

            int root = treeSize / 2;

            if (tree.charAt(root) == '0') {
                isEnd = true;
            } else {
                divideAncConquer((int) (root - Math.pow(2, depth - 2)), depth - 1, false);
                divideAncConquer((int) (root + Math.pow(2, depth - 2)), depth - 1, false);
            }

            if (isEnd) {
                answerList.add(0);
            } else {
                answerList.add(1);
            }
        }

        answer = answerList.stream()
            .mapToInt(Integer::intValue)
            .toArray();

        System.out.println(answerList);

        return answer;
    }

    private void divideAncConquer(int node, int height, boolean isDummyParent) {
        int childGap = (int) Math.pow(2, height - 2);

        if (isDummyParent) {
            if (tree.charAt(node) == '0') {
                if (node % 2 == 0) {
                    return;
                } else {
                    divideAncConquer(node - childGap, height - 1, true);
                    divideAncConquer(node + childGap, height - 1, true);
                }
            } else {
                isEnd = true;
                return;
            }
        } else {
            if (tree.charAt(node) == '0') {
                if(node % 2 == 0) {
                    return;
                } else {
                    divideAncConquer(node - childGap, height - 1, true);
                    divideAncConquer(node + childGap, height - 1, true);
                }
            } else {
                if(node % 2 == 0) {
                    return;
                }
                divideAncConquer(node - childGap, height - 1, false);
                divideAncConquer(node + childGap, height - 1, false);
            }
        }
    }
}
