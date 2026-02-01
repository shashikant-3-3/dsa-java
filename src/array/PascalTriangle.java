package array;

public class PascalTriangle {
    int findValueOfRowCol(int row, int col){
        if (row == 1 && col == 1){
            return 1;
        }
        if (row == 0 || col == 0){
            return 0;
        }
        return findValueOfRowCol(row-1, col) + findValueOfRowCol(row-1, col-1);
    }
}
