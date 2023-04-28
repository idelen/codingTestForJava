package leetcode.No1372_LongestZigzagPathInABinaryTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**
 *
 * It is !!! BAD !!! Case....
 *
 * */
class CustomNode {
    TreeNode node;
    int direction;

    CustomNode(TreeNode node, int direction) {
        this.node = node;
        this.direction = direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(node, direction);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        CustomNode other = (CustomNode) obj;

        return this.node == other.node && this.direction == other.direction;
    }
}

class Solution {

    private int MAX_VALUE;
    private Map<CustomNode, Integer> treeMap;

    // direction -> -1: left, 1: right
    public int longestZigZag(TreeNode root) {
        MAX_VALUE = 0;
        treeMap = new HashMap<>();

        findAll(root);

        for (CustomNode node : treeMap.keySet()) {
            MAX_VALUE = Math.max(MAX_VALUE, treeMap.get(node));
        }

        return MAX_VALUE;
    }

    private void findAll(TreeNode node) {
        findZigzag(node, -1, 0);
        findZigzag(node, 1, 0);

        if (node.left != null) {
            findAll(node.left);
        }

        if (node.right != null) {
            findAll(node.right);
        }
    }

    private int findZigzag(TreeNode node, int myDirection, int length) {
        CustomNode cNode = new CustomNode(node, myDirection);

        if (myDirection == -1) {
            if (node.left == null) {
                treeMap.put(cNode, 0);
                return 0;
            } else {
                CustomNode lNode = new CustomNode(node.left, myDirection * -1);
                int tmp;
                if (treeMap.containsKey(lNode)) {
                    tmp = treeMap.get(lNode) + length + 1;
                } else {
                    tmp = findZigzag(node.left, myDirection * -1, length + 1) + 1;
                }
                treeMap.put(cNode, tmp);
                return tmp;
            }
        } else if (myDirection == 1) {
            if (node.right == null) {
                treeMap.put(cNode, 0);
                return 0;
            } else {
                CustomNode rNode = new CustomNode(node.right, myDirection * -1);
                int tmp;
                if (treeMap.containsKey(rNode)) {
                    tmp = treeMap.get(rNode) + length + 1;
                } else {
                    tmp = findZigzag(node.right, myDirection * -1, length + 1) + 1;
                }
                treeMap.put(cNode, tmp);
                return tmp;
            }
        }
        return -1;
    }
}



