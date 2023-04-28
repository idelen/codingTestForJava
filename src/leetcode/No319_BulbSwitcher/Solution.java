package leetcode.No319_BulbSwitcher;

public class Solution {

    public int bulbSwitch(int n) {
        for (int i = 0; i <= n + 1; i++) {
            if (Math.pow(i, 2) > n) {
                return i - 1;
            }
        }
        return 0;
    }

}
