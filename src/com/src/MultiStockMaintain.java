import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Maintain Multiple stack
public class MultiStockMaintain {

    int lastIndex = 0;
    private List<Stack<Integer>> stackList = new ArrayList<>();
    private List<Integer> availableSpot = new ArrayList<>();
    private int stockSize = 0;

    public MultiStockMaintain() {
    }

    public MultiStockMaintain(int stockSize) {
        this.stockSize = stockSize;
    }

    public static void main(String[] args) {
        MultiStockMaintain obj = new MultiStockMaintain(2);
        obj.push(23);
        obj.push(22);
        obj.push(21);
        System.out.println(obj.pop(1));
        System.out.println(obj.pop(2));
        obj.push(2);
        obj.push(3);
        System.out.println(obj.pop(1));

    }

    public int getLastIndex() {
        return lastIndex;
    }

    public void setLastIndex(int lastIndex) {
        this.lastIndex = lastIndex;
    }

    public List<Integer> getAvailableSpot() {
        return availableSpot;
    }

    public void setAvailableSpot(List<Integer> availableSpot) {
        this.availableSpot = availableSpot;
    }

    public int getStockSize() {
        return stockSize;
    }

    public void setStockSize(int stockSize) {
        this.stockSize = stockSize;
    }

    public void push(int value) {
        if (!availableSpot.isEmpty()) {
            int stackNumber = availableSpot.get(availableSpot.size() - 1);
            Stack obj = stackList.get(stackNumber - 1);
            obj.push(value);
            availableSpot.remove(availableSpot.size() - 1);
        } else {
            int stackNumber = (lastIndex + 1) / stockSize;
            if (stackList.isEmpty() || stackList.size() <= stackNumber) {
                Stack newObj = new Stack();
                newObj.push(value);
                stackList.add(newObj);
                lastIndex++;
            } else {
                Stack obj = stackList.get(stackNumber);
                obj.push(value);
                lastIndex++;
            }
        }
    }

    // Poping element for given stack index in list of stacks
    public Integer pop(int stockNo) {
        Stack obj = stackList.get(stockNo - 1);
        availableSpot.add(stockNo);
        return (Integer) obj.pop();
    }
}

