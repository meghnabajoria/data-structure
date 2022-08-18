// https://leetcode.com/problems/unique-morse-code-words/

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        
        HashSet<String> uniqueCodes = new HashSet<>();
        
        String[] morseCodes = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        for(String word : words) {
            StringBuilder transformation = new StringBuilder();
            for(char c : word.toCharArray()) {
                transformation.append(morseCodes[c-'a']);
            }
            uniqueCodes.add(transformation.toString());
        }
        
        return uniqueCodes.size();
    }
}
