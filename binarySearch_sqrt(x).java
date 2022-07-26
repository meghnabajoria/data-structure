// find sqrt(x) using binary search
import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        System.out.println("enter number");
        Scanner sc = new Scanner(System.in);
        Integer x = sc.nextInt();
        System.out.println("Square root of number is : " + mySqrt(x));
    }

    public static int mySqrt(int x) {
        long low = 1;
        long mid = 0;
        long high = x / 2;
        long ans = 0;

        if(x == 0 || x == 1)
            return x;

        while(low <= high) {
            mid = (low + high) / 2;
            if(mid*mid == x) {
                return (int)mid;
            }
            else if(mid*mid < x) {
                ans = mid;
                low = mid + 1;
            }
            else
                high = mid - 1;
        }
        return (int)ans;
    }
}
