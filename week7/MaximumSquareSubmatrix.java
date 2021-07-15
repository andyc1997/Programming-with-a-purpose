/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class MaximumSquareSubmatrix {

    public static int size(int[][] a) {
        int[][] dpTable = new int[a[0].length][a[0].length];
        int prevSize;
        int maxSize = 0;

        for (int i = 0; i < a[0].length; i++) {
            for (int j = i; j < a[0].length; j++) {
                dpTable[i][j] = a[i][j];
                dpTable[j][i] = a[j][i];

                if (dpTable[i][j] > maxSize) maxSize = dpTable[i][j];
                if (dpTable[j][i] > maxSize) maxSize = dpTable[j][i];
            }
        }

        if (a.length == 1) return maxSize;

        for (int i = 1; i < a[0].length; i++) {
            for (int j = i; j < a[0].length; j++) {
                prevSize = Math
                        .min(Math.min(dpTable[i][j - 1], dpTable[i - 1][j]), dpTable[i - 1][j - 1]);
                if (a[i][j] == 1) dpTable[i][j] = prevSize + 1;

                prevSize = Math
                        .min(Math.min(dpTable[j][i - 1], dpTable[j - 1][i]), dpTable[j - 1][i - 1]);
                if (a[j][i] == 1) dpTable[j][i] = prevSize + 1;

                if (dpTable[i][j] > maxSize) maxSize = dpTable[i][j];
                if (dpTable[j][i] > maxSize) maxSize = dpTable[j][i];
            }
        }

        // for (int i = 0; i < dpTable.length; i++) {
        //     for (int j = 0; j < dpTable.length; j++) {
        //         System.out.print(dpTable[i][j] + "  ");
        //     }
        //     System.out.println();
        // }
        return maxSize;
    }

    public static void main(String[] args) {
        // Read input variables
        int n = StdIn.readInt();
        int[][] inputMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inputMatrix[i][j] = StdIn.readInt();
            }
        }
        System.out.println(size(inputMatrix));
    }
}
