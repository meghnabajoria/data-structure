// class Solution {
//     public int countVowelStrings(int n) {
//         char[] list = new char[] {'a','e','i','o','u'};
        
//         return recursion(0, n, list, "");
//     }
    
//     private int recursion(int index, int limit, char[] vowels, String s) {
//         if(s != null && s.length() == limit) {
//             return 1;
//         }
//         else if(index >= vowels.length)
//             return 0;
        
        
//         int pick = recursion(index, limit, vowels, s+vowels[index]);
//         int noPick =  recursion(index+1, limit, vowels, s);
        
//         return pick + noPick;
//     } 
// }

class Solution {
    public int countVowelStrings(int n) {
        int a = 1, e = 1, i = 1, o = 1, u = 1;
        while(n > 1) {
			// add new char before prev string
            a = (a + e + i + o + u); // a, e, i, o, u -> aa, ae, ai, ao, au
            System.out.println("a = " + a);
            e = (e + i + o + u); // e, i, o, u -> ee, ei, eo, eu
            i = (i + o + u); // i, o, u -> ii, io, iu
            o = (o + u); // o, u -> oo, ou
            u = (u);; // u -> uu
            n--;
        }
        
        return a + e + i + o + u;
    }
}