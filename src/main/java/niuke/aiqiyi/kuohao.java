package niuke.aiqiyi;
/*


())(())((()))))()((())))()())())())()()()

 */
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class kuohao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Deque<Character> stk = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(stk.isEmpty() || c =='(')stk.push(c);
            else if(c==')' && stk.peek()=='('){
//                System.out.println(stk);

                stk.pop();
            }else{
                stk.push(c);
            }
        }
//        System.out.println(stk);
        System.out.println(stk.size());
    }
}
