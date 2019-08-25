package niuke.wangyi;

import java.util.LinkedList;
import java.util.Scanner;

public class 会话列表2019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            LinkedList<Long> ids = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                long tmp = sc.nextLong();
                for (Long id : ids) {
                    if (id == tmp) {
                        ids.remove(id);
                        break;
                    }
                }
                ids.addFirst(tmp);


            }
            for (int i = 0; i < ids.size(); i++) {
                if (i == ids.size() - 1) {
                    System.out.println(ids.get(i));
                } else {
                    System.out.print(ids.get(i) + " ");
                }

            }
        }
    }
}
