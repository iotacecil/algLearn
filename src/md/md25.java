package md;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class md25 {
    private static String psw = "12345zzxcd-2";
    public static void main(String[] args) throws NoSuchAlgorithmException {
        jdkMD5();
        int a = -6;
        for(int i =0;i<32;i++){
            //取第一位，右移

            int t = (a&0x8000000>>>i)>>>(31-i);
            System.out.println(t);
        }


    }
    public static void jdkMD5() throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        System.out.println(Arrays.toString(md.digest()));
        System.out.println(Arrays.toString(md.digest(psw.getBytes())));


    }
}
