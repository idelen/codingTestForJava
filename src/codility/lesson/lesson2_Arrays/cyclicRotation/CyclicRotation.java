package codility.lesson.lesson2_Arrays.cyclicRotation;

import java.util.Arrays;

public class CyclicRotation {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = new int[] {};
        int K = 4;

        System.out.println(Arrays.toString(s.solution(A, K)));
    }
}

class Solution {
    public int[] solution(int[] A, int K) {
        // Implement your solution here
        int length = A.length;

        if (length == 0) {
            return A;
        }

        int shiftCnt = K % length;

        int[] shiftArray = new int[length];

        for (int i =  0; i < shiftCnt; i++) {
            shiftArray[i] = A[length - shiftCnt + i];
        }

        for (int i = 0; i < length - shiftCnt; i++) {
            shiftArray[i + shiftCnt] = A[i];
        }

        return shiftArray;
    }
}