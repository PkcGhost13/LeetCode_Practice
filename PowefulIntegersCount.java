package LeetCode_Practice;
import java.util.ArrayList;
import java.util.List;

public class PowefulIntegersCount {
    public static long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        long suffix = Long.parseLong(s);
        if (suffix > finish) {
            return 0;
        }
        int count = 0;
        String str = String.valueOf(finish);
        int noOfLoops = Math.abs(s.length() - str.length());
        List<String> prefixList = getPossiblePrefixes(limit, noOfLoops);
        for (String prefix : prefixList) {
            int newNum = Integer.parseInt(prefix + s);
            System.out.println(newNum);
            if (newNum >= start && newNum <= finish) {
                count++;
            }
        }
        return count;
    }

    public static List<String> getPossiblePrefixes(int limit, int lengthOfPrefix) {
        List<String> prefixList = new ArrayList<>();
        for (int i = 0; i <= lengthOfPrefix; i++) {
            for (int j = 0; j <= limit; j++) {
                String prefix = i + "" + j;
                System.out.println(prefix);
                prefixList.add(prefix);
            }
        }
        System.out.println("Size :" + prefixList.size());
        return prefixList;
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter start: ");
        long start = scanner.nextLong();
        System.out.print("Enter finish: ");
        long finish = scanner.nextLong();
        System.out.print("Enter limit: ");
        int limit = scanner.nextInt();
        System.out.print("Enter string s: ");
        String s = scanner.next();
        scanner.close();
        System.out.println(numberOfPowerfulInt(start, finish, limit, s));
    }
}

class Solution {
    public static int numberOfPowerfulInt(long start, long finish, int limit, String suffix) {
        return countPowerfulUpTo(finish, limit, suffix) - countPowerfulUpTo(start - 1, limit, suffix);
    }

    private static int countPowerfulUpTo(long num, int limit, String suffix) {
        String numStr = String.valueOf(num);
        int prefixLength = numStr.length() - suffix.length();

        if (prefixLength < 0)
            return 0;

        int[][] dp = new int[prefixLength + 1][2];
        dp[prefixLength][0] = 1;
        String suffixFromNum = numStr.substring(prefixLength);
        dp[prefixLength][1] = Integer.parseInt(suffixFromNum) >= Integer.parseInt(suffix) ? 1 : 0;

        for (int i = prefixLength - 1; i >= 0; i--) {
            int digitFromNum = Character.getNumericValue(numStr.charAt(i));

            dp[i][0] = (limit + 1) * dp[i + 1][0];

            if (digitFromNum <= limit) {
                dp[i][1] = digitFromNum * dp[i + 1][0] + dp[i + 1][1];
            } else {
                dp[i][1] = (limit + 1) * dp[i + 1][0];
            }
        }
        return dp[0][1];
    }

}