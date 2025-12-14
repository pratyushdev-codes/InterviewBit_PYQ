import java.util.*;

public class DistributeCandy {
    public int candy(ArrayList<Integer> A) {
        int n = A.size();
        if (n == 0) return 0;

        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        // Left to Right pass
        for (int i = 1; i < n; i++) {
            if (A.get(i) > A.get(i - 1)) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Right to Left pass
        for (int i = n - 2; i >= 0; i--) {
            if (A.get(i) > A.get(i + 1)) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Sum total candies
        int total = 0;
        for (int c : candies) {
            total += c;
        }

        return total;
    }
}
