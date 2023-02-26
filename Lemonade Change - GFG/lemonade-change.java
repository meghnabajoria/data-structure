//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.lemonadeChange(n, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean lemonadeChange(int N, int bills[]) {
        // code here
        Map<Integer, Integer> map = new HashMap<>();
        map.put(5,0);
        map.put(10,0);
        map.put(20,0);
        int updatedValue = 0;
        for(int i=0;i<bills.length;i++){
            if(bills[i] == 5) {
                updatedValue = map.get(5) + 1;
                map.put(5, updatedValue);
            }
            else if(bills[i] == 10) {
                if(map.get(5) > 0) {
                    updatedValue = map.get(10) + 1;
                    map.put(10, updatedValue);
                    updatedValue = map.get(5) - 1;
                    map.put(5, updatedValue);
                }
                else return false;
            }
            else if(bills[i] == 20) {
                if(map.get(10) > 0 && map.get(5) > 0) {
                    updatedValue = map.get(20) + 1;
                    map.put(20, updatedValue);
                    updatedValue = map.get(10) - 1;
                    map.put(10, updatedValue);
                    updatedValue = map.get(5) - 1;
                    map.put(5, updatedValue);
                }
                else if(map.get(5) >= 3) {
                    updatedValue = map.get(20) + 1;
                    map.put(20, updatedValue);
                    updatedValue = map.get(5) - 3;
                    map.put(5, updatedValue);
                }
                else return false;
            }
        }
        return true;
    }
}
