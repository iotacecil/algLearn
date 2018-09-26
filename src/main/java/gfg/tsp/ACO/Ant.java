package gfg.tsp.ACO;


import java.util.*;

public class Ant implements Cloneable {

    public Vector<Integer> tabu; // 禁忌表
    public Vector<Integer> allowedCities; // 允许搜索的城市
    private float[][] delta; // 信息数变化矩阵
    private int[][] distance; // 距离矩阵
    private float alpha;
    private float beta;

    int[] categoryCnt;

    int budget = 480;

    private int tourLength; // 路径长度
    private int cityNum; // 城市数量
    private int firstCity; // 起始城市
    private int currentCity; // 当前城市



    public double curscore;
    public int curcost;
    private int cateNum;
    private int[] category;
    private int[] visit;
    private double[] cateScore;
    private double[] popular;


    public Ant() {
        cityNum = 30;
        tourLength = 0;
    }

    /**
     * Constructor of Ant
     *
     * @param num
     *            蚂蚁数量
     */
    public Ant(int num) {
        cityNum = num;
        tourLength = 0;
    }

    /**
     * 初始化蚂蚁，随机选择起始位置
     *
     * @param distance
     *            距离矩阵
     * @param a
     *            alpha
     * @param b
     *            beta
     */

    public void init(int[][] distance, float a, float b,int[] visit,int cateNum,int[] category,double[] cateScore,double[] popular) {
        alpha = a;
        beta = b;
        categoryCnt = new int[5];
        // 初始允许搜索的城市集合
        allowedCities = new Vector<Integer>();
        // 初始禁忌表
        tabu = new Vector<Integer>();
        // 初始距离矩阵
        this.distance = distance;
        this.visit = visit;
        this.cateNum = cateNum;
        this.cateScore = cateScore;
        this.popular = popular;
        this.category = category;

      //  System.out.println(Arrays.toString(popular));

        // 初始信息数变化矩阵为0
        delta = new float[cityNum][cityNum];
        for (int i = 0; i < cityNum; i++) {
            Integer integer = new Integer(i);
            allowedCities.add(integer);
            for (int j = 0; j < cityNum; j++) {
                delta[i][j] = 0.f;
            }
        }

        // 随机挑选一个城市作为起始城市
//        Random random = new Random(System.currentTimeMillis());
//        firstCity = random.nextInt(cityNum);
        firstCity = 0;
        curcost = visit[0];
        curscore=0.0;
        // 允许搜索的城市集合中移除起始城市

        for (Integer i : allowedCities) {
            if (i.intValue() == firstCity) {
                allowedCities.remove(i);
                break;
            }
        }
        // 将起始城市添加至禁忌表
        tabu.add(Integer.valueOf(firstCity));
        // 当前城市为起始城市
        currentCity = firstCity;
        Arrays.fill(categoryCnt, 1);
        categoryCnt[category[0]]++;

    }


    /**
     *
     * 选择下一个城市
     *
     * @param pheromone
     *            信息素矩阵
     */

    public void selectNextCity(float[][] pheromone) {
//        System.out.println(Arrays.deepToString(pheromone));

        float[] p = new float[cityNum];
        float sum = 0.0f;
        int tmpsize = allowedCities.size();

        List<Integer> toremove = new ArrayList<>();
        //删除不能超出budget的点
        for(Integer i:allowedCities){
            if(curcost+distance[tabu.get(tabu.size()-1)][i]+visit[i]+distance[i][0]>budget){
                toremove.add(i);
            }
        }
        for(Integer rmv:toremove){
            allowedCities.remove(rmv);
        }
        if(allowedCities.isEmpty())return;
//        System.out.println("准备计算分母"+allowedCities);
//        System.out.println(Arrays.deepToString(pheromone));
        // 计算分母部分
        for (Integer i : allowedCities) {
            sum += Math.pow(pheromone[currentCity][i.intValue()], alpha)
                    * Math.pow(1.0 / distance[currentCity][i.intValue()], beta);
        }
//        System.out.println("分母部分 "+sum);
        // 计算概率矩阵
        for (int i = 0; i < cityNum; i++) {
            boolean flag = false;
            for (Integer j : allowedCities) {
                if (i == j.intValue()) {
                    p[i] = (float) (Math.pow(pheromone[currentCity][i], alpha) * Math
                            .pow(1.0 / distance[currentCity][i], beta)) / sum;
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                p[i] = 0.f;
            }
        }
//        System.out.println("概率");
//        System.out.println(Arrays.toString(p));
        // 轮盘赌选择下一个城市
        Random random = new Random(System.currentTimeMillis());
//        Random random = new Random();
        float sleectP = random.nextFloat();
        int selectCity = 0;
        float sum1 = 0.f;
        for (int i = 0; i < cityNum; i++) {
            sum1 += p[i];
            if (sum1 >= sleectP) {
                selectCity = i;
                break;
            }
        }
//        System.out.println("curcity: "+currentCity+" 选择 "+selectCity);

        //算分
        curcost+=(distance[currentCity][selectCity]+visit[selectCity]);

        if(curcost+distance[selectCity][0]<budget){
            curscore+=scoreInRoute(categoryCnt,currentCity ,selectCity);
//            System.out.println("加分"+scoreInRoute(categoryCnt,currentCity ,selectCity));
//            System.out.println("当前总分"+curscore);
            categoryCnt[category[selectCity]]++;
        }

        // 从允许选择的城市中去除select city
        for (Integer i : allowedCities) {
            if (i.intValue() == selectCity) {
                allowedCities.remove(i);
                break;
            }
        }

        // 在禁忌表中添加select city
        tabu.add(Integer.valueOf(selectCity));
      //  System.out.println("添加路线"+tabu);
      //  System.out.println("-----------------");
        // 将当前城市改为选择的城市
        currentCity = selectCity;
    }
     double ita = .5;
     double profit(int poiID){
//        return ita * popular[poiID] + (1 - ita) * weight[poiID];
        return ita*popular[poiID]+(1-ita)*cateScore[category[poiID]];
    }
    private double scoreInRoute(int[] count,int from,int to){
        return profit(to) / ((double)count[category[to]]/cityNum*(distance[from][to]+visit[to]));
    }


    /**
     * 计算当前除去起点终点的得分
     * @return
     */
//    private double calculateToureScore(){
//         //不算起点score
//        score = 0.0;
//        int cost =visit[0];
//        int[] categoryCnt = new int[5];
//        categoryCnt[category[0]]++;
////0,2,3,4 size = 4 -1=3 0-2 2-3 3-4
//        for (int i = 0; i <tabu.size()-1 ; i++) {
//
//            cost+=(distance[tabu.get(i)][tabu.get(i + 1)]+visit[i]);
//            if(cost>budget)return -1;
//
//            score+=scoreInRoute(categoryCnt,tabu.get(i) ,tabu.get(i + 1));
//            categoryCnt[category[i]]++;
//        }
//
//        System.out.println(score);
//        return score;
//    }



    /**
     * 计算路径长度
     *
     * @return 路径长度
     */
    private int calculateTourLength() {
        int len = 0;
//        System.out.println(tabu);
        //禁忌表tabu最终形式：起始城市,城市1,城市2...城市n,起始城市
        for (int i = 0; i < cityNum; i++) {
            len += distance[this.tabu.get(i).intValue()][this.tabu.get(i + 1)
                    .intValue()];
        }
        return len;
    }

    public Vector<Integer> getAllowedCities() {
        return allowedCities;
    }

    public void setAllowedCities(Vector<Integer> allowedCities) {
        this.allowedCities = allowedCities;
    }

    public int getTourLength() {
        tourLength = calculateTourLength();
        return tourLength;
    }

    public void setTourLength(int tourLength) {
        this.tourLength = tourLength;
    }

    public int getCityNum() {
        return cityNum;
    }

//    public double getScore(){
//        return score;
//    }
    public void setCityNum(int cityNum) {
        this.cityNum = cityNum;
    }

    public Vector<Integer> getTabu() {
        return tabu;
    }

    public void setTabu(Vector<Integer> tabu) {
        this.tabu = tabu;
    }

    public float[][] getDelta() {
        return delta;
    }

    public void setDelta(float[][] delta) {
        this.delta = delta;
    }

    public int getFirstCity() {
        return firstCity;
    }

    public void setFirstCity(int firstCity) {
        this.firstCity = firstCity;
    }

}
