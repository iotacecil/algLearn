package niuke.codedance;

import java.util.Scanner;

/*



qaaxxjjjttasdduuxxpccbbbeeeijjmyyrrrllxxkkknnezzzqqsqqqxxayyeenvveejjbbcccssyzzznnnsspyyyllllllqqqoouoonuuuunnnmsssvvksccmmmtttppjjvwnssnntttcctmmyyirazibbiigggkkhrrhvvtttcceeuuccktttfffctt

输出
qaaxjjtasdduxxpccbeeijjmyyrllxkknezzqsqqxayyenvvejjbccsyzznsspyylqqouoonuunmssvksccmttpjjvwnssnttctmmyirazibbiggkhrrhvvtcceuuckttfctt

我的输出
qaaxjjtasdduxxpccbeeijjmyyrllxkknezzqsxxayyenvvejjbccsyzznsspyylqqounnmssvksccmttpjjvwnssnttctmmyirazibbiggkhrrhvvtcceuuckttfctt
 */
public class 聪明的编辑2019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nn = sc.nextInt();
        for (int k = 0; k < nn; k++) {

            String str = sc.next();
            int n = str.length();
            int a = 0;
            int b = 0;
            int c = 0;
            int cnt = 0;
            int idx = 0;
            // aaabbbccc->aabbcc->aabcc
            //wooo ooo ow->wooo oow->wooo ow->wooow->woow
            //w ooo
            char[] s = str.toCharArray();
            int i = 0;
            for (char ch : s) {
                if (i < 2 || ch != s[i - 2]) {
                    s[i++] = ch;
                }

            }
            n = i;
            //aabccdeecc
            // 12345
            //idx = 0;
            //aabccc
//aabbcc n = 6
            i = 0;
            for (int j = i; j < n - 5; j++) {
                int j1 = j + 1;
                int j2 = j + 2;
                int j3 = j + 3;
                int j4 = j + 4;
                int j5 = j + 5;
                if (s[j] == s[j1] && s[j2] == s[j3] && s[j4] == s[j5]) {
                    s[j2] = ' ';
                }
            }
            // System.out.println(s);
            //aabb b 0 -> 4 n = 4
            //woow n=4
            StringBuilder sb = new StringBuilder();
            int j = 0;
            while (j < n - 3) {
                int j1 = j + 1;
                int j2 = j + 2;
                int j3 = j + 3;

                if (s[j] == s[j1] && s[j2] == s[j3]) {
                    sb.append(s[j]);
                    sb.append(s[j1]);
                    sb.append(s[j2]);

                    j += 4;
                } else if (s[j] != ' ') {
                    sb.append(s[j++]);
                } else j++;
            }
            while (j < n) {
                if (s[j] != ' ')
                    sb.append(s[j++]);
            }


            System.out.println(sb.toString());
        }

    }
}
