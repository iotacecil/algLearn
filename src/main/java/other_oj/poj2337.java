package other_oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
//jdk5 中不支持“创建范型数组”，???不能省略尖括号
//“”.join不行 join是1.8出的
//Memory Limit Exceeded
public class poj2337 {
    static private boolean check(String[] words){
        for (int i = 0; i < words.length-1; i++) {
            if(words[i].charAt(words[i].length()-1)!=words[i+1].charAt(0)){
                return false;
            }


        }
        return true;
    }
   static private String cat(String[] words){
        List<String[]> rst = new ArrayList<String[]>();
        permute(rst,words,0);
        for(String[] perwords:rst){
            if(check(perwords)){
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j <perwords.length ; j++) {

                    sb.append(perwords[j]);
                    if(j!=perwords.length-1)
                    sb.append(".");
                }
                return sb.toString();
//                return String.join(".",words);
            }
        }
        return "***";

    }
   static private void permute(List<String[]> rst,String[] words,int s){
        if(s==words.length){
            //优化把check放到这，再放个finish的flag？
            String[] ans = words.clone();
            rst.add(ans);
            return;
        }

        for(int i =s;i<words.length;i++){
            swap(words,s,i);
            permute(rst,words,s+1);
            swap(words,s,i);
        }
    }
    static private void swap(String[] words,int i,int j){
        String tmp = words[i];
        words[i]=words[j];
        words[j]=tmp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-->0){
            int wn = sc.nextInt();
            String[] words = new String[wn];
            for (int i = 0; i <wn ; i++) {
                words[i]=sc.next();

            }
            System.out.println(cat(words));

        }




    }
}
