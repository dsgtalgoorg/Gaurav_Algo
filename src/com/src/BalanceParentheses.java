public class BalanceParentheses {
    public static void main(String[] args) {
        System.out.println(IsBalance("(())",0,0));
        System.out.println(IsBalance("((((((())",0,0));
        System.out.println(IsBalance(")()((())",0,0));
        System.out.println(IsBalance("(((((()())))))",0,0));

    }

    private static boolean IsBalance(String str, int index, int openCount) {
        if(index>=str.length()){
            if(openCount!=0) return false;
            else return true;
        }
        if(str.length()%2!=0) return false;

        if(str.charAt(index)==')' ){
            if (openCount<=0) return false;
            else return IsBalance( str,  index+1,  openCount-1);
        }
        else {
            return IsBalance(str, index + 1, openCount + 1);
        }
    }
}
