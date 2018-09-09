package leetcode;

import java.util.Arrays;

public class lc848 {
    public String shiftingLetters(String S, int[] shifts) {
        for(int i =shifts.length-1;shifts.length>1&&i>0;i--){
            shifts[i]%=26;
            shifts[i-1]+=shifts[i];

        }
        System.out.println(Arrays.toString(shifts));
        int z = 'z'-'a'+1;
        char[] chars = S.toCharArray();
        for(int i=0;i<chars.length;i++){
            int c = chars[i]-'a';


            c+=shifts[i];

            chars[i]=(char)(c%z+'a');
        }
        return new String(chars);
    }
    public static void main(String[] args) {
        String a = "abc";
        int z = 'z'-'a'+1;
        System.out.println(z);
        char[] chars = a.toCharArray();
        int c = chars[0]-'a';
        System.out.println(c%z);
        c+=17;
        c%=z;
        c+='a';
        System.out.println((char)c);
        System.out.println("-------------");
        lc848 sl = new lc848();
        System.out.println(sl.shiftingLetters("a", new int[]{3}));

    }
}
