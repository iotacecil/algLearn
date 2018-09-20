package other_oj;

import java.util.Scanner;

/**
 *
 * chesserboard is n*m.
 * a coin is placed in the top right corner(1,m).
 *  Each time one people can move the coin into the
 *  left, the underneath or the left-underneath blank space.
 *who can't make a move will lose
 * starts with kiki.
 *
 * mex(minimal excludant)最小的不属于这个集合的非负整数
 * mex{0,1,2,4}=3、mex{2,3,5}=0、mex{}=0
 *  SG(x) = mex(S),其中 S 是 x 后继状态的SG函数值的集合。
 *  如 x 有三个后继状态分别为
 *  SG(a),SG(b),SG(c)，那么SG(x) = mex{SG(a),SG(b),SG(c)}。
 *  SG函数的终态为 SG(x) = 0,当且仅当 x 为必败点P时
 *
 *
 *  【实例】取石子问题

 有1堆n个的石子，每次只能取{ 1, 3, 4 }个石子，先取完石子者胜利，那么各个数的SG值为多少？

 SG[0]=0，f[]={1,3,4},

 x=1 时，可以取走1 - f{1}个石子，剩余{0}个，所以 SG[1] = mex{ SG[0] }= mex{0} = 1;

 x=2 时，可以取走2 - f{1}个石子，剩余{1}个，所以 SG[2] = mex{ SG[1] }= mex{1} = 0;

 x=3 时，可以取走3 - f{1,3}个石子，剩余{2,0}个，所以 SG[3] = mex{SG[2],SG[0]} = mex{0,0} =1;

 x=4 时，可以取走4-  f{1,3,4}个石子，剩余{3,1,0}个，所以 SG[4] = mex{SG[3],SG[1],SG[0]} = mex{1,1,0} = 2;

 x=5 时，可以取走5 - f{1,3,4}个石子，剩余{4,2,1}个，所以SG[5] = mex{SG[4],SG[2],SG[1]} =mex{2,0,1} = 3;

 以此类推.....

 x        0  1  2  3  4  5  6  7  8....

 SG[x]    0  1  0  1  2  3  2  0  1....

 由上述实例我们就可以得到SG函数值求解步骤，那么计算1~n的SG函数值步骤如下：

 1、使用 数组f 将 可改变当前状态 的方式记录下来。

 2、然后我们使用 另一个数组 将当前状态x 的后继状态标记。

 3、最后模拟mex运算，也就是我们在标记值中 搜索 未被标记值 的最小值，将其赋值给SG(x)。

 4、我们不断的重复 2 - 3 的步骤，就完成了 计算1~n 的函数值。
 *
 */
public class hdu2147 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            int m = sc.nextInt();
        }

    }
}
