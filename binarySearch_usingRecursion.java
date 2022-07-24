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
        System.out.println("Your element is at : " + binarySearchUsingRecursion(0, sizeOfArray-1, array, x));
    }

    public static Integer binarySearchUsingRecursion(Integer low, Integer high, List<Integer> array, Integer x) {
        Integer mid = (low + high) / 2;
        if(low > high)
            return -1;
        else if(array.get(mid).compareTo(x) == 0)
            return mid;
        else if(array.get(mid).compareTo(x) > 0)
            return binarySearchUsingRecursion(0, mid - 1, array, x);

        return binarySearchUsingRecursion(mid + 1, high, array, x);

    }
}
