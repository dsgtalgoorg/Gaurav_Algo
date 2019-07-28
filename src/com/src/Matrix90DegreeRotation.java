/*

Rotate a matrix by 90 degree in clockwise direction , no extra space

Input:
1 2 3 4
11 12 13 14
21 22 23 24
31 32 33 34
Output:
31 21 11 1
32 22 12 2
33 23 13 3
34 24 14 4
 */


public class Matrix90DegreeRotation {

    public static void main(String[] args) {

        int[][] arr = {{1, 2, 3, 4}, {11, 12, 13, 14}, {21, 22, 23, 24}, {31, 32, 33, 34}};
        matrix90DegreeRotation(arr);
    }

    private static void matrix90DegreeRotation(int[][] arr) {
        int length = arr.length;
        for (int row = 0; row < length / 2; row++) {
            for (int col = row; col < length - row - 1; col++) {
                int temp = arr[row][col];
                arr[row][col] = arr[length - 1 - col][row];
                arr[length - 1 - col][row] = arr[length - 1 - row][length - 1 - col];
                arr[length - 1 - row][length - 1 - col] = arr[col][length - 1 - row];
                arr[col][length - 1 - row] = temp;
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }


}
