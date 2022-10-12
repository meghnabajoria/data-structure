import java.util.*;
class printingSubsequence {

    public static void main(String[] args) {
        int[] arr = new int[] {3,1,2};
        int n = 3;
        List<Integer> list = new ArrayList<>();
        recursion(arr, 0, n, list);
    }

    private static void recursion(int[] arr, int indx, int n, List<Integer> list) {
        if(indx == n) {
            for(int i=0;i<list.size();i++) {
                System.out.println(list.get(i) + " ");
            }
            if(list.size() == 0) {
                System.out.println("{}");
            }
            System.out.println();
            return;
        }

        list.add(arr[indx]);
        recursion(arr, indx+1, n, list);
        list.remove(list.size()-1);
        recursion(arr,indx+1, n, list);

    }


}

