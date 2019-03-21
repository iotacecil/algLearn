package leetcode;

import java.util.Arrays;

public class lc165 {
    public int compareVersion(String version1, String version2) {

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        System.out.println(Arrays.toString(v1));
        System.out.println(Arrays.toString(v2));
        int n = v1.length>v2.length?v2.length:v1.length;
        int i =0;
        for(i =0;i<n;i++){
            System.out.println(Integer.valueOf(v1[i]) +" " + Integer.valueOf(v2[i]));
            if(Integer.valueOf(v1[i]) < Integer.valueOf(v2[i]))return -1;
            else if(Integer.valueOf(v1[i]) < Integer.valueOf(v2[i]))return 1;

        }
        while(i<v2.length){
            if(Integer.valueOf(v2[i++]) !=0)return -1;
        }
        while(i<v1.length){
            if(Integer.valueOf(v1[i++]) !=0){
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        lc165 sl = new lc165();
        System.out.println(sl.compareVersion("1", "1.1"));

    }
}
