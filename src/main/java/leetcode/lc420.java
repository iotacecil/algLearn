package leetcode;

public class lc420 {
    // 至少6 最多20
    // 必须有小写和大写字母 数字
    // 不能有3个连续的字符
    public int strongPasswordChecker(String s) {
        char[] ch = s.toCharArray();
        int[] arr = new int[ch.length];
        boolean lower = false;
        boolean uper = false;
        boolean dig = false;
        // 分析长度
        for (int i = 0; i <arr.length ; i++) {
            if(Character.isLowerCase(ch[i])) lower = true;
            if(Character.isUpperCase(ch[i])) uper = true;
            if(Character.isDigit(ch[i])) dig = true;

            int j =i;
            while (i<ch.length && ch[i] == ch[j])i++;
            // aaab 退出的时候一定是不一样的
            arr[i] = i-j;
        }
        int rst = 0;
        int miss = 0;
        if(!lower)miss++;
        if(!uper)miss++;
        if(!dig)miss++;
        // 长度<的时候只要全部补上 就ok了
        if(ch.length < 6){
            rst += miss;
           if(ch.length+miss<6){
               rst += 6-miss-ch.length;
           }
        }else {
            if (ch.length > 20) {
                int over = ch.length - 20;
                rst += over;


                // 如果要减少，减少arr[i]>=3的位置
                for (int k = 1; k < 3; k++) {
                    for (int i = 0; i < ch.length && over>0; i++) {
                        //arr[i]%3!=k-1是什么
                        if(arr[i] < 3 || arr[i] % 3 != k-1)continue;
                        arr[i] -= Math.min(over,k );
                        over -= k;
                    }

                }
                int leftover = 0;
                for (int i = 0; i < arr.length; i++) {
                    if(arr[i] >=3 && over >0){
                        int need = arr[i]-2;
                        arr[i] -= over;
                        over-= need;
                    }
                    if(arr[i]>=3)leftover+=arr[i]/3;
                }
                rst += Math.max(miss,leftover );
            }
        }
        return rst;

    }
}
