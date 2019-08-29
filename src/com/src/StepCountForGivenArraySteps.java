public class StepCountForGivenArraySteps {
    public static void main(String[] args) {

        int n = 4;
        System.out.println(countSteps(n));
        int[] arr = new int[n + 1];
        System.out.println(countStepsCache(n, arr));


        n = 3;
        System.out.println(countSteps(n));
        int[] arr1 = new int[n + 1];
        System.out.println(countStepsCache(n, arr1));
    }

    private static Integer countSteps(int value) {
        if (value < 0) return 0;
        if (value == 0) return 1;
        return countSteps(value - 1) + countSteps(value - 2) + countSteps(value - 3);
    }

    /**
     * method using cache
     *
     * @param value value
     * @param cache cache
     * @return
     */
    private static Integer countStepsCache(int value, int[] cache) {
        if (value < 0) return 0;
        if (value == 0) return 1;
        if (cache[value] != 0) return cache[value];
        cache[value] = countSteps(value - 1) + countSteps(value - 2) + countSteps(value - 3);
        return cache[value];
    }
}
