import java.util.Arrays;
import java.util.stream.Stream;

public class ChessQueen {
    public static void main(String[] args) {
        boolean[][] matrix = new boolean[5][5];
        Stream.of(matrix).map(Arrays::toString).forEach(System.out::println);

        adjustQueen(matrix, matrix.length, matrix[0].length);
        System.out.println("===================================");
        Stream.of(matrix).map(Arrays::toString).forEach(System.out::println);


        System.out.println("8*8===================");

        boolean[][] matrix1 = new boolean[8][8];
        Stream.of(matrix1).map(Arrays::toString).forEach(System.out::println);

        adjustQueen(matrix1, matrix1.length, matrix1[0].length);
        System.out.println("===================================");
        Stream.of(matrix1).map(Arrays::toString).forEach(System.out::println);
    }

    private static void adjustQueen(boolean[][] matrix, int row, int col) {
        if (row != col || row < 4) return;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean flag = isSafe(matrix, i, j);
                if (flag) {
                    matrix[i][j] = true;
                    break;
                }
                if (!flag && j == col - 1) {
                    i = resetRows(matrix, i - 1);
                }
            }
        }
    }

    private static int resetRows(boolean[][] matrix, int row) {
        if (row < 0) return 0;
        for (int i = 0; i < matrix.length; i++) {
            if (isSafe(matrix, row, i) && !matrix[row][i]) {
                matrix[row][i] = true;
                return row;
            }
            if (matrix[row][i]) {
                matrix[row][i] = false;
            }
        }
        return resetRows(matrix, row - 1);
    }

    private static boolean isSafe(boolean[][] matrix, int row, int col) {

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[row][i] || matrix[i][col]) return false;
            for (int j = 0; j < matrix[0].length; j++) {
                if (i - j == row - col || i + j == row + col) {
                    if (matrix[i][j]) return false;
                }
            }
        }

        return true;
    }


}
