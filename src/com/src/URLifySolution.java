import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class URLifySolution {


    public static String urlify(String str, int actualLength) {
        char[] charArray = str.toCharArray();
        int offset = str.length() - actualLength;

        for (int i = str.length() - 1; offset > 0; i--) {
            if (Character.isSpaceChar(charArray[i - offset])) {
                charArray[i] = '0';
                i--;
                charArray[i] = '2';
                i--;
                charArray[i] = '%';
                offset -= 2;
            } else {
                char temp = charArray[i];
                charArray[i] = charArray[i - offset];
                charArray[i-offset] = temp;
            }
        }
        return new String(charArray);
    }


    /*
        TEST CASES
     */



    @Test
    public void happyPathTest() {
        assertEquals("Mr%20John%20Smith", urlify("Mr John Smith    ", 13));
    }

    @Test
    public void happyPath2Test() {
        assertEquals("%20Mr%20John%20Smith", urlify(" Mr John Smith      ", 14));
    }


    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(URLifySolution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}