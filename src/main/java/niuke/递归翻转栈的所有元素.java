package niuke;

import java.util.Arrays;

public class 递归翻转栈的所有元素 {
    private void move_bottom_to_top(int[] stk,int top){
        if(top==0)return;
        int peek = stk[top - 1];
        top--;
        if(top>0){
            move_bottom_to_top(stk, top);
            int top2 = stk[--top];
            stk[top++] = peek;
            stk[top++] = top2;
        }else {
            stk[top++] = peek;
        }
    }
    public int[] reverseStackRecursively(int[] stack, int top) {
       if(top==0)return stack;
       move_bottom_to_top(stack, top);
       int peek = stack[--top];

       reverseStackRecursively(stack,top );
       stack[top++] = peek;

       return stack;
    }

    public static void main(String[] args) {
        递归翻转栈的所有元素 sl = new 递归翻转栈的所有元素();
        System.out.println(Arrays.toString(sl.reverseStackRecursively(new int[]{1, 2, 3, 4, 5}, 5)));
    }
}
