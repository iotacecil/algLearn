package niuke.weipinhui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListParamTest {
    public static void resetList(List<Integer> dataList) {
        dataList.subList(2,4).set(0,40);
        System.out.println(dataList);
        dataList = new ArrayList<Integer>(dataList);
        dataList.add(50);
    }
    public static void setOne(List<Integer> dataList) {
        dataList.set(3,100);
    }
    public static void main(String[] args){
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;

        System.out.println(f1 == f2);
        System.out.println(f3 == f4);
        List<Integer> dataList = new ArrayList<Integer>(Arrays.asList(10,20,30,null));
        resetList(dataList);
        setOne(dataList);
        int sum = 0;
        for(Integer v:dataList){
            sum +=v;
        }
        System.out.println(sum);
    }
}
