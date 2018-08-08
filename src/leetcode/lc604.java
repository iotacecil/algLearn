package leetcode;

//https://leetcode.com/articles/desing-compressed-string-iterator/



//StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");
//
//        iterator.next(); // return 'L'
//        iterator.next(); // return 'e'
//        iterator.next(); // return 'e'
//        iterator.next(); // return 't'
//        iterator.next(); // return 'C'
//        iterator.next(); // return 'o'
//        iterator.next(); // return 'd'
//        iterator.hasNext(); // return true
//        iterator.next(); // return 'e'
//        iterator.hasNext(); // return false
//        iterator.next(); // return ' '

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Arrays;

//方法1：
// 问题：complete uncompressed string could become so large that it can't fit in the memory limits, leading to memory overflow.
//时间/空间复杂度都是 不压缩string的长度
//Solution1: Uncompressing the String [Time Limit Exceeded]
class StringIterator{
    StringBuilder sb = new StringBuilder();

    StringIterator(String s){
        int i =0;

        while (i<s.length()){
            char c = s.charAt(i++);
            int num = 0;
            int test =0;
            while(i<s.length()&&Character.isDigit(s.charAt(i))){
                //l12->lllllll...
                num = num+s.charAt(i)-'0';
                i++;
            }
            for (int j = 0; j <num ; j++) {
                sb.append(c);
            }
        }
    }
    int p=0;
    public char next(){
        if(!hasNext())return ' ';
        return sb.charAt(p++);
    }
    public boolean hasNext(){
        return p!=sb.length();
    }
}

//方法2：

class StringItertor2{
    int p=0;
    int[] nums;
    String[] chars;
    StringItertor2(String cmprs){
        nums = Arrays.stream(cmprs.substring(1).split("[a-zA-z]")).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(nums));
        chars = cmprs.split("[0-9]+");
        System.out.println(Arrays.toString(chars));

    }
    public char next() {
        if(!hasNext()){
            return ' ';
        }
        nums[p]--;
        char out = chars[p].charAt(0);
        if(nums[p]==0)
            p++;
        return out;
    }
    public boolean hasNext() {
        return p!=chars.length;
    }
}

// 方法3:
class StringIterator3{
    String res;
    int p=0,num=0;
    char ch = ' ';
    StringIterator3(String cpr){
        res = cpr;
    }
    public char next(){
        if(!hasNext())
            return ' ';
            if(num==0){

                ch = res.charAt(p++);
                while (p<res.length()&&Character.isDigit(res.charAt(p))){
                    num = num*10+res.charAt(p++)-'0';
                }
            }
            num--;
            return ch;




    }
    public boolean hasNext(){
        return p!=res.length()||num!=0;
    }
}



public class lc604 {
    public static void main(String[] args) {
        StringIterator3 iterator = new StringIterator3("L1e2t1C1o1d1e1");


        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
    }

}
