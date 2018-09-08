package leetcode;

import java.util.Hashtable;
import java.util.Map;
//小的数字（限于 Ⅰ、X 和 C）在大的数字的左边，所表示的数等于大数减小数得到的数，如 Ⅳ=4、Ⅸ=9。

public class n2i {
    public int romanToInt(String s) {
//        int nums[]=new int[s.length()];
//        for(int i =0;i<s.length();i++){
//            switch (s.charAt(i)){
//                case 'M':
//                    nums[i]=1000;
//                    break;
//                case 'D':
//                    nums[i]=500;
//                    break;
//                case 'C':
//                    nums[i]=100;
//                    break;
//                case 'L':
//                    nums[i]=50;
//                    break;
//                case 'X' :
//                    nums[i]=10;
//                    break;
//                case 'V':
//                    nums[i]=5;
//                    break;
//                case 'I':
//                    nums[i]=1;
//                    break;
//
//            }
//        }

        Map<Character,Integer> map = new Hashtable<>();
        map.put('I',1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length();
        int out = map.get(s.charAt(len-1));
        for(int i=len-2;i>=0;--i){
            int left = map.get(s.charAt(i));
            int right = map.get(s.charAt(i+1));
            if(left<right){
                out -= left;
            }else{
                out += left;
            }
        }

        return out;
    }
}
