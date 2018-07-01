package leetcode;
//vertical scanning
public class lcp2 {
    public String lcp(String[] strs){
        if(strs == null|| strs.length ==0)return "";
        for(int i = 0;i<strs[0].length();i++){
            char c = strs[0].charAt(i);
            for(int j=0;j<strs.length;j++){
                //其它串有一个匹配完了or不再匹配了
                if(i == strs[j].length()||strs[j].charAt(i)!=c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

}
