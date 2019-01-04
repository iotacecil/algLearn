package niuke.tecent;

import java.util.Arrays;

/**
 * 您的代码已保存
 请检查是否存在数组越界非法访问等情况
 case通过率为10.00%
 */
public class huajiaxiaoq {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        char[][] map = new char[n][m];
        int n = 2;
        int m = 2;
        char[][] map = {{'G','G'},{'G','G'}};
//        for (int i = 0; i <n ; i++) {
//            String next = sc.next();
////            System.out.println(next);
//            for (int j = 0; j <m ; j++) {
//                map[i][j] = next.charAt(j);
//            }
//            }


        int cnt =0;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                if(map[i][j] == 'Y'){
                    dfs(map,i,j,'Y');
                    cnt++;
                }else if(map[i][j] == 'B'){
                    dfs(map,i,j,'B');
                    cnt++;
                }else if(map[i][j] =='G'){
                    dfs(map,i,j,'Y');

                    cnt++;
                    dfs(map,i,j,'B');
                    cnt++;

                }


            }

        }
        System.out.println(cnt);
    }

    private static void dfs(char[][] map,int i,int j,char target){
        if(i < 0|| i >= map.length||j<0 || j>=map[0].length || map[i][j] =='X')return;
        if(target=='Y'&&map[i][j] =='B')return;
        if(target=='B'&&map[i][j] =='Y')return;

        if(map[i][j] == target){
            map[i][j] ='X';
        }else if(map[i][j] =='G'){
            map[i][j] = ((target=='Y')?'B':'Y');
        }
        System.out.println(Arrays.deepToString(map));
        System.out.println(i+" "+j);
        if(target == 'Y'){
            dfs(map,i+1,j+1,target);
            dfs(map,i-1,j-1,target);
        }else if(target == 'B'){
            dfs(map,i-1,j+1,target);
            dfs(map,i+1,j-1,target);
        }
    }


}
