import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public static boolean wordBreak(String s, String[] d) {
    // code here
    Set<String> set = new HashSet<>(Arrays.asList(d));
    int n = s.length(), m = 0;
    for (String w : d) m = Math.max(m, w.length());
    boolean[] dp = new boolean[n + 1];
    dp[0] = true;
    for (int i = 0; i < n; i++) {
        if (!dp[i]) continue;
        for (int j = 1; j <= m && i + j <= n; j++) {
            String sub = s.substring(i, i + j);
            if (set.contains(sub))
                dp[i + j] = true;
        }
    }
    return dp[n];
}

public static void main (String args[]) {
    String s = "abcd";
    String[] d = {"ab", "bcd", "b", "a"};
    System.out.println(wordBreak(s, d));
}