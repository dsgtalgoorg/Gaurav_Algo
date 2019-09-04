import javax.print.DocFlavor;
import java.util.Stack;

public class HanoiTower {
    public static void main(String[] args) {
        Stack<Integer> src= new Stack<>();
        src.push(4);
        src.push(3);
        src.push(2);
        src.push(1);
        //src.forEach(e->System.out.println(e));
        Stack<Integer> destTower= new Stack<>();
        Stack<Integer> bufferTower= new Stack<>();
        honoiTower(src,destTower,bufferTower,4);
        destTower.forEach(e->System.out.println(e));


        System.out.println("+++++++++++++++++++++++++");

        Stack<Integer> src1= new Stack<>();
        src1.push(25);
        src1.push(15);
        src1.push(5);
        src1.push(4);
        src1.push(2);
        src1.push(1);
        //src.forEach(e->System.out.println(e));
        Stack<Integer> destTower1= new Stack<>();
        Stack<Integer> bufferTower1= new Stack<>();
        honoiTower(src1,destTower1,bufferTower1,6);
        destTower1.forEach(e->System.out.println(e));
    }

    private static void honoiTower( Stack srcTower, Stack destTower, Stack bufferTower,int n) {
        if (destTower.size() == n) {
            return;
        }

        moveChecked(srcTower, destTower);
        moveChecked(srcTower, bufferTower);
        moveChecked( bufferTower,destTower);
        honoiTower( srcTower,  destTower,  bufferTower, n)  ;
    }

    private static void moveChecked(Stack srcTower, Stack destTower) {
        if(srcTower.empty() && destTower.empty()) return;
        if( (srcTower.size()>0 && destTower.size()==0) || ((Integer)srcTower.peek()>(Integer)destTower.peek()) ){
            destTower.push(srcTower.pop());

        }
        else{
            srcTower.push(destTower.pop());
        }
    }
}
