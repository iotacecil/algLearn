package leetcode;

public class lc344 {
    public void reverseString(char[] s) {

        int j = s.length - 1;
        int i = 0;
        while (i < j) {
            char tmp = s[j];
            s[j] = s[i];
            s[i] = tmp;
            i++;j--;
        }
    }

    public static void main(String[] args) {
        char[] arr = {'h','e','l','l','o'};
        (new lc344()).reverseString(arr);
        System.out.println(arr);
    }
}
