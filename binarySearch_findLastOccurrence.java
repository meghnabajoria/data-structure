// given an array of duplicates, find out the last occurrence of x using BS.
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
        System.out.println("Your element is at : " + findLastOccurrence(array, sizeOfArray, x));
    }

    public static Integer findLastOccurrence(List<Integer> array, Integer sizeOfArray, Integer x) {
        Integer low = 0;
        Integer high = sizeOfArray - 1;
        Integer ans = -1;

        while (low <= high) {
            Integer mid = ( low + high ) / 2;

            if(array.get(mid).compareTo(x) ==0) {
                ans = mid;
                low = mid + 1;
                continue;
            }
            else if(array.get(mid).compareTo(x) < 0) {
                low = mid + 1;
            }
            else if(array.get(mid).compareTo(x) > 0) {
                high = mid -1;
            }
        }
        return ans;
    }
}
