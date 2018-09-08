package leetcode;

import java.util.*;

public class lc118 {
    public static List<List<Integer>> generate(int numRows) {
        if(numRows==0)return Collections.emptyList();
        List<List<Integer>> upList = new ArrayList<>();
        for(int i =0;i<numRows;i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0;j<i+1;j++){
                if(j==i||j==0)list.add(1);
                else {
//                    System.out.println(Arrays.toString(upList.get(i-1)));
                    List<Integer> tmplist = upList.get(i-1);
                    list.add(tmplist.get(j-1)+tmplist.get(j));

                }
            }
            upList.add(list);
        }
        return upList;
    }

    public static void main(String[] args) {
       List<List<Integer>> a =  generate(5);
        System.out.println(a);
    }
}
