package ltc;

import java.util.PriorityQueue;

public class lt848 {
    /**
     1.stations.length 为整数，范围 [10, 2000].
     2.stations[i] 为整数，范围 [0, 10^8].
     3.K 为整数，范围 [1, 10^6].
     4.答案范围在10 ^ -6之内的有理数。
     * @param stations
     * @param k
     * @return
     */
    public double minmaxGasDist(int[] stations, int k) {
        double left = 0,right = 1e8;
        while (right - left > 1e-6){
            double mid = left + (right - left)/2;
            if(helper(stations, k, mid)){
                right = mid;
            }else{
                left = mid;
            }
        }
        return right;
    }

    private boolean helper(int[] stations, int k,double mid){
        int cnt = 0, n = stations.length;
        for (int i = 0; i < n-1; i++) {
            // 关键 如果这个是最小间距 ，这个间距需要切几刀
            cnt += (stations[i + 1] - stations[i]) / mid;
        }
        return cnt <= k;
    }



        //贪心错误
    public double minmaxGasDistWrong(int[] stations, int k) {
        PriorityQueue<Double> gaps = new PriorityQueue<>((a,b)->b-a>0?1:-1);
        int n = stations.length;
        for (int i = 1; i < n; i++) {
            gaps.add((double)(stations[i] - stations[i-1]));
        }

        while (k>0){
            Double biggap = gaps.poll();
            gaps.add(biggap/2);
            gaps.add(biggap/2);
            k--;
        }
        double bigest = 0;
        while (!gaps.isEmpty()){
            Double big = gaps.poll();
            if (big >bigest) {
                bigest = big;
            }
        }
        return bigest;
    }

    public static void main(String[] args) {
        lt848 sl = new lt848();
        double v = sl.minmaxGasDist(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 9);
        System.out.println(v);

    }

}
