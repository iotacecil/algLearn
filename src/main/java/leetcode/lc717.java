package leetcode;

public class lc717 {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        if(n == 1 && bits[0] == 0)return true;
        int i = 0;
        if(n == 2 && (bits[0] == 0 &&bits[1] == 0))
            return true;
        while(i<n-2){
            if(bits[i] == 1 && bits[i+1] == 0 || bits[i] == 1 && bits[i+1] == 1){
                i+=2;
            }
            while (i<n-1 &&bits[i]==0){

                    i++;

            }
        }
        return i == n-1;

    }

    public static void main(String[] args) {
        int[] bits = {1,0,0,0};
        lc717 sl =new lc717();

        System.out.println(sl.isOneBitCharacter(bits));
    }
}
