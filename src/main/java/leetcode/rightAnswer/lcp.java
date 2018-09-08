package leetcode.rightAnswer;

class Solution7{
    public String longest(String[] str){
        String prefix = str[0];
        for(int i =1;i<str.length;i++){
            //先和第2个比，得出最长前缀，拿最长前缀和第3个比
            while(str[i].indexOf(prefix)!=0){
                //没有匹配上,剪短第一个字符串
//                System.out.println(str[i].indexOf(prefix));
                prefix = prefix.substring(0,prefix.length()-1);
//                System.out.println(prefix);
                if(prefix.isEmpty())return "";
            }
        }
        return prefix;
    }
}
public class lcp {
    public static void main(String[] args){
        Solution7 sl = new Solution7();
        String[] str = new String[]{"abc","ab","abadd",""};

        char[] source= new char[]{'a','a','b','d','a','f'};
        char first = 'a';
        int max = source.length;
        for(int i =0;i<source.length;i++){
        if (source[i] != first) {
            while (++i <= max && source[i] != first);
        }
        if(i<=max){
            int j =i+1;
        }
        }
        System.out.println("0and1:"+str[1].indexOf(str[0]));
        System.out.println(sl.longest(str));
    }
}
