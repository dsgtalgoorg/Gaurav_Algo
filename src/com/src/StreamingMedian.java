import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class StreamingMedian {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 8, 9, 1, 2, 70};
        Arrays.sort(arr);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
        createHeap(minHeap, maxHeap, arr);
        //printAll(minHeap);
        //System.out.println("===========================");
        // printAll(maxHeap);
        System.out.println(findMedian(minHeap, maxHeap));
        System.out.println(addNewElementAndFindMedian(minHeap, maxHeap, 56));
        System.out.println(addNewElementAndFindMedian(minHeap, maxHeap, 24));
        System.out.println(addNewElementAndFindMedian(minHeap, maxHeap, 71));
        System.out.println(addNewElementAndFindMedian(minHeap, maxHeap, 71));

    }

    private static int addNewElementAndFindMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap,
                                                  int number) {
        addNewElement(minHeap, maxHeap, number);
        return findMedian(minHeap, maxHeap);
    }

    private static void addNewElement(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, int number) {
        if (maxHeap.size() == 0) maxHeap.add(number);
        else if (number > minHeap.peek()) maxHeap.add(number);
        else maxHeap.add(number);
        balanceHeap(minHeap, maxHeap);
    }

    private static void balanceHeap(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (minHeap.size() - maxHeap.size() == 1 || minHeap.size() - maxHeap.size() == 0) return;
        else {
            if (minHeap.size() > maxHeap.size()) {
                while (minHeap.size() - maxHeap.size() != 1) {
                    maxHeap.add(minHeap.poll());
                    minHeap.remove(minHeap.poll());
                }
            } else {
                while (minHeap.size() - maxHeap.size() != 1) {
                    minHeap.add(maxHeap.peek());
                    maxHeap.remove(maxHeap.peek());
                }
            }
        }
    }


    private static int findMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (minHeap.size() == 0) {
            return 0;
        } else if ((minHeap.size() == 1 && maxHeap.size() == 0) || (minHeap.size() - maxHeap.size() == 1)) {
            return minHeap.peek();
        } else if (maxHeap.size() - minHeap.size() == 1) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2;
        }
    }

    private static void printAll(PriorityQueue<Integer> minHeap) {
        if (minHeap.size() == 0) return;

        for (Integer value : minHeap) {
            System.out.println(value);
        }
    }

    private static void createHeap(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, int[] arr) {
        if (arr.length == 0) return;
        int mid = (arr.length + 1) / 2;
        for (int i = 0; i < arr.length; i++) {
            if (mid <= i) maxHeap.add(arr[i]);
            else minHeap.add(arr[i]);
        }
    }
}
