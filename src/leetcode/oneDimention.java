package leetcode;

public class oneDimention {
    static int min(int x,int y,int z)
    {
        if (x<=y && x<=z) return x;
        if (y<=x && y<=z) return y;
        else return z;
    }
    static int mindis(String word1,String word2){
        int lena = word1.length();
        int lenb = word2.length();
        int[] d = new int[lenb+1];
        for(int j =0;j<=lenb;j++){
            d[j]=j;
        }
        int old =0;
        for(int i =0;i<lena;i++){
            //记录左上角的old临时
            d[0] =i;
            for(int j =0;j<lenb;j++){
                int tmp = d[j];
                if (word1.charAt(i)==word2.charAt(j)){
                    d[j] = old;
                }else{
                    d[j] = min(d[j]+1,d[i]+1,d[old]+1);
                }
                old=tmp;
            }
        }
        return d[lenb];
    }
    public static void main(String[] args) {
        String str1 = "horse";
        String str2 = "ros";

        System.out.println(mindis( str1 , str2 ) );

    }
}
