// practicing dynamic programming
//Link : https://www.codingninjas.com/codestudio/problems/ninja-s-training_3621003

//RECURSIVE SOLUTION

public class Solution {
        public static int ninjaTraining(int n, int points[][]) {
            int ans = recursion(points, n-1, 3);
            return ans;
        }

        private static int recursion(int points[][], int day, int activity) {
            // base condition
            if(day == 0) {
                int max = 0;
                for(int i=0;i<points[0].length;i++) {
                    if(i != activity)
                        max = Math.max(max, points[day][i]);
                }
                return max;
            }

            int max = Integer.MIN_VALUE;
            for(int i=0;i<points[0].length;i++) {
                if(i != activity) {
                    int score = points[day][i] + recursion(points,day-1,i);
                    max = Math.max(max, score);
                }
            }
            return max;
        }
}

//MEMOIZATION

import java.util.*;
public class Solution {
        public static int ninjaTraining(int n, int points[][]) {
            int[][] dp = new int [points.length][points[0].length + 1];
            for(int i=0;i<points.length;i++)
                Arrays.fill(dp[i], -1);
            int ans = recursion(points, n-1, 3, dp);
            return ans;
        }

        private static int recursion(int points[][], int day, int activity, int[][] dp) {
            // base condition
            if(day == 0) {
                int max = 0;
                for(int i=0;i<points[0].length;i++) {
                    if(i != activity)
                        max = Math.max(max, points[day][i]);
                }
                return max;
            }
            
            if(dp[day][activity] != -1) return dp[day][activity];
            int max = Integer.MIN_VALUE;
            for(int i=0;i<points[0].length;i++) {
                if(i != activity) {
                    int score = points[day][i] + recursion(points,day-1,i, dp);
                    max = Math.max(max, score);
                }
            }
            return dp[day][activity] = max;
        }
}

// TABULATION

import java.util.*;
public class Solution {
        public static int ninjaTraining(int n, int points[][]) {
            int[][] dp = new int [n][4];
            dp[0][0] = Math.max(points[0][1], points[0][2]);
            dp[0][1] = Math.max(points[0][0], points[0][2]);
            dp[0][2] = Math.max(points[0][1], points[0][0]);
            dp[0][3] = Math.max(Math.max(points[0][1], points[0][2]), points[0][0]);
           
        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        int activity = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }
        }
        return dp[n-1][3];
     }
}

// SPACE OPTIMIZATION

import java.util.*;
public class Solution {
        public static int ninjaTraining(int n, int points[][]) {
            int[] prev = new int [4];
            prev[0] = Math.max(points[0][1], points[0][2]);
            prev[1] = Math.max(points[0][0], points[0][2]);
            prev[2] = Math.max(points[0][1], points[0][0]);
            prev[3] = Math.max(Math.max(points[0][1], points[0][2]), points[0][0]);
           
        for (int day = 1; day < n; day++) {
            int[] temp = new int[4];
            Arrays.fill(temp, -1);
            for (int last = 0; last < 4; last++) {
                temp[last] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        temp[last] = Math.max(temp[last], points[day][task] + prev[task]);
                    }
                }
            }
            prev = temp;
        }
            return prev[3];
        }
}
