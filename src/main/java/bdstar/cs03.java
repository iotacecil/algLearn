package bdstar;

import java.io.BufferedInputStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

//超时
//Time Limit Exceeded	1002	3000 MS	34272 K
public class cs03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        LinkedList<Integer>[] que = new LinkedList[n+1];
        for (int i = 0; i < n+1; i++) {

            que[i] = new LinkedList<Integer>();
        }

        int q = sc.nextInt();
        while (q-->0){
           int op = sc.nextInt();
           if(op==1){
                //添加
               //233 23
                int u = sc.nextInt();
                int w = sc.nextInt();
                int val = sc.nextInt();
                if(w==0)
                que[u-1].addFirst(val);
                else if(w==1)que[u-1].addLast(val);

            }
            else if(op==2){

               int u = sc.nextInt();
               int w = sc.nextInt();
               if(u>n||que[u-1].size()<1){
                   System.out.println(-1);
                   continue;
               }
               if(w==0) {
                   Integer first = que[u - 1].getFirst();
                   que[u-1].removeFirst();
                   System.out.println(first);
               }
               else if(w==1){
                   Integer last = que[u - 1].getLast();
                   que[u-1].removeLast();
                   System.out.println(last);
               }
           }else if(op ==3){
               int u = sc.nextInt();
               int v = sc.nextInt();
               int w = sc.nextInt();
              if(w==1){
                   Collections.reverse(que[v-1]);

               }
               que[u-1].addAll(que[v-1]);
               que[v-1].clear();
           }


        }
    }
}
