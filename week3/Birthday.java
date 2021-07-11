/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Birthday {
    public static void main(String[] args) {
        // Input variables
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int[] totalCount = new int[n + 2];
        // Simulations for trials
        for (int i = 0; i < trials; i++) {
            // Internal variables
            int[] birthdayCount = new int[n];
            int peopleInRoom = 0;
            boolean repeat = true;
            // Internal loops
            while (repeat) {
                int birthdayDate = (int) (Math.random() * n);
                birthdayCount[birthdayDate] += 1;
                peopleInRoom += 1;
                // Break if 2 people share the same birthday
                if (birthdayCount[birthdayDate] > 1) {
                    totalCount[peopleInRoom - 1] += 1;
                    repeat = false;
                }
            }
        }
        // Calculate fractions
        double runningSum = 0;
        for (int i = 0; i < totalCount.length; i++) {
            System.out.print(i + 1);
            runningSum += totalCount[i];
            if (i == 0) { // Special formating for the 1st row
                System.out
                        .println("\t" + totalCount[i] + "\t\t" + runningSum / trials);
            }
            else {
                System.out
                        .println("\t" + totalCount[i] + "\t" + runningSum / trials);
            }
            if (runningSum / trials >= 0.50) {
                // System.out.println("Checking: " + runningSum + " " + trials);
                break;
            }
        }
    }
}
