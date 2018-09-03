package dsLearn;

public class substringbacku {
    private static int search(String pat,String txt){
        int i,N = txt.length();
        int j,M = pat.length();
        for (i = 0,j=0; i <N&&j<M ; i++) {
            if(txt.charAt(i)==pat.charAt(j))j++;
            else{
                i-=j;
                j=0;
            }

        }
        if(j==M)return i-M;
        else return -1;
    }
    public static void main(String[] args) {
        System.out.println(search("ADAC", "ABACADABRAC"));
    }
}
