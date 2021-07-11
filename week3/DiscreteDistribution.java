/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] distribution = new int[args.length];
        int sum = 0;

        for (int i = 0; i < args.length - 1; i++) {
            distribution[i] = Integer.parseInt(args[i + 1]);
            sum += distribution[i];
            if (i > 0) {
                distribution[i] += distribution[i - 1];
            }
        }

        for (int i = 0; i < m; i++) {
            // Random number and print indices
            double rand = Math.random();
            for (int j = 0; j < distribution.length; j++) {
                if (rand < ((double) distribution[j]) / sum) {
                    System.out.print(j + 1);
                    break;
                }
            }
            // Print whitespace
            if ((i + 1) % 25 != 0) {
                System.out.print(" ");
            }
            else {
                System.out.println("");
            }
        }
    }
}
