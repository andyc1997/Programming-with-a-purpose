/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class ActivationFunction {
    public static double heaviside(double x) {
        if (Double.isNaN(x) == true) {
            return Double.NaN;
        }
        else if (x < 0.0) {
            return 0.0;
        }
        else if (x == 0) {
            return 0.5;
        }
        return 1.0;
    }

    public static double sigmoid(double x) {
        if (Double.isNaN(x) == true) {
            return Double.NaN;
        }
        return 1.0 / (1 + Math.exp(-x));
    }

    public static double tanh(double x) {
        if (Double.isNaN(x) == true) {
            return Double.NaN;
        }
        else if (x >= 20.0) {
            return 1.0;
        }
        else if (x <= -20.0) {
            return -1.0;
        }
        double a = Math.exp(x);
        double b = Math.exp(-x);
        return (a - b) / (a + b);
    }

    public static double softsign(double x) {
        if (Double.isNaN(x) == true) {
            return Double.NaN;
        }
        else if (Double.isInfinite(x) == true) {
            if (x > 0) {
                return 1.0;
            }
            else if (x < 0) {
                return -1.0;
            }
        }
        return x / (1 + Math.abs(x));
    }

    public static double sqnl(double x) {
        if (Double.isNaN(x) == true) {
            return Double.NaN;
        }
        else if (x <= -2) {
            return -1.0;
        }
        else if (x < 0) {
            return x + x * x / 4;
        }
        else if (x < 2) {
            return x - x * x / 4;
        }
        return 1.0;
    }

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        System.out.println("heaviside(" + x + ") = " + heaviside(x));
        System.out.println("  sigmoid(" + x + ") = " + sigmoid(x));
        System.out.println("     tanh(" + x + ") = " + tanh(x));
        System.out.println(" softsign(" + x + ") = " + softsign(x));
        System.out.println("     sqnl(" + x + ") = " + sqnl(x));
    }
}
