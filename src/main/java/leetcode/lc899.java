package leetcode;

import java.util.Arrays;

public class lc899 {
    //92%
    public String orderlyQueue(String S, int K) {
        char[] chars = S.toCharArray();

        if(K>1){
            Arrays.sort(chars);
            return new String(chars);
        }else{
            String res = S;
            char min = 'z';
            int idx = chars.length;
            for(int i = 0; i<chars.length; i++){

                if(chars[i]<=min){

                    idx = i;
                    min = chars[i];
                    String tmp = S.substring(idx) + S.substring(0, idx);
                    if(res.compareTo(tmp)>0)res = tmp;

                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        lc899 sl = new lc899();
        String str = "xitavoyjqiupzadbdyymyvuteolyeerecnuptghlzsynozeuuvteryojyokpufanyrqqmtgxhyycltlnusyeyyqygwupcaagtkuq";
        System.out.println(sl.orderlyQueue(str, 1));
    }
}
