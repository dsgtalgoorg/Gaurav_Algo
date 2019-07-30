import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class CheckPermutation {

    public static boolean isPermutation(String str1, String str2) {
//        if (str1.length() != str2.length()) return false;
//        else {
//            int[] charCodeArray = new int[128];
//
//            for (char character : str1.toCharArray()) {
//                int unicodeValue = character;
//
//                charCodeArray[unicodeValue]++;
//            }
//
//            for (char character : str2.toCharArray()) {
//                int unicodeValue = character;
//
//                charCodeArray[unicodeValue]--;
//
//                if (charCodeArray[unicodeValue] < 0) {
//                    return false;
//                }
//            }
//
//            return true;
//        }



        /*
            USING A SET
         */

        if (str1.length() != str2.length()) return false;

        Set<Character> charSet = new HashSet<>();
        for (char character : str1.toCharArray()) { charSet.add(character); }
        for (char character : str2.toCharArray()) { charSet.remove(character); }
        return charSet.size() == 0;

    }



    /*
        TEST CASES
     */



    @Test
    public void emptyStringTest() {
        final String str1 = "";
        final String str2 = "";
        assertTrue(isPermutation(str1, str2));
    }

    @Test
    public void singeltonTest() {
        final String str1 = "d";
        final String str2 = "d";
        assertTrue(isPermutation(str1, str2));
    }


    @Test
    public void failureTest() {
        final String str1 = "abcde";
        final String str2 = "cbfea";
        assertFalse(isPermutation(str1, str2));
    }

    @Test
    public void successTest() {
        final String str1 = "abcd";
        final String str2 = "cbda";
        assertTrue(isPermutation(str1, str2));
    }


    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(CheckPermutation.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}