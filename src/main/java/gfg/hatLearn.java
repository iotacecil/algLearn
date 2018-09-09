package gfg;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//3
//        5 100 1
//        2
//        5 100
public class hatLearn {


    private byte[] m_;
    HashMap<Integer,List<Integer>>hatss;
    private int cntWay(List<List<Integer>> persons){
        //有这顶帽子的都有谁

        hatss = new HashMap<>();
//        int[][]hats = new int[101][persons.size()];//way?
        for(int i =0;i<persons.size();i++){
            for(int j=0;j<persons.get(i).size();j++){
                if(hatss.containsKey(persons.get(i).get(j))){
                    List<Integer> integers = hatss.get(persons.get(i).get(j));
                    integers.add(i);
                }else {
                    ArrayList<Integer> hat = new ArrayList<>();

                    hat.add(i);

                    hatss.put(persons.get(i).get(j), hat);
                }
            }
        }
        System.out.println(hatss);
        allmask = (1<<persons.size())-1;
        int way=0;
        return way;
    }
    static int allmask;
    private int way(int mask,int i){
        //所有人都有帽子了
        if(mask == allmask)return 1;
        //没有帽子了
        if(i>100)return 0;
        int ans = way(mask,i+1);

        int size = hatss.get(i).size();
        for (int j = 0; j < size; j++) {
//            int per = (mask)&(hatss)

        }
        return 1;

    }

    public static void main(String[] args) {
        int n = 3;
        List<List<Integer>>  persons = new ArrayList<>(3);
        persons.add(Arrays.asList(5,100,1));
        persons.add(Arrays.asList(2));
        persons.add(Arrays.asList(5,100));
        System.out.println(persons);
        hatLearn sl = new hatLearn();
        System.out.println(sl.cntWay(persons));

    }
}
