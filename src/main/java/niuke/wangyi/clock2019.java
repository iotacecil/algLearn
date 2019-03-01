//package niuke.wangyi;
//
//import java.util.Scanner;
//
//public class clock2019 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        for (int i = 0; i <n ; i++) {
//            System.out.println(sc.next());
//
//        }
//    }
//
//    private String change(String s){
//        String[] splits = s.split(":");
//        Integer hour = Integer.valueOf(splits[0]);
//        if(hour > 23){
//            if(splits[0].charAt(1) > '0')splits[0] = "1"+s.charAt(1);
//            else splits[0] = "0"+s.charAt(1);
//        }
//
//        Integer mimutes = Integer.valueOf(splits[1]);
//        if(mimutes > 59){
//
//                if(splits[1].charAt(1) > '0')splits[0] = "1"+s.charAt(1);
//                else splits[1] = "0"+s.charAt(1);
//        }
//
//    }
//}
