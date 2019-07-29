import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class IsUniqueSolution {

    public static boolean isUnique(String inputString) {
        boolean[] charCodeArray = new boolean[26];

        for (char character : inputString.toCharArray()) {
            int unicodeValue = (int) Character.toLowerCase(character) - 97;

            if (charCodeArray[unicodeValue])
                return false;
            else
                charCodeArray[unicodeValue] = true;
        }
        return true;
    }



    /*
        TEST CASES
     */


    @Test
    public void failureTest() {
        final String text = "Splinters";
        assertFalse(isUnique(text));
    }


    @Test
    public void successTest() {
        final String text = "fancy";
        assertTrue(isUnique(text));
    }


    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(IsUniqueSolution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}