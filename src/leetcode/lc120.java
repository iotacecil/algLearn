package leetcode;



import java.util.*;

public class lc120 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        String a = "aaaa";
//        StringBuilder b = new StringBuilder(a);
//       b.reverse()
//        b.toString();
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                System.out.println("i:"+i+"j:"+j+"add:"+triangle.get(i).get(j));
                A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
                System.out.println(Arrays.toString(A));
            }
            System.out.println("\n");
        }
        return A[0];
//        int n = triangle.size();
////2-> [5,6]->[11,10,13]->
//        int sum = Integer.MAX_VALUE;
//        List lastline = triangle.get(0);
//        for (int i = 1; i < n; i++) {
//            List newline = triangle.get(i);
//            int j = 0;
//            for (; j <= newline.size() - 2; j++) {
//                System.out.println("i"+i);
//                newline.set(j, (int) newline.get(j) + Math.min((int) lastline.get(j), (int) lastline.get(j - 1)));
//            }
//            newline.set(j, (int)newline.get(j) + (int)lastline.get(j - 1));
//            if (i == n - 1) {
//                for (Object nu :newline) {
//                    int num = (int)nu;
//                    sum = num < sum ? num : sum;
//                }
//            }
//            lastline = newline;
//        }
//        return sum;
    }
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        Deque<Integer> list = new LinkedList<>();

        System.out.println('a'+1);
        triangle.add(new ArrayList<>());
        triangle.add(new ArrayList<>());
        triangle.add(new ArrayList<>());
        triangle.add(new ArrayList<>());
        triangle.get(0).addAll(Arrays.asList(2));
        triangle.get(1).addAll(Arrays.asList(3,4));
        triangle.get(2).addAll(Arrays.asList(6,5,7));
        triangle.get(3).addAll(Arrays.asList(4,1,8,3));
minimumTotal(triangle);

    }
}
