package leetcode;

public class lc1014 {
    private int needDay(int[] w,int zz){
        int day =1;
        int tmp =0;
        for (int i = 0; i < w.length ; i++) {
            if((tmp + w[i])<= zz){
                tmp+=w[i];
            }else{


                tmp = w[i];
                day++;
            }
        }

        return day;
    }
    public int shipWithinDays(int[] weights, int D) {
        int n = weights.length;

        int l = weights[0];int h = 0;
        for(int w:weights){
            l = Math.max(w, l);
            h+=w;
        }

        while (l+1< h){
            int mid = (l+h)/2;

            if(needDay(weights, mid) > D){
                l = mid;
            }
            else h=mid;
        }
        return needDay(weights, l)<=D?l:h;
    }

    public static void main(String[] args) {
        int[] wei = {1,2,3,1,1};
        int D = 4;
        lc1014 sl = new lc1014();
        System.out.println(sl.shipWithinDays(wei, D));
    }
}
