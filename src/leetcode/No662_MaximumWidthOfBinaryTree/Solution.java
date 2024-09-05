package leetcode.No662_MaximumWidthOfBinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    private Map<Integer, Long> leftMap;
    private Map<Integer, Long> rightMap;

    public int widthOfBinaryTree(TreeNode root) {
        leftMap = new HashMap<>();
        rightMap = new HashMap<>();
        long result = 0L;

        root.val = 0;
        findWidth(root, 0L, 0);

        for (Integer depth : leftMap.keySet()) {
            result = Math.max(result, rightMap.get(depth) - leftMap.get(depth) + 1);
        }

        return (int) result;
    }

    private void findWidth(TreeNode node, long num, int depth) {
        leftMap.put(depth, Math.min(num, leftMap.getOrDefault(depth, Long.MAX_VALUE)));
        rightMap.put(depth, Math.max(num, rightMap.getOrDefault(depth, -1L)));
        if (node.left != null) {
            findWidth(node.left, 2 * num, depth + 1);
        }

        if (node.right != null) {
            findWidth(node.right, 2 * num + 1, depth + 1);
        }
    }

}
