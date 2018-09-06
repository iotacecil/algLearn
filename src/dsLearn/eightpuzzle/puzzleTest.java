//package dsLearn.eightpuzzle;
//
//public class puzzleTest {
//    public static void main(String[] args) {
//
//        // create initial board from file
//        int n =3;
//        int[][] blocks = new int[n][n];
//        for (int i = 0; i < n; i++)
//            for (int j = 0; j < n; j++)
//                blocks[i][j] = i*j+j;
//        Board initial = new Board(blocks);
//
//        // solve the puzzle
//        Solver solver = new Solver(initial);
//
//        // print solution to standard output
//        if (!solver.isSolvable())
//            System.out.println("No solution possible");
//        else {
//            System.out.println("Minimum number of moves = " + solver.moves());
//            for (Board board : solver.solution())
//                System.out.println(board);
//        }
//    }
//}
