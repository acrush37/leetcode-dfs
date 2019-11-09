package medium;

import java.util.ArrayList;
import java.util.List;

/*
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class GenerateParentheses {

    private List<String> result = new ArrayList<>();

    public static void main(String... args) {

        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesis(3));
    }

    private void dfs(int x, int y, String s) {

        if (x == 0 && y == 0) {

            result.add(s);
            return;
        }

        if (x == 0) dfs(x, y-1, s + ")");
        else {

            dfs(x - 1, y, s + "(");
            if (x < y) dfs(x, y - 1, s + ")");
        }
    }

    public List<String> generateParenthesis(int n) {

        dfs(n, n, "");
        return result;
    }

}
