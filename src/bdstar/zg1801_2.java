package bdstar;

import java.util.List;
import java.util.Scanner;


public class zg1801_2 {

    private static boolean distinct(int m,int subset, String wj1, String wj2) {
        for (int i =0;i<m;i++) {

            if (((1<<i)&subset)!=1&&wj1.charAt(i) != wj2.charAt(i)) {
//                System.out.println(subset);

                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
//        int T = 2;
            int Tcnt=1;
            while (Tcnt<=T) {
                //问卷数量
                int n = sc.nextInt();
                //问题数量

                int m = sc.nextInt();
                int k = sc.nextInt();
                //如果至少两对不同，问卷数量的组合数少于k return 0
                //如果只取一位，只有A,B ->  ABABABA->?几对不同？
                String[] wjs = new String[n];
                for (int i = 0; i < n; i++) {
                    wjs[i] = sc.next();
                }
                // ABA BAB,ABA BAB ,ABA ABA
                //

//          问卷组合  12 13 14 .. 23 24... n-1 n



                //问卷数量的组合数
                //(1,2)->(ABA BAB,BAB ABB ..)+1
                //1 subset
                //问题集合subset
//4个问题0001..1111
                int subsetcnt=0;
                for (int sub = 1;sub<(1<<m);sub++) {
                    //对于这个问题组合能有几张问卷是不同的
                    int cnt = 0;
                    String a = "aaa";
                    
                    //不用两个for,只比较里面有多少个问卷是A,放到问卷的二进制里
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = i; j < n; j++) {
                            String wj1 = wjs[i];
                            String wj2 = wjs[j];
                            if (distinct(m,sub, wj1, wj2)) {
//                            System.out.println(i+" "+j);
                                cnt++;
                            }
                            if(cnt>=k)break;
                        }
                    }
                    if(cnt>=k)subsetcnt++;
                }
                System.out.println("Case #"+(Tcnt)+": "+subsetcnt);
                Tcnt++;

            }
        }


}
