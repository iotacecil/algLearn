package niuke.codedance;

import java.util.PriorityQueue;
import java.util.Scanner;

/*
链接：https://www.nowcoder.com/questionTerminal/4bba9f2ab638483093e34377dd9b3e91?orderByHotValue=1&mutiTagIds=665&page=1&onlyReference=false
来源：牛客网

用例:
50
IAAAHAHCJGBJ
FAAABCABGIFF
FABBJIAGICCG
CAJEAIHBCFIF
CAEBJCGFEEJC
JAJEFADFHHDH
FAFCEDDGBIIH
EACHGBAJJICF
CACECDFDBFFC
BAJADCBDDDCE
JAEFEDICECGH
FAAHGHABHFIC
CAIIAJDHBCDJ
FAIHHJGDEBHA
DAFCHCCDIIDG
HAHAHIIGADGI
IAJECCIDJABD
EACFDDDCCBBA
IAFJFIDFEDGG
IAGIJBIGDIFB
DAFHBFCBJGDB
EACIBEIEGHAH
FAJDHJBIBBCC
BABIACEFHGDJ
JAEAHBABBDIB
FAHJCEAFHHAF
DAHAFCBAJCHE
IAEFCFCIJBBA
FAGEIEJFGGIH
CADBHGCGAJCA
EAJHGGGCCBBC
GAHFEHFHIJAI
CAADICHAJACG
CADFFHIHFCAF
EAIFFIFHAJGI
IAICCJIACEDE
CABJIBGECJEA
DAFGIEFBDGDG
FACDAIIJCJJF
BAAJHJFIHGHD
BAIDCEABEHDD
JAGHGICFHDAI
GACBGJBEJCAJ
GAJDEDBGGFJF
DAHAFEHEJHJD
JAJDEDGJBCBI
CAFGFJEIGFAI
CAHGDEDACGDI
CABACDGJDJHJ
EAFAIDAAFAAI

对应输出应该为:

31563768760690

你的输出为:

32270430830783



// 错误原因：映射成0的字符不能是第一个


 */
public class 最大映射2017 {

    //abc bca  c+1+10 b+10+100 a+100+1
// b=9 a=8 c=7
    static class Node {
        long cnt;
        boolean f;

        public Node(long cnt, boolean f) {
            this.cnt = cnt;
            this.f = f;
        }
    }

    // 990+808+77
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long rst = 0;

//99+99
        boolean[] first = new boolean[10];
        long[] cnt = new long[10];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            first[str.charAt(0) - 'A'] = true;
            for (int j = str.length() - 1; j >= 0; j--) {
                cnt[str.charAt(j) - 'A'] += Math.pow(10, (str.length() - 1 - j));

            }
        }
        PriorityQueue<Node> nodes = new PriorityQueue<>((a, b) -> (a.cnt - b.cnt) > 0 ? 1 : -1);
        for (int i = 0; i < 10; i++) {
            nodes.add(new Node(cnt[i], first[i]));
        }
        int num = 10 - nodes.size();
        while (!nodes.isEmpty()) {
            if (num == 0) {
                PriorityQueue<Node> tmp = new PriorityQueue<>((a, b) -> (a.cnt - b.cnt) > 0 ? 1 : -1);

                while (nodes.peek().f) {
                    tmp.add(nodes.poll());
                }
                rst += (nodes.poll().cnt * num);
                nodes.addAll(tmp);


            } else {
                rst += (nodes.poll().cnt * num);

            }

            num++;

        }


        System.out.println(rst);
    }
}
