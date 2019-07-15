package niuke.codedance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class 特征提取2019 {
    static class pair{
        int x;
        int y;
        int cnt = 1;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            pair pair = (pair) o;

            if (x != pair.x) return false;

            return y == pair.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int t = 0; t <T ; t++) {
            int N = Integer.parseInt(bf.readLine());
            int rst = 0;

            HashSet<pair> hope = new HashSet<>();
            for (int i = 0; i <N ; i++) {

                String[] strs = bf.readLine().split(" ");
//                System.out.println(Arrays.toString(strs));
                int n = Integer.parseInt(strs[0]);
            //    pair[] ps = new pair[n];
                HashSet<pair> set = new HashSet<>();
                for (int j = 0;  j <n ; j++) {
                    //1 2  j*2+1
                    //3 4
                    pair cur = new pair(Integer.parseInt(strs[1+j*2]),Integer.parseInt(strs[j*2+2]));
                    if(!set.contains(cur))
                    set.add(cur);
                }
                HashSet<pair> next = new HashSet<>();
                for(pair last:hope){
                    if(set.contains(last)){
                        last.cnt++;
                        rst = Math.max(rst, last.cnt);
                        next.add(last);
                    }
                }
                for(pair nn:set){
                    if(!hope.contains(nn)){
                        next.add(nn);
                    }
                }
                hope = next;

        }
            System.out.println(rst<2?1:rst);

    }
    }
}
