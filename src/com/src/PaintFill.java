import java.util.Arrays;
import java.util.stream.Stream;

public class PaintFill {
    public static void main(String[] args) {
        char[][] mat= new char[][]{{'B','R','B'},{'B','B','B'},{'Y','Y','Y'}};
        PaintFill.printAllMat(mat);
        System.out.println("++++++++++++++++++++++++++++++++++++");
        fillPaint(mat,'Y',1,1,'B');
        PaintFill.printAllMat(mat);

        System.out.println("================================");


        char[][] mat1= new char[][]{{'B','R','B','R','R'},{'B','B','B','R','R'},{'Y','Y','Y','R','R'},{'R','R','R','R','R'},
                {'R','R','Y','R','Y'}};
        PaintFill.printAllMat(mat1);
        System.out.println("++++++++++++++++++++++++++++++++++++");
        fillPaint(mat1,'Y',1,1,'B');
        PaintFill.printAllMat(mat1);
    }

    private static void fillPaint(char[][] mat, char color, int row, int col,char rcolor) {

        if(row >mat.length-1 || row<0 || col<0 || col>mat[0].length-1) return;
        if(mat[row][col] == rcolor){
            mat[row][col] = color;
            fillPaint(mat, color, row - 1, col, rcolor);
            fillPaint(mat, color, row, col+1, rcolor);
            fillPaint(mat, color, row+1, col , rcolor);
            fillPaint(mat, color, row, col - 1, rcolor);
        }
    }

    private static void printAllMat(char[][] mat) {
        if(mat==null) return;
        Stream.of(mat)
                .flatMap(Stream::of)
                .forEach(System.out::println);
    }
}
