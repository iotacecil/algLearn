package niuke.baidu;

import java.util.Scanner;

public class maozi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int v1 = Integer.MAX_VALUE;
        int v2 = Integer.MAX_VALUE;
        int v3 = Integer.MAX_VALUE;
        for(int i = 0 ;i<N;i++){
            int v = sc.nextInt();
            if(v < v1){
                v1 = v;
            }else if(v>v1&&v<v2){
                v2 = v;
            }else if(v>v1&&v>v2&&v<v3){
                v3 = v;
            }
        }
        System.out.println(v3==Integer.MAX_VALUE?-1:v3);
    }
}
