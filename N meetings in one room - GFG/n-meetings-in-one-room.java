//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        List<Tuple> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new Tuple(start[i], end[i], i));
        }
        meetingComparator mc = new meetingComparator();
        Collections.sort(list, mc);
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(list.get(0).index);
        int limit = list.get(0).end;
        
        for(int i=1;i<n;i++){
            if(list.get(i).start > limit) {
                limit = list.get(i).end;
                ans.add(list.get(i).index);
            }
        }
        return ans.size();
    }
}

class meetingComparator implements Comparator<Tuple> {
    @Override
    public int compare(Tuple a, Tuple b) {
        if(a.end < b.end) return -1;
        else if ( a.end > b.end) return 1;
        else if(a.index < b.index) return -1;
        return 1;
    }
}

class Tuple {
    int start;
    int end;
    int index;
    Tuple(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}