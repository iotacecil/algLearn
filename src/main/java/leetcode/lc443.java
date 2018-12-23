package leetcode;

public class lc443 {
    public static void main(String[] args) {
//        char[] chars = {'a','a','b','b','c','c','c'};
        char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        lc443 sl = new lc443();
        System.out.println(sl.compress(chars));
    }


    public int compress(char[] chars){
        int n = chars.length;
        int idx = 0;int i = 0;
        while (idx < n){
            char cur = chars[idx];
            int cnt = 0;
            while (idx < n && chars[idx] == cur)
            {
                idx++;
                cnt++;
            }
            chars[i++] = cur;
            if(cnt != 1){
                for(char c:Integer.toString(cnt).toCharArray()){
                    chars[i++] = c;
                }
            }
        }
        return i;

    }



    // 错误 因为 aa bb aa 应该 a2b2a3
    public int compressWrong(char[] chars) {
        int[] cnt = new int[256];
        int n = chars.length;
        boolean nocomp = true;
        for(int i =0;i < n;i++){
            cnt[chars[i]]++;
            if(cnt[chars[i]]>2)nocomp = false;
        }
        if(nocomp)return chars.length;
       int idx = 0;
       int i = 0;
//       int rst = 0;
       while (idx < chars.length)
       {
           chars[i] = chars[idx];
           int num = cnt[chars[idx]];
           if(num > 1){
               if(num >= 10){
                   String s = Integer.toString(num);
                   for (int j = 0; j <s.length() ; j++) {
                       chars[++i] = s.charAt(j);

                   }
               }else
               chars[++i] = (char)( num+'0');

           }
           idx += num;
           i++;
       }
//        System.out.println(Arrays.toString(chars));
       return i;
    }


}
