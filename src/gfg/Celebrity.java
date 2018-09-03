package gfg;

public class Celebrity {
    int[][] Matrix = {
            {0, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0},
            {0, 0, 1, 0}
    };
    public static void main(String[] args) {
        Celebrity sl = new Celebrity();
        System.out.println(sl.findCele());
    }
    int findCele(){
        int n = Matrix.length;
        int a = 0;
        int b = n-1;
        while (a<b){
            if(Matrix[a][b]==1){
                a++;
            }
            else{
                b--;
            }
        }
        for (int i = 0; i <n ; i++) {
            //不是自己，但是别人不认识他，或者他认识别人
            if(i!=a&&Matrix[i][a]!=1||Matrix[a][i]==1)
                return -1;
        }
        return a;
    }
}
