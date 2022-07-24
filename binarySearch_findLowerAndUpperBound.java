// implement binary search using recursion.
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(("enter size of array"));
        Integer sizeOfArray = sc.nextInt();

        System.out.println(("enter your array"));
        List<Integer> array = new ArrayList<>(sizeOfArray);
        for (Integer i = 0; i < sizeOfArray; i++) {
            Integer input = sc.nextInt();
            array.add(input);
        }
        System.out.println("Enter element to be searched");
        Integer x = sc.nextInt();
        System.out.println("Your elements lower bound is at : " + lowerBound(0, sizeOfArray-1, array, x));
        System.out.println("Your elements upper bound is at : " + upperBound(0, sizeOfArray-1, array, x));
    }

    public static Integer upperBound(Integer low, Integer high, List<Integer> array, Integer x) {
        Integer ans = -1;
        while(low<=high) {
            Integer mid = (low + high) / 2;
            if(array.get(mid).compareTo(x) <= 0) {
                low = mid + 1;
            }
            else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }

    public static Integer lowerBound(Integer low, Integer high, List<Integer> array, Integer x) {
        Integer ans = -1;
        while(low<=high) {
            Integer mid = (low + high) / 2;
            if(array.get(mid).compareTo(x) >= 0) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }


}
