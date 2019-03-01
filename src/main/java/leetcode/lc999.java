package leetcode;

public class lc999 {

    public int numRookCaptures(char[][] board) {
        int n = board.length;
        int cx = -1; int cy = -1;
        for(int i =0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(board[i][j] == 'R'){
                    cx = i;
                    cy = j;
                }
            }
        }
        System.out.println("R:["+cx+","+cx+"]");
        int cnt = 0;
        if(cx-1>=0){
                    for(int i = cx-1;i>=0;i--) {
                        if (board[i][cy] == 'B') {
                            break;
                        } else {
                            if (board[i][cy] == 'p') {
                                cnt++;
                            }
                        }
                    }
            }


            if(cx+1 <n){
                for(int i = cx+1;i<n;i++){
                    if(board[i][cy] == 'B'){
                        break;
                    }else{
                        if(board[i][cy] == 'p'){
                            cnt++;
                        }
                    }
                }
            }

            if(cy-1>=0){
                for(int j = cy-1;j>=0;j--){
                    if(board[cx][j] == 'B'){
                        break;
                    }else{
                        if(board[cx][j] == 'p'){
                            cnt++;
                        }
                    }
                }
            }

            if(cy+1<n){
                for(int j = cy+1;j<n;j++){
                    if(board[cx][j] == 'B'){
                        break;
                    }else{
                        if(board[cx][j] == 'p'){
                            System.out.println("p:["+cx+","+j+"]");
                            cnt++;
                        }
                    }
                }
            }

            return cnt;
        }

    public static void main(String[] args) {

    }

}
