package niuke.baidu;

public class canArrange {
    public static int canArrangeWords(String[] arr){
        int[] head = new int[26];
        int[] back = new int[26];
        for(String s:arr){
            head[s.charAt(0)-'a']++;
            back[s.charAt(s.length()-1)-'a']++;
        }
        int hcnt = 0;
        int bcnt = 0;

        for (int i = 0; i <26 ; i++) {
            if(head[i] == back[i])continue;
            if(head[i] > back[i])hcnt++;
            else if(head[i]<back[i])bcnt++;
        }
        if(hcnt==1&&bcnt==1)return 1;
        else return -1;
    }
    public static void main(String[] args) {

    }
}
