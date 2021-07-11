/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class GreatCircle {
    public static void main(String[] args) {
        // Input variables
        double x1 = Double.parseDouble(args[0]);
        double y1 = Double.parseDouble(args[1]);
        double x2 = Double.parseDouble(args[2]);
        double y2 = Double.parseDouble(args[3]);
        // Haversine formula
        double sumFirst = Math.pow(Math.sin(Math.toRadians((x2 - x1) / 2)), 2);
        double sumSecond = Math.pow(Math.sin(Math.toRadians((y2 - y1) / 2)), 2);
        double r = 6371.0;
        double results = 2 * r * Math.asin(Math.sqrt(
                sumFirst + Math.cos(Math.toRadians(x1)) * Math.cos(Math.toRadians(x2))
                        * sumSecond));
        // Output
        System.out.println(Double.toString(results) + " kilometers");
    }
}
