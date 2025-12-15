public class DistinctSubsequence {
    public int numDistinct(String A, String B) {
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n][m];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return countSeq(A, B, n - 1, m - 1, dp);
    }

    public int countSeq(String A, String B, int i, int j, int[][] dp) {
        // BASE CASES
        if (j < 0) return 1;   // matched all of B
        if (i < 0) return 0;   // A exhausted

        if (dp[i][j] != -1) return dp[i][j];

        if (A.charAt(i) == B.charAt(j)) {
            dp[i][j] = countSeq(A, B, i - 1, j - 1, dp)
                     + countSeq(A, B, i - 1, j, dp);
        } else {
            dp[i][j] = countSeq(A, B, i - 1, j, dp);
        }

        return dp[i][j];
    }
}
