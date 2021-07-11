/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class BandMatrix {
    public static void main(String[] args) {
        // Input variables
        int n = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);
        // Print band matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // If the entry is inside the band
                if (Math.abs(j - i) <= width) {
                    if (j == 0) {
                        System.out.print("*");
                    }
                    else {
                        System.out.print("  *");
                    }
                } // Otherwise
                else {
                    if (j == 0) {
                        System.out.print("0");
                    }
                    else {
                        System.out.print("  0");
                    }
                }
            }
            System.out.println("");
        }
    }
}
