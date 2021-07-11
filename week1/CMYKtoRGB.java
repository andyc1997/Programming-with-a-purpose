/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class CMYKtoRGB {
    public static void main(String[] args) {
        // Input variables
        double cyan = Double.parseDouble(args[0]);
        double magenta = Double.parseDouble(args[1]);
        double yellow = Double.parseDouble(args[2]);
        double black = Double.parseDouble(args[3]);
        // RBG colour
        double red = Math.round(255 * (1 - black) * (1 - cyan));
        double green = Math.round(255 * (1 - black) * (1 - magenta));
        double blue = Math.round(255 * (1 - black) * (1 - yellow));
        // Output
        System.out.println("red   = " + (int) red);
        System.out.println("green = " + (int) green);
        System.out.println("blue  = " + (int) blue);
    }
}
