/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Inversions {

    public static long count(int[] a) {
        long numInversions = 0;

        if (a.length == 0) {
            return 0;
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) numInversions++;
            }
        }
        return numInversions;
    }

    public static int[] generate(int n, long k) {
        int[] inversedArray = new int[n];

        if ((n == k) && (k == 0)) {
            return inversedArray;
        }

        int j = 0;
        for (int i = 0; i < n; i++) {
            if (k >= n - i - 1) {
                inversedArray[i] = n - 1 - j;
                j++;
                k -= inversedArray[i];
            }
            else {
                inversedArray[i] = i - j;
            }
        }
        return inversedArray;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);

        int[] inversedArray = generate(n, k);

        for (int i = 0; i < inversedArray.length; i++) {
            System.out.print(inversedArray[i] + " ");
        }
    }
}
