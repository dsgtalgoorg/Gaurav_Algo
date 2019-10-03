//https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindow {
    public static void main(String[] args) {
        int[] arr = {12, 1, 78, 90, 57, 89, 56};
        int k = 3;
        printMax(arr, arr.length, k);
    }

    private static void printMax(int[] arr, int length, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int index = 0;
        while (index < k) {
            queue.add(arr[index]);
            index++;
        }

        while (index <= length) {
            System.out.println(queue.peek());
            queue.remove(arr[index - k]);
            if (index != length)
                queue.add(arr[index]);
            index++;
        }
    }

    private static void printAll(PriorityQueue<Integer> minHeap) {
        if (minHeap.size() == 0) return;

        for (Integer value : minHeap) {
            System.out.println(value);
        }
    }
}
