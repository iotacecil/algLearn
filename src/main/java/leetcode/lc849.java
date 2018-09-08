package leetcode;

public class lc849 {
    //还是有问题
    public int maxDistToClosest(int[] seats) {

        int left = 0;
        int len = seats.length-1;
        int right = 0;
        int gapmax = 0;
        int rplace = 0;
       for(int i =0;i<seats.length;i++){

           if(seats[i]==1) {
               //left  = 0,right = 0
               left = right;
               right = i;
               i++;

               while (i < len && seats[i] != 1) i++;
               if (i<len&&seats[i] == 1) {
                   //left = 0,right = 4
                   left = right;
                   right = i;
               }
           }
           //4-0
           if(right-left>gapmax){
               gapmax = right-left;
               rplace = left+gapmax/2;

           }
       }
        System.out.println(left+" "+right);

        if(right ==left){
           if(right==0&&len>0)return len;
           if(right==len&&len>0)return len;
           else return Math.max(len-right,right);
       }
       if(seats[0]==0&&left==0&&right==len)return right-left;
       return (int)gapmax/2;
    }

    public static void main(String[] args) {
        lc849 sl = new lc849();
        System.out.println(sl.maxDistToClosest(new int[]{1,0,1}));
    }
}
