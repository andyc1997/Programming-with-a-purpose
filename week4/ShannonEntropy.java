/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int count = 0;
        double shannonEntropy = 0;
        int[] stateArray = new int[m];

        while (!StdIn.isEmpty()) {
            int element = StdIn.readInt();
            stateArray[element - 1] += 1;
            count += 1;
        }

        for (int i = 0; i < stateArray.length; i++) {
            double p = ((double) stateArray[i]) / count;
            if (stateArray[i] == 0) {
                continue;
            }
            else {
                shannonEntropy += p * Math.log(p) / Math.log(2);
            }
        }
        shannonEntropy *= -1;
        StdOut.printf("%.4f", shannonEntropy);
    }
}
