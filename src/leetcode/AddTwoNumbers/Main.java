package leetcode.AddTwoNumbers;

import java.util.ArrayList;

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int upper = 0;
        int nowSum = 0;

        ArrayList<Integer> resultList = new ArrayList<>();
        resultList.add((l1.val + l2.val) % 10);
        upper = (l1.val + l2.val) / 10;
        while (l1.next != null || l2.next != null || upper != 0) {
            l1 = (l1.next != null) ? l1.next : new ListNode();
            l2 = (l2.next != null) ? l2.next : new ListNode();

            nowSum = l1.val + l2.val + upper;

            resultList.add(nowSum % 10);
            upper = nowSum / 10;
        }

        ListNode result = new ListNode(resultList.get(resultList.size() - 1));

        for (int i = resultList.size() - 2; i >= 0; i--) {
            result = new ListNode(resultList.get(i), result);
        }

        return result;
    }
}


public class Main {

    public static void main(String[] ars) {
        Solution s = new Solution();
        //입력요소를 선언해줘야 출력값이 나옴
        int[][] l1List = {
            {2, 4, 3},
            {0},
            {9, 9, 9, 9, 9, 9, 9}
        };
        int[][] l2List = {
            {5, 6, 4},
            {0},
            {9, 9, 9, 9}
        };

        for (int i = 0; i < 3; i++) {
            int l1Length = l1List[i].length;
            ListNode l1;
            if (l1Length != 1) {
                l1 = new ListNode(l1List[i][l1Length - 1]);

                for (int j = l1Length - 2; j >= 0; j--) {
                    l1 = new ListNode(l1List[i][j], l1);
                }
            } else {
                l1 = new ListNode(l1List[i][0]);
            }

            int l2Length = l2List[i].length;
            ListNode l2;
            if (l2Length != 1) {
                l2 = new ListNode(l2List[i][l2Length - 1]);
                for (int j = l2Length - 2; j >= 0; j--) {
                    l2 = new ListNode(l2List[i][j], l2);
                }
            } else {
                l2 = new ListNode(l2List[i][0]);
            }

            ListNode result = s.addTwoNumbers(l1, l2);

            System.out.print("[" + result.val + ",");
            while (result.next != null) {
                result = result.next;
                System.out.print(result.val + ",");
            }
            System.out.println("]");
        }
    }
}

