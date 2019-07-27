package niuke.pdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//75%
public class 选靓号2019 {
    static class Mo {
        String str;
        int modi;

        public Mo(String str, int modi) {
            this.str = str;
            this.modi = modi;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        char[] str = sc.next().toCharArray();
        int[] cnnt = new int[10];
        for (int i = 0; i < str.length; i++) {
            cnnt[str[i] - '0']++;
        }
        //  int min = Integer.MAX_VALUE;
// 11122 7  211
        //Arrays.sort(str);
        int mostcost = Integer.MAX_VALUE;
        Mo best = null;
        // 用替换成k个i的最少花费
        for (int i = 0; i < 10; i++) {
            int[] cnt = cnnt.clone();

//            if(cnt[i]==0)continue;
            int cost = 0;
            int kk = k - cnt[i];
            if (kk < 0) {
                best = new Mo(new String(str), 0);
                break;
            }
            int l = i - 1;
            int r = i + 1;
            List<Integer> replace = new ArrayList<>();
            int[] last = new int[2];
            while (kk > 0) {
//                 System.out.println(l+" "+r+" "+kk);
                if (l < 0 && r >= 10) break;
                if (cost >= mostcost) break;
                while (l >= 0 && cnt[l] == 0) {
                    l--;
                }
                while (r < 10 && cnt[r] == 0) {
                    r++;
                }
                if (l >= 0 && (r >= 10 || (i - l <= r - i))) {
                    if (kk >= cnt[l]) {
                        cost += cnt[l] * (i - l);
                        kk -= cnt[l];
                        cnt[l] = 0;
                        replace.add(l);
                        l--;
                    } else {
                        cost += kk * (i - l);
                        last[0] = l;
                        last[1] = kk;
                        kk = 0;

                    }
                } else if (r < 10 && (l < 0 || (i - l > r - i))) {
//                     System.out.println("yes");
                    if (kk >= cnt[r]) {
                        cost += cnt[r] * (r - i);
                        kk -= cnt[r];
                        cnt[r] = 0;
                        replace.add(r);
                        r++;
                    } else {

                        cost += kk * (r - i);
                        last[0] = r;
                        last[1] = kk;
                        kk = 0;

                    }
                }
            }
//                 System.out.println(replace);
//                 System.out.println(Arrays.toString(last));
//                 System.out.println(cost);
            // 构造新string
            if (best == null || cost < best.modi) {
                char[] newstr = str.clone();
                for (int j = 0; j < newstr.length; j++) {
                    if (newstr[j] - '0' != i) {
                        for (int num : replace) {
                            if (newstr[j] - '0' == num) {
                                newstr[j] = (char) (i + '0');
                            }
                        }
                    }
                }
                while (last[1] > 0) {
                    // 如果用i替换last会变小,从左开始
                    if (last[0] > i) {
                        for (int j = 0; j < newstr.length && last[1] > 0; j++) {
                            if (newstr[j] - '0' == last[0]) {
                                newstr[j] = (char) (i + '0');
                                last[1]--;
                            }
                        }
                    } else {
                        for (int j = newstr.length - 1; j >= 0 && last[1] > 0; j--) {
                            if (newstr[j] - '0' == last[0]) {
                                newstr[j] = (char) (i + '0');
                                last[1]--;
                            }
                        }
                    }
                }

                best = new Mo(new String(newstr), cost);
            }
        }


//                rst.add(new Mo(new String(modistr),cost));

//                int idx = Arrays.binarySearch(modistr, (char)i);
//                int l = idx-1;int r = idx+1;
//                while (l>=0&&r<n&&k>0){
//                    int left = str[l]-'0';
//                    int right = str[r]-'0';
//                    if (i-left<right-i){
//                        cost+= i-str[l]+'0';
//                        modistr[l] = (char)i;
//                        l--;
//                        kk--;
//                    }
//
//                    else if(i-left<right-i){
//                        cost+=str[r]-'0'-i;
//                        modistr[r] = (char)i;
//
//                        r++;
//                        kk--;
//                    }
//                    else if(i==left)l--;
//                    else if(i==right)r++;
//
//                }
//
//                while (l>=0 && k>0){
//                    if(i==str[l]-'0'){
//                        l--;continue;
//                    }
//                    cost+= i-str[l]+'0';
//                    modistr[l] = (char)i;
//
//                    l--;
//                    kk--;
//                }
//                while (r<n && k>0){
//                    if(i==str[r]-'0'){
//                        r++;continue;
//                    }
//                    cost+= str[r]-'0'-i;
//                    modistr[r] = (char)i;
//
//                    r++;
//                    kk--;
//                }


        // }


//        rst.sort((a,b)->(a.modi==b.modi)?a.str.compareTo(b.str):a.modi-b.modi);
//        Mo mo = rst.get(0);
        System.out.println(best.modi);
        System.out.println(best.str);

    }
}
