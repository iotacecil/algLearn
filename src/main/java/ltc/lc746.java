package ltc;
class TicTacToe {

    /** Initialize your data structure here. */
    int[] rows;
    int[] cols;
    private int diagonal;
    private int antiDiagonal;
    boolean end = false;
    public TicTacToe() {
        rows = new int[3];
        cols = new int[3];
    }
    int player1;
    public boolean move(int row, int col) {
        if(end)
        player1 = 1;
        rows[row] += player1;
        cols[col] +=player1;
        if(row==col){
            diagonal+=player1;
        }
        if(col == cols.length-row-1){
            antiDiagonal+=player1;
        }
        if(Math.abs(rows[row])==3||Math.abs(cols[col])==3
                ||Math.abs(diagonal)==3||Math.abs(antiDiagonal)==3){
            System.out.println((player1==1?"x":"o")+" player wins!");
            return true;
        }
        player1 = -1;
        return false;
    }
}
public class lc746 {
    public static void main(String[] args) {
        TicTacToe sl = new TicTacToe();
        sl.move(0, 0);
        sl.move(1, 0); // O trun
        sl.move(1, 1); // X turn
        sl.move(2, 0); // O turn
        System.out.println(sl.move(2, 2));

    }
}
