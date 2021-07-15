/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Ramanujan {
    public static boolean isRamanujan(long n) {
        // Ramanujan number must be positive
        if (n <= 0) {
            return false;
        }

        long upperBound = Math.round(Math.pow((double) n, 1.0 / 3.0)); // n^{1/3}
        int found = 0; // a counter

        long a = 1; // an integer
        long b = 1; // another integer
        long c = 1;
        long d = 1;

        for (long i = 1; i <= upperBound; i++) {
            a = i; // Start from 1 to n^{1/3}
            b = Math.round(Math.pow((n - a * a * a), 1.0 / 3.0)); // b = (n - a^3)^{1/3}
            // Ramanujan number: a^3 + b^3 = n and a, b are distinct
            if ((a * a * a + b * b * b == n) && (a != b)) {
                found += 1;
                if (found == 1) {
                    c = a;
                    d = b;
                }
                // Ramanujan number exists if we found two pairs of such (a, b)
                if ((found == 2) && (c != a) && (c != b) && (d != a) && (d != b)) {
                    return true;
                }
            }
        }
        // Otherwise, it doesn't exist
        return false;
    }

    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        System.out.println(isRamanujan(n));
    }
}
