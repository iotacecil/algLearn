package gfg;

import java.util.ArrayDeque;
import java.util.Deque;

public class minreversebracket {
    private int minReversal(String s){
        int len = s.length();
        if((len&1)!=0)return -1;
        Deque<Character> que = new ArrayDeque<>();
        int n=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='}'&&!que.isEmpty()){
                if(que.peek()=='{')que.pop();
                else {
                    que.push(c);
                }
            }else{
                que.push(c);
            }
        }
        int mn = que.size();
        while (!que.isEmpty()&&que.peek()=='{'){
            que.pop();
            n++;
        }
        //当m+n是偶数的时候ceil(n/2)+ceil(m/2)=
        return (mn/2+n%2);
    }
//    private int simplecnt(String s){
//        int cnt = 0,res=0;
//        Deque<Character> que = new ArrayDeque<>();
//        for (int i = 0; i <s.length() ; i++) {
//            if(s.charAt(i)=='{'){
//                que.push('{');
//                cnt++;
//                continue;
//            }
//            if(s.charAt(i)=='}'&&!que.isEmpty()&&que.peek()=='{'){
//                que.pop();
//                cnt--;
//                continue;
//            }
//            if(s.charAt(i)=='}'&&que.isEmpty()){
//                que.push('{');
//                res++;
//                cnt++;
//            }
//
//        }
//        return res;
//    }

    public static void main(String[] args) {
        minreversebracket sl = new minreversebracket();
        System.out.println(sl.minReversal("}{{}}{{{"));
//        System.out.println(sl.simplecnt("}{{}}{{{"));
        System.out.println(sl.minReversal("{{{{}}"));
//        System.out.println(sl.simplecnt("{{{{}}"));
        System.out.println(sl.minReversal("{{{{"));
//        System.out.println(sl.simplecnt("{{{{"));

    }
}
