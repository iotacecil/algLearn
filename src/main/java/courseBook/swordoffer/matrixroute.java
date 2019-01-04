package courseBook.swordoffer;

public class matrixroute {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {

        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                if(matrix[rows*cols + j] == str[0]){
                    return bfs(matrix,rows,cols,i,j,str);
                }
            }

        }
        return false;

    }

    private boolean bfs(char[] matrix, int rows, int cols,int x,int y ,char[] str) {
            return true;
    }


}
