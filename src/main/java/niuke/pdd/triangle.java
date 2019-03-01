package niuke.pdd;

import java.util.Scanner;

/*


给出平面上的n个点，现在需要你求出，在这n个点里选3个点能构成一个三角形的方案有几种。
 */
public class triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i <n ; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        int cnt = 0;
        for (int i = 0; i <n-2 ; i++) {
            for (int j = i+1; j <n-1 ; j++) {
                for (int k = j+1; k <n ; k++) {
                    int x1 = arr[i][0];
                    int y1 = arr[i][1];
                    int x2 = arr[j][0];
                    int y2 = arr[j][1];
                    int x3 = arr[k][0];
                    int y3 = arr[k][1];
                    int a = (x1-x2)*(y1-y3) ;
                    int b = (y1-y2)*(x1-x3);
                    if(a!=b)cnt++;
//                    if(can(arr[i],arr[j], arr[k])){
//                        cnt++;
//                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
