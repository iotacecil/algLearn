package niuke.changkao;

import java.util.*;

// 每次从下往上对折纸 求折痕数组
public class zhezhi {
    public static void main(String[] args) {
        zhezhi sl = new zhezhi();
        System.out.println(Arrays.toString(sl.foldPaper(5)));
    }
    public String[] foldPaperstack(int n) {
        List<String> rst = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();
        String[] r = new String[rst.size()];

//        String[] r2 = new String[(int)(Math.pow(2,n )-1)];
//
//        inorder(n,r2,"down",0);
//        System.out.println(Arrays.toString(r2));
        return rst.toArray(r);
    }
    public String[] foldPaper(int n) {
    List<String> rst = new ArrayList<>();
       inorder(n,rst,"down");
       String[] r = new String[rst.size()];
//        String[] r2 = new String[(int)(Math.pow(2,n )-1)];
//
//        inorder(n,r2,"down",0);
//        System.out.println(Arrays.toString(r2));
        return rst.toArray(r);
    }
    private void inorder(int n, List<String> rst, String str){
        if(n<=0)return;
        inorder(n-1,rst,"down");
        rst.add(str);
        inorder(n-1,rst,"up");

    }
    private void inorder(int n, String[] rst, String str, int idx){
        if(n<=0)return;
        inorder(n-1,rst,"down",idx+1);
        rst[idx] = str;
        inorder(n-1,rst,"up",idx+1);

    }
}
