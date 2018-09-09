package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc119 {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer>list = new ArrayList<>();
        for(int i =0;i<=rowIndex;i++){
            list.add(1);//row =2 i =1->set(1) 1 1 1 //1 2 1 1 row=3
            System.out.println("nextround");
            System.out.println(list);
            for(int j=i-1;j>0;j--){//i=2,j=1 lisg[0]+list[1]= 1 2 1 1//j=2 1 2 3 1
                System.out.println(list);
                list.set(j,list.get(j-1)+list.get(j));
            }
        }
        return list;

    }

    public static void main(String[] args) {
        System.out.println(getRow(4));
    }
}
