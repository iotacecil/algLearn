package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc93 {
    public List<String> restoreIpAddresses(String s) {
    List<String> res = new ArrayList<>();
    helper(res,s,0,"",0);
    return res;
    }
    public void helper(List<String> res,String s, int index,String ret,int cnt){
        if(cnt>4)return;
        if(cnt==4&&index==s.length()){
            res.add(ret );
            return;
        }
        //取1、2、3个数
        for(int i =1;i<4;i++){
            if(index+i>s.length())break;
            String tmp = s.substring(index, index + i);
            if((tmp.startsWith("0")&&tmp.length()>1)||(i==3&&Integer.parseInt(tmp)>=256))continue;
            helper(res,s , index+i, ret+tmp+(cnt==3?"":"."),cnt+1 );
        }

    }

    public static void main(String[] args) {
        lc93 sl = new lc93();
        System.out.println(sl.restoreIpAddresses("25525511135"));
    }
}
