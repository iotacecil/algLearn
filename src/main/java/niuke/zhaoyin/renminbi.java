package niuke.zhaoyin;
import java.util.*;
//链接：https://www.nowcoder.com/questionTerminal/00ffd656b9604d1998e966d555005a4b?commentTags=Java
public class renminbi {
    public static String[] RMB = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    public static String[] unit1 = {"元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟"};
    public static String[] unit2 = {"角", "分"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            String result = "";
            if(s.contains(".")) {
                String s1 = s.substring(s.indexOf('.') + 1);
                String s2 = s.substring(0, s.indexOf('.'));
                result = "人民币" + integer(s2) + decimal(s1);
            } else
                result = "人民币" + integer(s) + "整";
            System.out.println(result);
        }
    }
    // 处理整数
    public static String integer(String s) {
        if(s.length() == 1 && s.charAt(0) == '0') return "";//RMB[0]+unit1[0];
        int[] arr = new int[s.length()];
        int idx = 0;
        for (int i = s.length()-1; i >= 0; i -- )
            arr[idx++] = s.charAt(i)-'0';
        StringBuilder sb = new StringBuilder();
        boolean zero = false;
        for (int i = 0; i < arr.length; i ++ ) {
            if(!zero && arr[i] == 0){
                sb.append(RMB[arr[i]]);
                zero = true;
            }else if (arr[i] != 0){
                sb.append(unit1[i] + RMB[arr[i]]);
                zero = false;
            }
        }
        sb = sb.reverse();
        if(sb.charAt(0) == '壹' && sb.charAt(1) == '拾') sb.deleteCharAt(0);
        return sb.toString();
    }
    // 处理小数
    public static String decimal(String s) {
        StringBuilder sb = new StringBuilder();
//        boolean zero = true;


        for (int i = s.length()-1; i >=0; i -- ) {
            int tmp = s.charAt(i)-'0';
            if( tmp ==0)continue;
            // 1分 0角 输出角
//            if(!zero || tmp > 0){
//                sb.append(unit2[i] + RMB[tmp] );
//                zero = false;
//            }
            //不输出角
            sb.append(unit2[i] + RMB[tmp] );

        }
        return sb.length()<1?"整":sb.reverse().toString();
    }
}
