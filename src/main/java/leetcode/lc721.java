package leetcode;

import java.util.Map;

public class lc721 {
    private String find(String s,Map<String,String> p){
        return p.get(s) == s? s:find(p.get(s),p );
    }
//    public List<List<String>> accountsMerge(List<List<String>> acts) {
//        Map<String,String> owner = new HashMap<>();
//        Map<String,String> parents = new HashMap<>();
//        Map<String,TreeSet<String>> unions = new HashMap<>();
//        for(List<String> a : acts){
//            for (int i = 1; i <a.size() ; i++) {
//                parents.put(a.get(i), a.get(i));
//                owner.put(a.get(i), a.get(0));
//            }
//        }
//        for(List<String> a : acts){
//            String p = find(a.get(1), )
//        }
//    }
}
