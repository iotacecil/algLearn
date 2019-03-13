package leetcode;

public class lc405 {
    public String dic2hex(int num){
        String rst = "";
        String hexs = "0123456789abcdef";

        while(num != 0){
            rst = hexs.charAt((num & 15)) + rst;
            num /= 16;
        }
        return rst;
    }
    public String toHex(int num) {
        boolean nag = false;
        if(num < 0){
            nag = true;
            num = -num;
        }
        if(num == 0)return "0";
        char[] rst = new char[32];
//        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        String hexs = "0123456789abcdef";
        int idx = 31;
        int sum = 0;
        // 26 % 16 - 10, 1 %16
        // -26 % 16
        while(num > 0){
            int tmp =  num % 2;
            sum += tmp * (1<<cnt);
            cnt++;
            if(cnt == 4|| num /2 ==0){
                rst[idx--] = hexs.charAt(sum);
                cnt = 0;
                sum = 0;
            }
            num /= 2;
        }
        return new String(rst,idx+1,31-idx);

    }
// 十进制转16进制
    public String tohex(int num){
        String hexs = "0123456789abcdef";
        if(num == 0)return "0";
        String rst = "";
        while (num != 0){
            rst = hexs.charAt((num & 15))+rst;
            num = (num >>> 4);
        }
        return rst;
    }
    public static void main(String[] args) {
        lc405 sl = new lc405();
        char[] str = new char[20];
        System.out.println(new String(str, 2, 1));
        System.out.println(sl.dic2hex(26));
        System.out.println(Integer.toHexString(-15));
        System.out.println("------------");
        System.out.println(-7&7);
        System.out.println('a'^'c');
    }
}
