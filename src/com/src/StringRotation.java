
public class StringRotation {

    public static void main(String[] args) {
        System.out.println(findStringRotation("WaterBottle", "erBottleWat"));
        System.out.println(findStringRotation("WaterBottle", "BottleWater"));
        System.out.println(findStringRotation("WaterBottle45", "BottleWater"));
        System.out.println(findStringRotation("WaterBot5", "BottleWater"));

        System.out.println("=============================================================");

        System.out.println(findStringRotationWithConcatingString("WaterBottle", "erBottleWat"));
        System.out.println(findStringRotationWithConcatingString("WaterBottle", "BottleWater"));
        System.out.println(findStringRotationWithConcatingString("WaterBottle45", "BottleWater"));
        System.out.println(findStringRotationWithConcatingString("WaterBot5", "BottleWater"));
    }

    //by normal comparision
    private static boolean findStringRotation(String str, String rstr) {
        char firstChar = rstr.charAt(0);
        int len = str.length();
        String s1 = null;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == firstChar) {
                s1 = str.substring(i, len).concat(str.substring(0, i));
                if (s1.equals(rstr)) {
                    return true;
                }
            }
        }
        return false;
    }


    //by string duplication
    private static boolean findStringRotationWithConcatingString(String str, String rstr) {
        rstr = rstr + rstr;
        return rstr.contains(str);
    }
}
