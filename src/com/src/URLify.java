//"Mr John Smith    " would be Mr%20John%20Smith (String will always sufficient to %20)


public class URLify {

    public static void main(String[] str) {
        urlifyString("Mr John Smith    ".toCharArray(), 12);
    }

    private static void urlifyString(char[] str, int current) {
        int last = str.length - 1;
        while (current >= 0) {
            if (str[current] == ' ') {
                addSpace(str, last);
                last = last - 3;
            } else {
                str[last] = str[current];
                --last;
            }
            --current;
        }

        //printing
        for (char c : str) {
            System.out.print(c);
        }
    }


    private static void addSpace(char[] str, int last) {
        str[last] = '0';
        str[last - 1] = '2';
        str[last - 2] = '%';
    }
}
