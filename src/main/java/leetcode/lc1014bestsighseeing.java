package leetcode;

public class lc1014bestsighseeing {
    public int maxScoreSightseeingPair(int[] A) {
        int n = A.length;
        int[] score = new int[n];
        score[0] = A[0];
        int rst = 0;
        int idx = 0;
        for(int i = 1;i<n;i++){
            rst = Math.max(rst,A[i]+score[i-1]-i);
           // System.out.println(score[i-1]+" "+rst);
            if(score[i-1] <= A[i]+i){

                score[i] = A[i]+i;
                //idx = i;
            }else
                score[i] = score[i-1];

        }
        return rst;
    }

    public static void main(String[] args) {
        lc1014bestsighseeing sl = new lc1014bestsighseeing();
        System.out.println(sl.maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
    }
}
