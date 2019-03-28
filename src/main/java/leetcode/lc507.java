package leetcode;

public class lc507 {
    public boolean checkPerfectNumber(int num) {
        int sum = 0;
        //         List<Integer> rst = new ArrayList<>();
        for (int i = 1; i <=num/2 ; i++) {
            if(num%i==0){
                sum+=(i);
                System.out.println(i);
                //  rst.add(i);
            }
        }
        System.out.println(sum);

        if(sum == num)return true;
        return false;
    }

    public static void main(String[] args) {
        lc507 sl = new lc507();
        System.out.println(sl.checkPerfectNumber(28));
    }
}
