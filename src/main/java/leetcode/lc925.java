package leetcode;

public class lc925 {
    public boolean isLongPressedNameCnt(String name, String typed) {
        int ls1 = name.length();
        int ls2 = typed.length();
        if (ls1 < 1 || ls2 < ls1) {
            return false;
        }
        int p2 = 0;
        int p1 = 0;

        while (p2 < ls2){
            if(p1 < ls1 && name.charAt(p1) == typed.charAt(p2)){
                p1++;
                p2++;
            }
            // 关键
            else if(p1>0 && name.charAt(p1-1) == typed.charAt(p2)){
                p2++;
            }
            // 关键
            else return false;
        }
        return p1 == ls1;
    }
    public boolean isLongPressedName(String name, String typed) {
        int ls1 = name.length();
        int ls2 = typed.length();
        if (ls1 < 1 || ls2 < ls1) {
            return false;
        }
        int p1 = 0;
        int p2 = 0;
        while(p1 < ls1 && p2 <ls2) {
            char tmp = name.charAt(p1);
            int cnt = 1;
            while (p1 + 1 < ls1 && name.charAt(p1) == name.charAt(p1 + 1)) {
                cnt++;
                p1++;
            }
            if(tmp != typed.charAt(p2)){
                return false;
            }
            while (p1 < ls1 && p2 < ls2 && tmp == typed.charAt(p2)) {
                p2++;
                cnt--;
            }
            p1++;
        }



        while(p2 < ls2-1){
            if(typed.charAt(p2) !=  typed.charAt(p2+1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

//        String name = "saeed";
//        String typed = "ssaaedd";

//        String name = "alex";
//        String typed = "aaleex";

        String name = "leelee";
        String typed = "lleeelee";
        lc925 sl = new lc925();
        System.out.println(sl.isLongPressedNameCnt(name, typed));
    }
}
