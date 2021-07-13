/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class TrinomialDP {
    public static long trinomial(int n, int k) {
        long[][] dpTable = new long[n + 1][2 * n + 1];
        // Start at middle of the table
        dpTable[0][n] = 1;
        // Exceptional case:
        if ((k > n) || (k < -n)) {
            return 0;
        }
        // Fill dynamic programming table
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < 2 * n + 1; j++) {
                // Left boundary of the table
                if (j == 0) {
                    dpTable[i][j] = dpTable[i - 1][j] + dpTable[i - 1][j + 1];
                }
                // Right boundary of the table
                else if (j == 2 * n) {
                    dpTable[i][j] = dpTable[i - 1][j - 1] + dpTable[i - 1][j];
                }
                // Nonboundary
                else {
                    dpTable[i][j] = dpTable[i - 1][j - 1] + dpTable[i - 1][j] + dpTable[i - 1][j
                            + 1];
                }
            }
        }
        return dpTable[n][k + n];
    }

    public static void main(String[] args) {
        // Input variables
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        System.out.println(trinomial(n, k));
    }
}
