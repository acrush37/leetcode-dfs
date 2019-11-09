package medium;

import java.util.*;

/*
    Given a string containing digits from 2-9 inclusive,
    return all possible letter combinations that the number could represent.

    A mapping of digit to letters (just like on the telephone buttons) is given below.
    Note that 1 does not map to any letters.
 */
public class LetterCombinationsOfPhoneNumber {

    private List<String> result = new ArrayList<>();
    private Map<Character, Set<Character>> map = new HashMap<>();

    public static void main(String... args) {

        LetterCombinationsOfPhoneNumber letterCombinationsOfPhoneNumber = new LetterCombinationsOfPhoneNumber();
        System.out.println(letterCombinationsOfPhoneNumber.letterCombinations("23"));
    }

    private void dfs(int k, char[] c, String s) {

        if (k < 0) {

            if (!result.contains(s)) result.add(s);
            return;
        }

        Set<Character> set = map.get(c[k]);
        for (Character ch : set) dfs(k-1, c, ch + s);
    }

    public List<String> letterCombinations(String digits) {

        int n = digits.length();
        if (n == 0) return result;
        char[] c = digits.toCharArray();
        map.put('2', new HashSet<>(Arrays.asList('a', 'b', 'c')));
        map.put('3', new HashSet<>(Arrays.asList('d', 'e', 'f')));
        map.put('4', new HashSet<>(Arrays.asList('g', 'h', 'i')));
        map.put('5', new HashSet<>(Arrays.asList('j', 'k', 'l')));
        map.put('6', new HashSet<>(Arrays.asList('m', 'n', 'o')));
        map.put('7', new HashSet<>(Arrays.asList('p', 'q', 'r', 's')));
        map.put('8', new HashSet<>(Arrays.asList('t', 'u', 'v')));
        map.put('9', new HashSet<>(Arrays.asList('w', 'x', 'y', 'z')));
        dfs(n-1, c, "");
        return result;
    }

}
