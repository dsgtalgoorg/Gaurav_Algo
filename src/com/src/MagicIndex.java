public class MagicIndex {
    public static void main(String[] args) {
        System.out.println(findMagicIndex(new Integer[]{-40,-20,1,2,3,5,7,9,12,13},0,9));
        System.out.println(findMagicIndex(new Integer[]{-10,-5,2,2,2,3,4,7,9,12,13},0,10));
    }

    private static int findMagicIndex(Integer[] arr, int start,int end) {
        if(start>end) return -1;
         int mid=(start+end)/2;
         if(mid==arr[mid]){
             return mid;
         }
       else if(mid<arr[mid]){
             return findMagicIndex( arr,  start, mid-1);
        }
        else{
             return  findMagicIndex(arr, mid+1,end);
        }
    }


}
