/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        int[] Mines = new int[m * n];
        int[][] MinesSweeper = new int[m][n];

        // Initialize the mine and shuffle them
        for (int i = 0; i < Mines.length; i++) {
            if (i < k) {
                Mines[i] = -1;
            }
            else {
                Mines[i] = 0;
            }
        }

        for (int i = 0; i < Mines.length; i++) {
            int randomPos = i + (int) (Math.random() * (Mines.length - i));
            int temp = Mines[randomPos];
            Mines[randomPos] = Mines[i];
            Mines[i] = temp;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // System.out.println("i: " + i + ", j: " + j);
                MinesSweeper[i][j] = Mines[i * n + j];
            }
        }

        // Print
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j > 0) {
                    System.out.print("  ");
                }
                if (MinesSweeper[i][j] == -1) {
                    System.out.print("*");
                }
                else {
                    int countMines = 0;
                    if (i > 0) {
                        if (j > 0 && MinesSweeper[i - 1][j - 1] == -1) {
                            countMines += 1;
                        }
                        if (MinesSweeper[i - 1][j] == -1) {
                            countMines += 1;
                        }
                        if (j < (n - 1) && MinesSweeper[i - 1][j + 1] == -1) {
                            countMines += 1;
                        }
                    }
                    if (i < (m - 1)) {
                        if (j > 0 && MinesSweeper[i + 1][j - 1] == -1) {
                            countMines += 1;
                        }
                        if (MinesSweeper[i + 1][j] == -1) {
                            countMines += 1;
                        }
                        if (j < (n - 1) && MinesSweeper[i + 1][j + 1] == -1) {
                            countMines += 1;
                        }
                    }
                    if (j > 0 && MinesSweeper[i][j - 1] == -1) {
                        countMines += 1;
                    }
                    if (j < (n - 1) && MinesSweeper[i][j + 1] == -1) {
                        countMines += 1;
                    }
                    System.out.print(countMines);
                }
            }
            System.out.println();
        }
    }
}
