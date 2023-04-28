package leetcode.No839_SimilarStringGroups;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        List<String[]> strs = new ArrayList<>();

        String[] str1 = new String[]{"tars","rats","arts","star"};
        String[] str2 = new String[]{"omv","ovm"};
        String[] str3 = new String[]{"kccomwcgcs","socgcmcwkc","sgckwcmcoc","coswcmcgkc","cowkccmsgc","cosgmccwkc","sgmkwcccoc","coswmccgkc","kowcccmsgc","kgcomwcccs"};
        String[] str4 = new String[]{"ajdidocuyh","djdyaohuic","ddjyhuicoa","djdhaoyuic","ddjoiuycha","ddhoiuycja","ajdydocuih","ddjiouycha","ajdydohuic","ddjyouicha"};
        strs.add(str1);
        strs.add(str2);
        strs.add(str3);
        strs.add(str4);

        strs.forEach(str -> System.out.println(s.numSimilarGroups(str)));

    }

}
