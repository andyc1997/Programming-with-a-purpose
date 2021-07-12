/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import java.awt.Color;

public class Checkerboard {
    public static void main(String[] args) {
        // Input variable
        int n = Integer.parseInt(args[0]);
        // Set canvas
        StdDraw.setScale(0, n);
        // Fill checker board
        for (int i = 0; i < n; i++) { // column
            for (int j = 0; j < n; j++) { // row
                // Set colour
                Color drawCol;
                if (((i % 2 != 0) && (j % 2 == 0)) || ((i % 2 == 0) && (j % 2 != 0))) {
                    drawCol = StdDraw.LIGHT_GRAY;
                }
                else {
                    drawCol = StdDraw.BLUE;
                }
                // Draw
                StdDraw.setPenColor(drawCol);
                StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
            }
        }
    }
}
