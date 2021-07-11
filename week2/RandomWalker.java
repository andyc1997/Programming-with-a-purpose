/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class RandomWalker {
    public static void main(String[] args) {
        // Input variables
        int r = Integer.parseInt(args[0]);
        // Start at (0, 0), step = 0
        int row = 0;
        int col = 0;
        int count = 0;
        double move;
        // Print out (0, 0)
        System.out.println("(0, 0)");
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
            count += 1; // increment the step and print
            System.out.println("(" + row + ", " + col + ")");
        }
        // Print total step
        System.out.println("steps = " + count);
    }
}
