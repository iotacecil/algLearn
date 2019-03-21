package niuke.huawei;

import java.util.Scanner;

public class puke {
    private static boolean is2Joker(String[] strs){
        if(strs.length!=2)return false;
        if(strs[0].equals("joker") && strs[1].equals("JOKER")){
            return true;
        }else if(strs[1].equals("joker") && strs[0].equals("JOKER")){
            return true;
        }
        return false;
    }

    private static boolean iszd(String[] strs) {
        if(strs.length!=4)return false;
        for (int i = 1; i <strs.length ; i++) {
            if(!strs[i].equals(strs[i-1])){
                return false;
            }
        }
        return true;
    }
    private static void print(String[] strs){
        for(String str:strs){
            System.out.print(str);
        }
    }
    private static int sum(String[] strs){
        int sum = 0;
        for(String str:strs){
            sum+=levels.indexOf(str);
        }
        return sum;
    }

static String levels = "3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER";
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String[] two = sc.nextLine().split("-");
            String[] left = two[0].split(" ");
            String[] right = two[1].split(" ");
            if(is2Joker(right)){
                System.out.println(two[1]);
            }else if(is2Joker(left)) {
                System.out.println(two[0]);
            }else
            if(iszd(left) || iszd(right)){
                if(iszd(left) && iszd(right))
                System.out.println( levels.indexOf(left[0])<levels.indexOf(left[1])?two[1]:two[0]);
                else if(iszd(left)) System.out.println(two[0]);
                else if(iszd(right)) System.out.println(two[1]);
            }else{
                if(left.length!=right.length) System.out.println("ERROR");
                else if (sum(left)>sum(right)) {
                    System.out.println(two[0]);
                }else if(sum(left)<sum(right)){
                    System.out.println(two[1]);
                }
            }
        }
    }
}
