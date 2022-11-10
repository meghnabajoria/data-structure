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
