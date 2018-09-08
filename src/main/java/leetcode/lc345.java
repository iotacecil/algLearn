public class lc345 {
    static char[] vo = new char[]{'a','e','i','o','u','A','E','I','O','U'};

    private static int indexOf(char c){
        for(int i=0;i<vo.length;i++){
            System.out.println(c+" "+vo[i]);
            if(c==vo[i]){
                return i;
            }
        }
        return -1;
    }
    public static  String reverseVowels(String s) {

        int i = 0;
        int j = s.length()-1;
        char[] ss = s.toCharArray();
        while(i<j){
            while(i<j&&indexOf(ss[i])==-1){
                System.out.println(i);
                i++;
            }
            while(i<j&&indexOf(ss[j])==-1){
                j--;
                System.out.println(j);
            }
            char tmp = ss[i];
            ss[i]=ss[j];
            ss[j]=tmp;
            i++;j--;


        }
        return new String(ss);

    }

    public static void main(String[] args) {
//        System.out.println();
        System.out.println(reverseVowels("leetcode"));
    }
}
