import java.util.*;

public class PermutationWithoutDuplicate {
    public static void main(String[] args) {
        // System.out.println(allPerms("aacd"));
        Set<String> finalSet = new HashSet<>();
        getSubSet(finalSet,"123");
        if (finalSet != null) finalSet.forEach(e -> System.out.println(e));

        System.out.println("===============");

        finalSet = new HashSet<>();
        getSubSet(finalSet, "122");
        if (finalSet != null) finalSet.forEach(e -> System.out.println(e));
    }

    private static void getSubSet(Set<String> finalSet,String str) {
        if(str== null) return;
        int mainIndex=0;
        while (mainIndex < str.length()) {
            String currentString = str.substring(0, mainIndex) + str.substring(mainIndex + 1);
                Set<String>  combinations= new HashSet<>();
                combinations.add(String.valueOf(str.charAt(mainIndex)));
            currentString = str.substring(0, mainIndex) + str.substring(mainIndex + 1);
                getCombination(finalSet, combinations, currentString, currentString,0);
                 mainIndex++;
            }
    }

    private static void getCombination(Set<String> finalSet, Set<String> combination, String str,String currentString,int index) {
        if (currentString.length() == 1) {
            for (String set : combination) {
                finalSet.add(set + currentString);
            }
            return;
        }
        else {
            Iterator it = combination.iterator();
            while (it.hasNext()) {
                String currComb = (String) it.next();
                it.remove();
            while (index < str.length()) {
                Set<String> localComb = new HashSet<>();
                    String s = String.valueOf(str.charAt(index));
                localComb.add(currComb + s);
                currentString = str.substring(0, index) + str.substring(index + 1);
                    getCombination(finalSet, localComb, str, currentString,index++);
                }
            }

        }
            //if(finalSet != null) finalSet.forEach(e-> System.out.println(e));
            //if(combination != null) combination.forEach(e-> System.out.println(e));

    }


// Dan Code

    public static List<List<String>> allPerms(String str) {
        List<List<String>> list = new ArrayList<>();
        return recurser(str, list);
    }

    public static List<List<String>> recurser(String str, List<List<String>> list) {
        if (str.length() == 0) return list;
        else {
            List<List<String>> newPermutations = new ArrayList<>();
            int idx = 0;
            String currentLetter = String.valueOf(str.charAt(idx));

            for (int i = 0; i < list.size(); i++) {
                List<String> oldPermuation = list.get(i);
                for (int j = 0; j <= oldPermuation.size(); j++) {
                    List<String> newPerm = new ArrayList<>(oldPermuation);
                    newPerm.add(j, currentLetter);
                    newPermutations.add(newPerm);
                }
            }
            if (list.size() == 0) {
                List<String> singleton = new ArrayList<>();
                singleton.add(currentLetter);
                newPermutations.add(singleton);
            }
            return recurser(str.substring(1), newPermutations);
        }
    }


}
