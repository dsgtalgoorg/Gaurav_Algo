public class String_One_Zero_Edit {

    public static void main(String[] args) {
        System.out.println(zeroOneEdit("Pale", "Pales"));
        System.out.println(zeroOneEdit("Pale", "Pales1"));
        System.out.println(zeroOneEdit("Pal", "Pales"));
        System.out.println(zeroOneEdit("Pal45990950505050", "Pales"));
        System.out.println(zeroOneEdit("Pale", "Pal45990950505050"));
        System.out.println(zeroOneEdit("Pale1230456", "Pale123456"));
    }

    private static boolean zeroOneEdit(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int count = 0;
        int firstPointer = 0;
        int secondPointer = 0;
        while (firstPointer < len1) {
            if (len2 == secondPointer) {
                break;
            }
            if (str1.charAt(firstPointer) != str2.charAt(secondPointer)) {
                count++;
                if (count > 1) {
                    return false;
                }
            } else {
                secondPointer++;
            }
            firstPointer++;
        }

        if (secondPointer < len2) {
            count += len2 - secondPointer;
        }
        if (firstPointer < len1) {
            count += len1 - firstPointer;
        }

        return count <= 1;
    }

}
