public class StringCompression {

    public static void main(String[] args) {
        System.out.println(stringCompression("abbcccccccdddddeeeee"));
        System.out.println(stringCompression("abcdefgh"));
        System.out.println(stringCompression("11111rrrtt"));


    }

    private static String stringCompression(String str) {
        if (str.isEmpty() || str.length() == 1) return str;

        String newStr = "";
        boolean flag = false;
        int count = 1;
        char prefix = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == prefix) {
                count++;
            } else {
                newStr = newStr + prefix + count;
                count = 1;
                prefix = str.charAt(i);
            }
            if (count > 1) flag = true;
        }
        newStr = newStr + prefix + count;
        if (flag) return newStr;
        return str;
    }
}
