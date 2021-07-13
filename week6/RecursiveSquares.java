/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class RecursiveSquares {
    public static void drawSquare(double x, double y, double length) {
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, length / 2);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, length / 2);
    }

    public static void draw(int n, double x, double y, double length) {
        if (n == 1) {
            drawSquare(x, y, length);
            return;
        }
        double eps = length / 2;
        draw(n - 1, x - eps, y + eps, length / 2);
        draw(n - 1, x + eps, y + eps, length / 2);
        drawSquare(x, y, length);
        draw(n - 1, x - eps, y - eps, length / 2);
        draw(n - 1, x + eps, y - eps, length / 2);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        draw(n, 0.50, 0.50, 0.50);
    }
}
