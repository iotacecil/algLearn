package ltc;

import java.util.HashMap;
import java.util.Map;

public class lt1580 {
    /** WA abc->cac是可以的 //todo nexttime
     *a->b, b->d, c->e
     "abc"->"abe"->"ade"->"cde"
     * @param startString startString = "abc" ;
     * @param endString endString = "cde"
     * @return
     */
    public boolean canTransfer(String startString, String endString) {
        if (startString.length() != endString.length()){
            return false;
        }
        Map<Character,Character> s2e = new HashMap<>();
        Map<Character,Character> e2s = new HashMap<>();
        for (int i = 0; i <startString.length() ; i++) {
            char ss = startString.charAt(i);
            char es = endString.charAt(i);
            if(!s2e.containsKey(ss))s2e.put(ss,es);
            if(!e2s.containsKey(es))e2s.put(es,ss );
            if(s2e.get(ss)!=es||e2s.get(es)!=ss){
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        lt1580 sl = new lt1580();
        System.out.println(sl.canTransfer("abc", "cac"));
    }
}
