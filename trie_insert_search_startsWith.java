
class Node {
    Node links[] = new Node[26];
    boolean flag = false;
    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }
    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void setEnd() {
        flag = true;
    }

    boolean isEnd() {
        return flag;
    }
};

public class Trie {
    private static Node root;
    Trie() {
        root = new Node();
    }

    public static void insert(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++) {
            if(!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            // moves to the reference trie
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public static boolean search(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++) {
            if(!node.containsKey(word.charAt(i)))
                return false;
            node = node.get(word.charAt(i));
        }
        if(node.isEnd())
            return true;
        return false;
    }

    public static boolean startsWith(String prefix) {
        Node node = root;
        for(int i=0;i<prefix.length();i++) {
            if(!node.containsKey(prefix.charAt(i)))
                return false;
            node = node.get(prefix.charAt(i));
        }
        return true;

    }
}
