package leetcode;

public class lc440 {
    public int findKthNumber(int n, int k) {

        int cur = 1;
        k--;
        while(k>0){
            int gap = getGap(n,cur,cur+1);
            System.out.println(cur+" "+(cur+1)+" "+gap);
            if(k < gap){
                cur*=10;
                k--;

            }else{
                k -= gap;
                cur++;
            }
        }
        return cur;
    }

    //n1 = 1 n2 = 2 //10 11   100  1 2->10 20
    private int getGap(int n,long n1,long n2){
        int gap = 0;

        while(n1 <= n){
            if(n2 >n){
                //n = 13 n1*10 = 10  =3
                gap += n-n1+1;

            }else{
                gap += n2-n1;
            }
            n1 *=10;
            n2 *=10;
            System.out.println("\t"+n1+" "+(n2)+" "+gap);

        }

        return gap;
    }

    public static void main(String[] args) {
        lc440 sl = new lc440();
        System.out.println(sl.findKthNumber(100, 100));
    }
}
