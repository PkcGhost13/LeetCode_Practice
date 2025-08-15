public class MinSkips {
    public int minSkips(int[] A, int s, int target) {
        int n = A.length, dp[] = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = n; j >= 0; --j) {
                dp[j] += A[i];
                if (i < n - 1)
                    dp[j] = (dp[j] + s - 1) / s * s; // take a rest
                if (j > 0)
                    dp[j] = Math.min(dp[j], dp[j - 1] + A[i]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (dp[i] <= (long) s * target)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        MinSkips ms = new MinSkips();
        int[] A = {7,3,5,5};
        int s = 2;
        int target = 10;
        System.out.println(ms.minSkips(A, s, target)); // Output: 2
    }
}
