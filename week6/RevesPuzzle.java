/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class RevesPuzzle {
    private static void hanoi(int n, int stop, String from, String temp, String to) {
        if (n == stop) return;
        hanoi(n - 1, stop, from, to, temp);
        System.out.println("Move disc " + n + " from " + from + " to " + to);
        hanoi(n - 1, stop, temp, from, to);
    }

    private static int getSmallestMove(int n) {
        return (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));
    }

    private static void traversalPrint(int n, int stop, String from, String temp,
                                       String to) {
        if (n == stop) return;
        traversalPrint(n - 1, stop, from, to, temp);
        System.out.println("Move disc " + n + " from " + from + " to " + to);
        traversalPrint(n - 1, stop, temp, from, to);
    }

    private static void methodFrameStewart(int n, String from, String temp, String temp2,
                                           String to) {
        int k = getSmallestMove(n);
        if (k == 1) {
            System.out.println("Move disc " + k + " from " + from + " to " + to);
            return;
        }
        else if (k == 2) {
            System.out.println("Move disc " + (k - 1) + " from " + from + " to " + temp2);
            System.out.println("Move disc " + k + " from " + from + " to " + to);
            System.out.println("Move disc " + (k - 1) + " from " + temp2 + " to " + to);
            return;
        }
        else if (k == 3) {
            System.out.println("Move disc " + (k - 2) + " from " + from + " to " + temp2);
            System.out.println("Move disc " + (k - 1) + " from " + from + " to " + temp);
            System.out.println("Move disc " + k + " from " + from + " to " + to);
            System.out.println("Move disc " + (k - 1) + " from " + temp + " to " + to);
            System.out.println("Move disc " + (k - 2) + " from " + temp2 + " to " + to);
            return;
        }
        methodFrameStewart(k, from, temp, to, temp2);
        traversalPrint(k, getSmallestMove(k), from, temp, to);
        methodFrameStewart(k, temp2, temp, from, to);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        if (n == 1) {
            System.out.println("Move disc " + n + " from A to D");
        }
        else {
            methodFrameStewart(n, "A", "C", "D", "B");
            hanoi(n, getSmallestMove(n), "A", "C", "D");
            methodFrameStewart(n, "B", "C", "A", "D");
        }
    }
}
