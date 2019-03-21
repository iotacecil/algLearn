package niuke.huawei;

import java.util.*;

public class errors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
        String str = null;
        while ((str = sc.next())!= null&& !str.equals("q")){
            System.out.println(str);
            String[] strs = str.split("\\\\");

            int len = strs.length;
            int linenum = sc.nextInt();
            String filename = strs[len - 1];

            if(!map.containsKey(filename+" "+linenum)){
                map.put(filename+" "+linenum, 1);
            }else
            map.put(filename+" "+linenum, map.get(filename+" "+linenum)+1);
        }

        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((a,b)->b.getValue()-a.getValue());
        int cnt = 0;
        for(Map.Entry<String, Integer> entry:entries){
            if(cnt>=8)break;
            String[] tmp = entry.getKey().split(" ");
            String name = tmp[0];
            if(name.length()>16){
                System.out.print(name.substring(name.length() - 16, name.length()));
            }else{
                System.out.print(name);
            }
            System.out.print(" ");
            System.out.print(tmp[1]+" "+entry.getValue());
            System.out.println();
            cnt++;
        }

    }
}
