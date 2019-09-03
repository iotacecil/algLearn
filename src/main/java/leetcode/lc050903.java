package leetcode;

public class lc050903 {
    public String longestPalindrome(String s) {
        int n = s.length();
        int max = 1;
        String str = s.charAt(0)+"";

        for(int i = 0;i<n-1;i++){
            int ji = help(s,i,i);
            int ou = help(s,i,i+1);
            System.out.println(i+" "+ji+" "+ou);
            if(ji>ou&& ji>max){
                max = ji;
                // max = 3 i = 1  left = 1-1=0
                str = s.substring(i-max/2,i+max/2+1);
              //  System.out.println(max+" "+str);
            }else if(ou >ji && ou>max){
                max = ou;
                //max = 4 i = 3  2345   [2][3][4][5]

                // ou = 2 i-max/2+1 i = 1
                // out = 4
                str = s.substring(i-max/2+1,i+max/2+1);
            }


        }
        return str;


    }

    private int help(String s,int l,int r){
        // 这个是中间
        //l = 0,r= 0, l+1,j-1  j-1-l
        while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
            l--;r++;
        }
        return r-l-1;

    }

    public static void main(String[] args) {
        lc050903 sl = new lc050903();
        System.out.println(sl.longestPalindrome("cbbd"));
    }
}
