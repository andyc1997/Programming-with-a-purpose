/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class RightTriangle {
    public static void main(String[] args) {
        long a = Long.parseLong(args[0]);
        long b = Long.parseLong(args[1]);
        long c = Long.parseLong(args[2]);
        boolean arePositive = (a > 0) && (b > 0) && (c > 0);
        boolean isRightTriangle = ((a * a + b * b == c * c) || (a * a + c * c == b * b) || (
                b * b + c * c == a * a));
        System.out.println(arePositive && isRightTriangle);
    }
}
