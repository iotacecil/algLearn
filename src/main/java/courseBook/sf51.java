package courseBook;

/**
 *  n 个集装箱要装上两艘载重量分别为 c1 和 c2 的轮船
 */
public class sf51 {
    int n = 5;
    int sumWeight = 160;
    int[] w = {0,20,40,50,20,30};
    int c1 = 70,c2=100;
    int[] bestLoad = new int[n+1];
    int[] nowLoad = new int[n+1];
    int tmpWight;
    int bestW;
    int restW = sumWeight;
    //第t个物品
    private void backTrack(int t){
        if(t>n){
            //更新best
            for (int i = 1; i <n ; i++) {
                bestLoad[i] = nowLoad[i];
            }
            bestW = tmpWight;
            return;
        }
        restW -= w[t];
        //装c1
        if(tmpWight+w[t]<=c1){
            tmpWight+=w[t];
            nowLoad[t] = 1;
            backTrack(t+1);
            tmpWight -=w[t];
        }
//        如果c1不装t 1已经装的+剩下所有箱子是否超过最优解
        if(restW+tmpWight>bestW){
            nowLoad[t] = 0;
            backTrack(t+1);
        }
        restW += w[t];
    }
    public static void main(String[] args) {
        sf51 sl = new sf51();
        sl.backTrack(1);
        // s2装得下装c1剩下的
        if(sl.c2>=sl.sumWeight-sl.bestW){
            for(int i:sl.bestLoad){
                System.out.print(i+" ");
            }
        }
    }
}
