package programmers.kakao_blind_2023.No3;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<long[]> numbersList = Arrays.asList(new long[] {7, 42, 5, 424, 4095, 100000000000000L}, new long[] {63, 111, 95});

        for (long[] numbers : numbersList) {
            System.out.println(s.solution(numbers));
        }
    }
}
