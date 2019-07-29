// add zero in row nad col if element is zero

public class Zero_Matrix {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 2}, {3, 0, 8}, {4, 5, 6}, {7, 8, 9}};
        setZeroMatrix(arr);
        int[][] arr1 = {{1, 2, 2, 4, 5}, {3, 0, 8, 6, 7}, {4, 5, 6, 4, 0}, {7, 8, 9, 1, 4}};
        setZeroMatrix(arr1);
    }

    private static void setZeroMatrix(int[][] arr) {

        int row = arr.length;
        int col = arr[0].length;
        boolean[][] rowcolArr = new boolean[row][col];
        printMatrix(arr, row, col);

        // Setting true value if element is zero
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 0) {
                    rowcolArr[i][j] = true;
                }
            }
        }


        //Setting zero if rowcolArr is true in row and col
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rowcolArr[i][j]) {
                    replaceZero(arr, i, j, row, col);
                }
            }
        }

        System.out.println();

        printMatrix(arr, row, col);

        System.out.println();


    }

    private static void printMatrix(int[][] arr, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }

    private static void replaceZero(int[][] arr, int i, int j, int row, int col) {
        for (int m = 0; m < col; m++) {
            arr[i][m] = 0;
        }
        for (int n = 0; n < row; n++) {
            arr[n][j] = 0;
        }
    }
}
