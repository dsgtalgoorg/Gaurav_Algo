import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SuppressWarnings("Duplicates")
public class PowerSet_8_4 { // Return all subsets of a set

    /*
        abc
        {}, {a}, {b}, {a,b}, {c}, {a,c}, {b,c} {a,b,c}
     */

    public List<List<String>> allSubsets(String str) {
        List<List<String>> list = new ArrayList<>();
        return recurser(str, list);
    }

    private List<List<String>> recurser(String str, List<List<String>> list) {
        if (str.length() == 0) return list;
        else {
            String currentLetter = String.valueOf(str.charAt(0));
            int size = list.size();
            for (int i = 0; i < size; i++) { // copy each prev set and add current letter
                List<String> set = new ArrayList<>(list.get(i));
                set.add(currentLetter);
                list.add(set);
            }
            List<String> single = new ArrayList<>();
            single.add(currentLetter);
            list.add(single);

            return recurser(str.substring(1), list);
        }
    }

    /*
        TESTS
     */

    @Test
    public void emptyTree() {
        String input = "";
        List<List<String>> output = new ArrayList<>();

        assertEquals(output, allSubsets(input));
    }

    @Test
    public void singleton() {
        String input = "a";
        List<List<String>> output = new ArrayList<>();
        List<String> firstSet = new ArrayList<>();
        firstSet.add("a");
        output.add(firstSet);

        assertEquals(output, allSubsets(input));
    }


    @Test
    public void test1() {
        String input = "abc";
//        List<List<String>> output = new ArrayList<>();
//        List<String> firstSet = new ArrayList<>();
//        firstSet.add("a");
//        output.add(firstSet);

//        assertEquals(output, allSubsets(input));
        System.out.println(allSubsets(input));
    }

    /*
        HELPER METHODS
     */

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(PowerSet_8_4.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
