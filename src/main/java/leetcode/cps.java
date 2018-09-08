package leetcode;
//找到一个与String数组中都匹配的前缀
public class cps {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) return "";
        //string的最大位数，Int的最大值2147483647
        int minLen = 0x7fffffff;
        for(String s : strs){
            //都匹配所以最短的也匹配
            minLen = Math.min(minLen,s.length());
        }
        //对每个位置，遍历匹配每个字符串
        for(int i =0;i<minLen;i++){
            for(int j = 0;j<len;j++){
                if(strs[0].charAt(i)!=strs[j].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }

        }
        //最短的一条都匹配上了
        return strs[0].substring(0,minLen);

    }
}
