/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Divisors {
    public static int gcd(int a, int b) {
        if ((a == 0) && (b == 0)) {
            return 0;
        }

        a = Math.abs(a);
        b = Math.abs(b);
        int temp;

        while (b > 0) {
            temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        int output = Math.abs(a) / gcd(a, b);
        return output * Math.abs(b);
    }

    public static boolean areRelativelyPrime(int a, int b) {
        boolean output = (gcd(a, b) == 1);
        return output;
    }

    public static int totient(int n) {
        int output = 0;
        for (int i = 1; i <= n; i++) {
            if (gcd(i, n) == 1) {
                output++;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        System.out.println("gcd(" + a + ", " + b + ") = " + gcd(a, b));
        System.out.println("lcm(" + a + ", " + b + ") = " + lcm(a, b));
        System.out
                .println("areRelativelyPrime(" + a + ", " + b + ") = " + areRelativelyPrime(a, b));
        System.out.println("totient(" + a + ") = " + totient(a));
        System.out.println("totient(" + b + ") = " + totient(b));
    }
}
