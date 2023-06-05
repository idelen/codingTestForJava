package leetcode.No1376_TimeNeededToInformAllEmployees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        List<Integer> nList = Arrays.asList(15, 11);
        List<Integer> headIdList = Arrays.asList(0, 4);
        List<int[]> managerList = Arrays.asList(new int[] {-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6},
            new int[] {5,9,6,10,-1,8,9,1,9,3,4});
        List<int[]> informTimeList = Arrays.asList(new int[] {1,1,1,1,1,1,1,0,0,0,0,0,0,0,0},
            new int[] {0,213,0,253,686,170,975,0,261,309,337});

        for (int t = 0; t < nList.size(); t++) {
            System.out.println(s.numOfMinutes(nList.get(t), headIdList.get(t), managerList.get(t), informTimeList.get(t)));
        }
    }
}

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int result = 0;

        for (int idx = 0; idx < n; idx++) {
            if (informTime[idx] == 0 && manager[idx] != -1) {
                int nowTime = 0;
                int curEmployee = idx;
                int nowManager;

                while(true) {
                    nowManager = manager[curEmployee];
                    nowTime += informTime[nowManager];

                    if (nowManager == headID) {
                        break;
                    }

                    curEmployee = nowManager;
                }

                result = Math.max(result, nowTime);
            }
        }
        return result;
    }

//    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
//        int result = 0;
//        Map<Integer, List<Integer>> companyMap = new HashMap<>();
//        int count = 0;
//
//        for (int i = 0; i < manager.length; i++) {
//            int nowManager = manager[i];
//
//            List<Integer> temp;
//            if (companyMap.containsKey(nowManager)) {
//                temp = companyMap.get(nowManager);
//            } else {
//                temp = new ArrayList<>();
//            }
//            temp.add(i);
//            companyMap.put(nowManager, temp);
//        }
//
//        System.out.println(companyMap);
//
//        List<Integer> queue = new ArrayList<>();
//        queue.add(headID);
//        count++;
//
//        while (!queue.isEmpty() && count != n) {
//            List<Integer> newQueue = new ArrayList<>();
//            int nowTime = 0;
//            for (int nowHead : queue) {
//                List<Integer> employeeList = companyMap.getOrDefault(nowHead, Collections.emptyList());
//
//                nowTime = Math.max(nowTime, informTime[nowHead]);
//
//                count += employeeList.size();
//                newQueue.addAll(employeeList);
//            }
//            System.out.println("result And nowTime : " + result + ", " + nowTime);
//            result += nowTime;
//            queue = newQueue;
//        }
//
//        return result;
//    }
}
