package ltc;

import java.util.ArrayList;
import java.util.List;

public class lc912 {
    public int minTotalDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        List<Integer> cols = new ArrayList<>();
        List<Integer> rows = new ArrayList<>();
        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1){
                    cols.add(j);
                    rows.add(i);
                }
            }
        }

       cols.sort(Integer::compareTo);
        int sum = 0;
        int l = 0;

        for(int i =0;i<cols.size()/2;i++){
            sum += cols.get(cols.size()-1 - i)-cols.get(i);
        }

        for(int i =0;i<rows.size()/2;i++){
            sum += rows.get(rows.size()-1 - i)-rows.get(i);
        }
        return sum;

    }
}
