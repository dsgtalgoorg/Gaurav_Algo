import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubSetsOfArray {
    public static void main(String[] args) {
        List<List<Integer>> subsets = new ArrayList<>();
        Integer[] arr = new Integer[]{1, 2, 3, 3};
        findSubset(arr, 0, subsets);
        System.out.println(subsets.size());
        printList(subsets);

        System.out.println(">>>>>>>>>>>> ");
        System.out.println(findSubsets("abcd"));

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

    private static List<List<String>> findSubsets(String str) {
        List<List<String>> list = new ArrayList<>();
        recurser(str, list);
        return list;
    }

    private static void recurser(String subString, List<List<String>> list) {
        if (subString.length() == 0) return;
        else {
            String currLetter = String.valueOf(subString.charAt(0));
            int size = list.size();
            for (int i = 0; i < size; i++) {
                List<String> currSet = new ArrayList<>(list.get(i));
                currSet.add(currLetter);
                list.add(currSet);
            }
            List<String> single = new ArrayList<>();
            single.add(currLetter);
            list.add(single);
            recurser(subString.substring(1), list);
        }
    }

}
