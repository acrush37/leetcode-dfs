package medium;

/*
    Given an encoded string, return its decoded string.

    The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
    Note that k is guaranteed to be a positive integer.

    You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

    Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
    For example, there won't be input like 3a or 2[4].
 */
public class DecodeString {

    private int i = 0;
    public static void main(String... args) {

        DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString("2[abc]3[cd]ef"));
    }

    private String dfs(int n, char[] s, String r) {

        int count = 0;

        while (i < n) {

            char c = s[i++];
            if (c == ']') break;

            if ('0' <= c && c <= '9') {
                count = count * 10 + c - '0';
            } else if (c == '[') {

                String in = dfs(n, s, "");
                for (; count != 0; --count) r += in;
            } else {
                r += c;
            }
        }

        return r;
    }

    public String decodeString(String s) {
        return dfs(s.length(), s.toCharArray(), "");
    }

}
