/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class RandomWalkers {
    public static void main(String[] args) {
        // Input variables
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        // Simulations
        int total = 0;
        for (int i = 0; i < trials; i++) {
            // Start at (0, 0), step = 0
            int row = 0;
            int col = 0;
            int count = 0;
            double move;
            // As long as Manhattan distance < r
            while (Math.abs(col) + Math.abs(row) < r) {
                move = Math.random(); // Random probability
                if (move <= 0.25) {
                    row -= 1; // left
                }
                else if (move <= 0.50) {
                    row += 1; // right
                }
                else if (move <= 0.75) {
                    col -= 1; // down
                }
                else {
                    col += 1; // up
                }
                count += 1;
            }
            total += count;
        }
        // Compute average
        double average = ((double) total) / trials;
        System.out.println("average number of steps = " + average);
    }
}
