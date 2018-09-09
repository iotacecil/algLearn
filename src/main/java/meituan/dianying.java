package meituan;


public class dianying {
    static String[][] phone={
    {"@!:","ABC","DEF"},
    {"GHI","JKL","MNO"},
    {"PQRS","TUV","WXYZ"}};
    static boolean flag = false;
    static int nowlen;
    static int minpath;
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
        int n = 1;
        String s = "AT";
//        char cc = s.charAt(0);
//        System.out.println(phone[0][1].indexOf(cc));

        for (int i = 0; i <n ; i++) {
//            String s = in.next();
            int cnt =0;

                boolean[][] visited = new boolean[3][3];

//                cnt+=dfs(0,visited,0,0,s);

            System.out.println(cnt);



        }
    }
    private static int dfs(boolean[][] visited,int i,int j,String s,int index){
        int[][] p = {{0,1},{1,0},{-1,0},{0,-1}};

        if(index == s.length()-1){
            flag =true;
            if(nowlen<minpath){
                minpath = nowlen;
            }

        }

        int min = Integer.MAX_VALUE;


        if(phone[i][j].indexOf(s.charAt(index))!=-1){
       //find
            index++;

        }
        for(int[] d:p){
            int x=i+d[0],y=j+d[1];
            if(x<0||x>2||y>2||y<0)continue;

        }
        return -1;
    }
}
