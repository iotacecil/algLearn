package niuke.toutiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class shouchuan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();
        List<Integer>[] color = new List[c+1];
        for (int i = 1; i <=c ; i++) {
            color[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i <n ; i++) {
            int cn = sc.nextInt();
            for (int j = 0; j <cn ; j++) {
                int tc = sc.nextInt();
                color[tc].add(i );
            }
        }
        int cnt = 0;

        for (int i = 1; i <=c ; i++) {
            if(color[i].size()<2)continue;
            List<Integer> idxs = color[i];
            if ((idxs.get(idxs.size()-1)+m)%n  >idxs.get(0)) {
                cnt++;
                continue;
            }
            for (int j = 1; j <idxs.size(); j++) {
                if(idxs.get(j)-idxs.get(j-1)<m){
                    cnt++;
                    break;
                }
            }

        }
        System.out.println(cnt);
    }
}
