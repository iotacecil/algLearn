package leetcode;



public class lc14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length<1)return "";
        String rst = strs[0];
        for(int i =1;i<strs.length;i++){
            while(strs[i].indexOf(rst)!=0){
                rst =rst.substring(0,Math.min(rst.length()-1,strs[i].length()));
            }
        }
        return rst;
    }
}
