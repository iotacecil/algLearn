package niuke;
//人字形列车

/**
 * 第一行是一个整数K，表示有多少个测试用例，
 * 以后每行一个测试用例，每行为n+1个整数，
 * 第一个整数为n 表示有多少节车厢，后面n个整数表示需要编组成的顺序。
 * 比如说3节车厢，按照1，2，3依次入轨编组，可以在左边形成1 2 3，1 3 2，2 1 3，2 3 1，321。
 */
public class rentrain {
    //假设序列是1,2,3,4
    public static void main(String[] args) {
        int[] train = {4,1,3,2};
        boolean flag = false;
        int m = train.length;
        for (int i = 0; i < m ; i++) {
            for (int j = i+1; j < m; j++) {
                for (int k = j+1; k < m ; k++) {
                    if(train[i]>train[j]&&train[i]>train[k]&&train[k]>train[j]){
                        flag = true;
                        break;
                    }
                }
            }
        }
        if(!flag) System.out.println("Yes");
        else System.out.println("No");
    }
}
