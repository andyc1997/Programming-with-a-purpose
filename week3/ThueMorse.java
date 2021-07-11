/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class ThueMorse {
    public static void main(String[] args) {
        // Input variables
        int n = Integer.parseInt(args[0]);
        int[] MorseArray = new int[n];
        // Construct Thue-Morse sequence using recurrence relation
        if (n > 1) {
            for (int i = 0; i < n; i++) {
                if (2 * i < n) MorseArray[2 * i] = MorseArray[i];
                if (2 * i + 1 < n) MorseArray[2 * i + 1] = 1 - MorseArray[i];
            }
        }
        // Print array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (MorseArray[i] == MorseArray[j]) {
                    if (j > 0) {
                        System.out.print("  ");
                    }
                    System.out.print("+");
                }
                else {
                    if (j > 0) {
                        System.out.print("  ");
                    }
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }
}
