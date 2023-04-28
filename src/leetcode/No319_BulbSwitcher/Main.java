package leetcode.No319_BulbSwitcher;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nArray = new int[]{3, 0, 1};

        for(int n : nArray) {
            System.out.println(s.bulbSwitch(n));
        }
    }
}
