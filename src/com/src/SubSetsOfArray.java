import java.util.ArrayList;
import java.util.List;

public class SubSetsOfArray {
    public static void main(String[] args) {
        List<List<Integer>> subsets = new ArrayList<>();
        Integer[] arr = new Integer[]{1, 2, 3, 3};
        findSubset(arr, 0, subsets);
        System.out.println(subsets.size());
        printList(subsets);

      /*  System.out.println("Second============================");

        List<List<Integer>> subsets2= new ArrayList<>();
        Integer arr1[] = new Integer[]{1,2,3,4,5,4,5};
        findSubset(arr1,0,subsets2);
        System.out.println(subsets2.size());
        printList(subsets2);*/
    }

    private static void printList(List<List<Integer>> subsets) {
        if (subsets != null) {
            for (List<Integer> subset : subsets) {
                System.out.println("============================");
                if (subset != null) {
                    for (Integer val : subset) {
                        System.out.println(val);
                    }
                }
                System.out.println("============================");
            }
        }
    }

    private static void findSubset(Integer[] arr, int index, List<List<Integer>> subsets) {
        if (index >= arr.length) return;
        addElements(arr[index], subsets);
        findSubset(arr, index + 1, subsets);
    }

    private static void addElements(Integer element, List<List<Integer>> subsets) {
        Integer len = subsets.size();
        int index = 0;
        if (len > index) {
            while (index < len) {
                System.out.println("addElements==" + len);
                List<Integer> list = subsets.get(index);
                List<Integer> newList = new ArrayList<>(list);
                newList.add(element);
                subsets.add(newList);
                index++;
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(element);
        subsets.add(list);
    }


}
