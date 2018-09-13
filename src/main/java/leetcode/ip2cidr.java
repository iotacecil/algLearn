package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ip2cidr {
    /**
     *
     *  255.0.0.7/32 覆盖1个ip，
     *  255.0.0.8/29 覆盖8个ip
     *  255.0.0.16/32 覆盖1个ip
     * @param ip ip地址又不能小于给定的ip地址，
     *           只能0->1 将最低位1后面的0进行变换，比如"255.0.0.8"末尾有3个0，可以变换出8个不同的地址。
     * @param n 覆盖n个ip地址
     * @return ["255.0.0.7/32","255.0.0.8/29","255.0.0.16/32"]
     */
    List<String> ip2cidrcoverN(String ip,int n){
        List<String> rst = new ArrayList<>();
        long x = 0;

//        while(n>0){
//            long step = x&-x;
//            while (step>n)step/=2;
//            rst.add()
//        }
        return rst;
    }

    public static void main(String[] args) {
        int n = 10;
        String ip = "255.0.0.7";
    }
}
