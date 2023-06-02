//{ Driver Code Starts
//Initial Template for Java




import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().print2largest(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int print2largest(int arr[], int n) {
        // code here
        
        // === FIRST
        // Arrays.sort(arr);
        // return arr[arr.length -2];
        
        // === SECOND
        //int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int i = 0;
        boolean all_equal = false;
        while(i < arr.length) {
            // if(arr[i] < min)
            //     min = arr[i];
            if(arr[i] > max)
                max = arr[i];
            if(i!=0 && arr[i] == arr[i-1])
                all_equal = true;
            else
                all_equal = false;
            i++;
        }
        
        if(all_equal)
            return -1;
        
        i=0;
        //int second_min = Integer.MAX_VALUE;
        int second_max = Integer.MIN_VALUE;
        
        while(i< arr.length) {
            // if(arr[i] > min && arr[i] < second_min)
            //     second_min = arr[i];
            if(arr[i] < max && arr[i] > second_max)
                second_max = arr[i];
            i++;
        }
        return second_max;
    }
}