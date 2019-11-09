package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
    Design a data structure that supports the following two operations:

    void addWord(word)
    bool search(word)
    search(word) can search a literal word or a regular expression string containing only letters a-z or ..
    A . means it can represent any one letter.
 */
public class AddAndSearchWord {

    private Set<char[]> words = new HashSet<>();
    private Map<Integer, Boolean> map = new HashMap<>();

    public static void main(String... args) {

        AddAndSearchWord addAndSearchWord = new AddAndSearchWord();
        addAndSearchWord.addWord("bad");
        addAndSearchWord.addWord("dad");
        addAndSearchWord.addWord("mad");
        System.out.println(addAndSearchWord.search("pad"));
        System.out.println(addAndSearchWord.search("bad"));
        System.out.println(addAndSearchWord.search(".ad"));
        System.out.println(addAndSearchWord.search("b.."));
    }

    public void addWord(String word) {

        map.put(word.length(), true);
        words.add(word.toCharArray());
    }

    public boolean search(String word) {

        int n = word.length();
        if (!map.containsKey(n)) return false;
        char[] w = word.toCharArray();

        for (char[] c : words)
            if (c.length == n) {

                boolean flag = true;

                for (int i = 0; i < n; i++)
                    if (w[i] != '.' && c[i] != w[i]) {

                        flag = false;
                        break;
                    }

                if (flag) return true;
            }

        return false;
    }

}
