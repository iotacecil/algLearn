package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class lc49
{
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> rst = new ArrayList<>();

        for(String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> keylist = map.getOrDefault(key, new ArrayList<>());
            if(keylist.size()==0){
                rst.add(keylist);
            }
            keylist.add(str);
            map.put(key,keylist );
        }

        return rst;

    }
public static void main(String[] args) {
    String[] list = {"eat", "tea", "tan", "ate", "nat", "bat"};
    lc49 sl = new lc49();
    System.out.println(sl.groupAnagrams(list));
}
}
