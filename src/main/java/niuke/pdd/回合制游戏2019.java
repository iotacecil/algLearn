package niuke.pdd;

import java.util.Scanner;
/*
上个回合使用了聚力，那这次攻击会对敌人造成buffedAttack点伤害。
否则，会造成normalAttack点伤害。
给出血量HP和不同攻击的伤害，buffedAttack和normalAttack，返回你能杀死敌人的最小回合数。
452405440
254158163
67177178


8400
1
5
 */

public class 回合制游戏2019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long HP = sc.nextLong();
        long normal = sc.nextLong();
        long buffer = sc.nextLong();
        if (normal * 2 >= buffer) {
            System.out.println(HP / normal + (HP % normal == 0 ? 0 : 1));
        } else {
            long time = (HP / buffer) * 2;
            long left = HP % buffer;
            if (left == 0) {

            } else if (left <= normal) time += 1;
            else time += 2;
            System.out.println(time);


        }

    }
}
