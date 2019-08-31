import java.util.ArrayList;
import java.util.List;

public class RobotGrid {
    public static void main(String[] args) {
        List<MatrixObject> blockedPath = new ArrayList<>();
        blockedPath.add(new MatrixObject(2, 2));
        blockedPath.add(new MatrixObject(0, 2));
        blockedPath.add(new MatrixObject(1, 0));

        System.out.println(traverseGrid(3, 3, blockedPath, 0, 0));


        List<MatrixObject> blockedPath1 = new ArrayList<>();
        System.out.println(traverseGrid(3, 3, blockedPath1, 0, 0));

        List<MatrixObject> blockedPath2 = new ArrayList<>();
        blockedPath2.add(new MatrixObject(0, 1));
        blockedPath2.add(new MatrixObject(1, 0));
        System.out.println(traverseGrid(3, 3, blockedPath2, 0, 0));
    }

    private static boolean traverseGrid(int row, int col, List<MatrixObject> blockedPath,
                                        int currentRow, int currentCol) {
        if (currentRow == row && currentCol == col) return true;

        if (blockedPath.contains(new MatrixObject(currentRow, currentCol))) return false;

        if (currentRow > row || currentCol > col) return false;

        return traverseGrid(row, col, blockedPath, currentRow + 1, currentCol) ||
                traverseGrid(row, col, blockedPath, currentRow, currentCol + 1);
    }


}
