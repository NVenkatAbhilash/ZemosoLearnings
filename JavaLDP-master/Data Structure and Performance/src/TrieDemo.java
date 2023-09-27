import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Trie{
    boolean isWord;
    Map<Character,Trie> hash;

    Trie(){
        isWord = false;
        hash = new HashMap<>();
    }

    static void insert(Trie node,String st){
        if(st.length()==0) {
            node.isWord = true;
            return;
        }
        char ch = st.charAt(0);
        if(!node.hash.containsKey(ch))
            node.hash.put(ch,new Trie());
        insert(node.hash.get(ch),st.substring(1));
    }

    static boolean search(Trie node,String st){
        if(st.length()==0)
            return node.isWord;
        char ch = st.charAt(0);
        if(node.hash.containsKey(ch))
            return search(node.hash.get(ch),st.substring(1));
        return false;
    }
}


public class TrieDemo {
    public static void main(String args[]){
        Trie head = new Trie();
        Trie.insert(head,"ant");
        Trie.insert(head,"an");
        Trie.insert(head,"bit");
        Trie.insert(head,"bite");
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("cat","bit","a","bi"));
        for(String st: list){
            if(Trie.search(head,st))
                System.out.println(st+" found");
            else
                System.out.println(st+" not found");
        }
    }
}
