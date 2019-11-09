package medium;

import java.util.ArrayList;
import java.util.List;

/*
    Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 */
public class RestoreIPAddresses {

    private List<String> result = new ArrayList<>();

    public static void main(String... args) {

        RestoreIPAddresses restoreIPAddresses = new RestoreIPAddresses();
        System.out.println(restoreIPAddresses.restoreIpAddresses("25525511135"));
    }

    private void dfs(int k, String s, String ip) {

        int n = s.length();

        if (n == 0) {

            if (k != 0) return;
            ip = ip.substring(1);
            if (result.contains(ip)) return;
            result.add(ip);
            return;
        }

        char c = s.charAt(0);

        if (c == '0') dfs(k-1, s.substring(1), ip + ".0");
        else {

            dfs(k-1, s.substring(1), ip + "." + c);

            if (n >= 2) {

                dfs(k-1, s.substring(2), ip + "." + s.substring(0, 2));

                if (n >= 3) {

                    String s1 = s.substring(0, 3);

                    if (Integer.parseInt(s1) <= 255)
                        dfs(k-1, s.substring(3), ip + "." + s1);
                }
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {

        int n = s.length();
        if (n < 4 || n > 12) return result;
        dfs(4, s, "");
        return result;
    }

}
