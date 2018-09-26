package gfg.tsp.ACO;



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

//蚁群算法是一种本质上并行的算法。每只蚂蚁搜索的过程彼此独立，仅通过信息激素进行通信。
// 所以蚁群算法则可以看作是一个分布式的多agent系统
public class ACO {

    private Ant[] ants; // 蚂蚁
    private int antNum; // 蚂蚁数量
    private int cityNum; // 城市数量
    private int MAX_GEN; // 运行代数
    private float[][] pheromone; // 信息素矩阵
    private int[][] distance; // 距离矩阵
    //用贪心算一个
    private double bestScore;
    private int bestLength; // 最佳长度
    private int[] bestTour; // 最佳路径


    int budget = 480;
    private int cateNum;
    private int[] category;
    private int[] visit;
    private double[] cateScore;
    private double[] popular;

    // 三个参数
    private float alpha;
    private float beta;
    private float rho; //蒸发系数

    public ACO() {

    }

    /**
     * constructor of ACO
     *
     * @param n
     *            城市数量
     * @param m
     *            蚂蚁数量
     * @param g
     *            运行代数
     * @param a
     *            alpha
     * @param b
     *            beta
     * @param r
     *            rho
     *
     **/
    public ACO(int n, int m, int g, float a, float b, float r) {
        cityNum = n;
        antNum = m;
        ants = new Ant[antNum];
        MAX_GEN = g;
        alpha = a;
        beta = b;
        rho = r;
    }

    // 给编译器一条指令，告诉它对被批注的代码元素内部的某些警告保持静默
    @SuppressWarnings("resource")
    /**
     * 初始化ACO算法类
     * @param filename 数据文件名，该文件存储所有城市节点坐标数据
     * @throws IOException
     */
    private void init(String filename) throws IOException {
        // 读取数据
//        int[] x;
//        int[] y;
        String strbuff;
        BufferedReader data = new BufferedReader(new InputStreamReader(
                new FileInputStream(filename)));
        distance = new int[cityNum][cityNum];
//        x = new int[cityNum];
//        y = new int[cityNum];
        for (int i = 0; i < cityNum; i++) {
            // 读取一行数据，数据格式1 6734 1453
            strbuff = data.readLine();
            // 字符分割
//            String[] strcol = strbuff.split(" ");
            String[] strcol = strbuff.split(",");
            for (int j = 0; j <cityNum ; j++) {
                distance[i][j] = Integer.parseInt(strcol[j]);
            }
//            x[i] = Integer.valueOf(strcol[1]);// x坐标
//            y[i] = Integer.valueOf(strcol[2]);// y坐标
        }
        visit = new int[cityNum];
        strbuff = data.readLine();
        String[] strcol = strbuff.split(",");
        for (int i = 0; i < cityNum; i++) {
            visit[i] = Integer.parseInt(strcol[i]);
        }
        strbuff = data.readLine();
        cateNum = Integer.parseInt(strbuff);
        strbuff = data.readLine();
        strcol = strbuff.split(",");
        category = new int[cityNum];
        for (int i = 0; i <cityNum ; i++) {
            category[i] = Integer.parseInt(strcol[i]);
        }
        strbuff = data.readLine();
        strcol = strbuff.split(",");
        cateScore = new double[cateNum+1];
        for (int i = 0; i <cateNum+1 ; i++) {
            cateScore[i] = Double.parseDouble(strcol[i]);
        }
        strbuff = data.readLine();
        strcol = strbuff.split(",");
        popular = new double[cityNum];
        for (int i = 0; i <cityNum ; i++) {
            popular[i] = Double.parseDouble(strcol[i]);
        }



//
////         计算距离矩阵
////         针对具体问题，距离计算方法也不一样，此处用的是att48作为案例，它有48个城市，距离计算方法为伪欧氏距离，最优值为10628
//        for (int i = 0; i < cityNum - 1; i++) {
//            distance[i][i] = 0; // 对角线为0
//            for (int j = i + 1; j < cityNum; j++) {
//                double rij = Math
//                        .sqrt(((x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j])
//                                * (y[i] - y[j])) / 10.0);
//                // 四舍五入，取整
//                int tij = (int) Math.round(rij);
//                if (tij < rij) {
//                    distance[i][j] = tij + 1;
//                    distance[j][i] = distance[i][j];
//                } else {
//                    distance[i][j] = tij;
//                    distance[j][i] = distance[i][j];
//                }
//            }
//        }
        System.out.println(Arrays.deepToString(distance));
        distance[cityNum - 1][cityNum - 1] = 0;
        // 初始化信息素矩阵
        pheromone = new float[cityNum][cityNum];
        for (int i = 0; i < cityNum; i++) {
            for (int j = 0; j < cityNum; j++) {
                pheromone[i][j] = 0.1f; // 初始化为0.1
            }
        }
        bestLength = Integer.MAX_VALUE;
        bestScore=0;
        bestTour = new int[cityNum + 1];
        // 随机放置蚂蚁
        for (int i = 0; i < antNum; i++) {
            ants[i] = new Ant(cityNum);

            ants[i].init(distance, alpha, beta,visit,cateNum,category,cateScore,popular);
        }
    }

    public void solve() {
        // 迭代MAX_GEN次
        for (int g = 0; g < MAX_GEN; g++) {
            // antNum只蚂蚁
            for (int i = 0; i < antNum; i++) {
                // i这只蚂蚁走cityNum步，完整一个TSP
                System.out.println(ants[i].allowedCities);
                while (ants[i].curcost<budget&&ants[i].allowedCities.size()>0){
                    ants[i].selectNextCity(pheromone);

                }
//                for (int j = 1; j < cityNum; j++) {
//                    ants[i].selectNextCity(pheromone);
//                }

                System.out.println("第"+g+"次迭代 第"+i+"只蚂蚁");
                System.out.println("找到的路线"+ants[i].tabu);
                if(ants[i].curcost+distance[ants[i].tabu.get(ants[i].tabu.size()-1)][0]>budget){
                    System.out.println("超了~~~~~");
                    continue;
                }
//                System.out.println("score+"+ants[i].curscore);
                // 查看这只蚂蚁行走路径距离是否比当前距离优秀
                if (ants[i].curscore> bestScore) {
                    // 比当前优秀则拷贝优秀TSP路径

//                    System.out.println("更新score");
                    bestScore = ants[i].curscore;
                    // 回到起点 起点不算分
                    bestLength = ants[i].curcost+distance[ants[i].tabu.get(ants[i].tabu.size()-1)][0];

                    ants[i].getTabu().add(ants[i].getFirstCity());
                    for (int k = 0; k < ants[i].tabu.size(); k++) {
                        bestTour[k] = ants[i].getTabu().get(k).intValue();
                    }
                }
                // 更新这只蚂蚁的信息数变化矩阵，对称矩阵
                for (int j = 0; j <  ants[i].tabu.size()-1; j++) {
//                    ants[i].getDelta()[ants[i].getTabu().get(j).intValue()][ants[i]
//                            .getTabu().get(j + 1).intValue()] = (float) (1. / ants[i]
//                            .getScore());
                    ants[i].getDelta()[ants[i].getTabu().get(j).intValue()][ants[i]
                            .getTabu().get(j + 1).intValue()] = (float) (ants[i].curscore/(ants[i]
                            .curcost));
//                    System.out.println((float) (ants[i].curscore/(ants[i]
//                            .curcost)));

//                    ants[i].getDelta()[ants[i].getTabu().get(j + 1).intValue()][ants[i]
//                            .getTabu().get(j).intValue()] = (float) (ants[i]
//                            .curscore);
                }
//                System.out.println("delta: ");
//                System.out.println(Arrays.deepToString(ants[i].getDelta()));
//                System.out.println("Score+cost: ");
//                System.out.println(ants[i].curscore);
//                System.out.println(ants[i].curcost);
            }
            // 更新信息素
            updatePheromone();
            // 重新初始化蚂蚁
            if(g==MAX_GEN-1)break;
            for (int i = 0; i < antNum; i++) {
                ants[i].init(distance, alpha, beta,visit,cateNum,category,cateScore,popular);
            }
        }

        // 打印最佳结果
        printOptimal();
    }

    // 更新信息素
    private void updatePheromone() {
        // 信息素挥发
        for (int i = 0; i < cityNum; i++)
            for (int j = 0; j < cityNum; j++)
                pheromone[i][j] = pheromone[i][j] * (1 - rho);
        // 信息素更新
        for (int i = 0; i < cityNum; i++) {
            for (int j = 0; j < cityNum; j++) {
                for (int k = 0; k < antNum; k++) {
                    pheromone[i][j] += ants[k].getDelta()[i][j];
                }
            }
        }
    }

    private void printOptimal() {
        System.out.println("The optimal length is: " + bestLength);
        System.out.println("best score: "+bestScore);
        System.out.println("The optimal tour is: ");
        for (int i = 0; i < cityNum + 1; i++) {
            System.out.print (bestTour[i]+" ");
        }
    }


    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Start....");
        ACO aco = new ACO(10, 10, 100, 1.f, 5.f, 0.5f);
        aco.init("src/main/java/gfg/tsp/ACO/commonTest");
        aco.solve();
    }

}

