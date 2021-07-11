/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class GeneralizedHarmonic {
    public static void main(String[] args) {
        // Input variables
        long n = Integer.parseInt(args[0]);
        long r = Integer.parseInt(args[1]);
        // Harmonic numbers
        double harmonic = 0;
        for (int i = 0; i < n; i++) {
            harmonic += 1.0 / Math.pow(i + 1, r);
        }
        System.out.println(harmonic);
    }
}
