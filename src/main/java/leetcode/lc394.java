package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class lc394 {

    public String decodeString(String s) {
        Map<String,String> map = new HashMap<>();
        map.put("{", "}");
        System.out.println(map.containsValue("}"));
        String res = "";
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<String> strs = new ArrayDeque<>();
        int idx = 0;
        while(idx < s.length()){
            if(Character.isDigit(s.charAt(idx))){
                int tmp = 0;
                while (Character.isDigit(s.charAt(idx))){
                    tmp = 10*tmp + (s.charAt(idx) - '0');
                    idx++;
                }
                nums.push(tmp);
            }
            else if(s.charAt(idx) == '['){
                // 关键
                strs.push(res);
                res = "";
                idx ++;
            }
            else if(s.charAt(idx) == ']'){
                // res = c tmps = a num = 2 res = acc tmps="" res = acc*3
                StringBuilder tmps =new StringBuilder(strs.pop());
                int num = nums.pop();
                for (int i = 0; i <num ; i++) {
                    //关键
                    tmps.append(res);
                }
                // 关键
                res = tmps.toString();
                idx++;

            }else{
                res += s.charAt(idx++);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        lc394 sl = new lc394();
        System.out.println(sl.decodeString("3[a2[c]]"));
    }


}
