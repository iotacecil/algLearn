package niuke.huawei;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Node{
    int val;

    public Node(int val) {
        this.val = val;
    }


}
public class shanshu {
    // 1 - 8
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            Queue<Node> que = new LinkedList<>();

            int cnt = 0;
            for (int i = 0; i <n ; i++) {
                cnt++;
                if(cnt==3){
                    cnt=0;
                    continue;
                }
                que.add(new Node(i));
            }

            while (!que.isEmpty()){
                if(que.size()==1){
                    System.out.println(que.poll().val);
                    break;
                }
                Node val = que.poll();
                cnt++;
                if(cnt==3){
                    cnt=0;
                    continue;
                }
                que.add(val);
            }

        }

    }
}
