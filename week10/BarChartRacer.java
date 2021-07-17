/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import java.util.Arrays;

public class BarChartRacer {

    public static void main(String[] args) {
        // Input variables
        String filename = args[0];
        int k = Integer.parseInt(args[1]);
        // Draw Bar
        In inputFile = new In(filename);
        String line;

        String title;
        String label;
        String dataSrc;
        String caption = "";

        Bar[] bars;
        BarChart newChart;

        int i = 0;
        int idxBar;
        int numRecord;
        int counter = 0;

        int countHasNextLine = 0;

        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();

        line = inputFile.readLine();
        title = line;
        line = inputFile.readLine();
        label = line;
        line = inputFile.readLine();
        dataSrc = line;
        newChart = new BarChart(title, label, dataSrc);

        while (inputFile.hasNextLine()) {
            // countHasNextLine++;
            line = inputFile.readLine(); // Read a line
            if (line.length() == 0) {
                line = inputFile.readLine(); // Skip empty line
            }
            // Read number of records
            if (i == counter) {
                // Start a new block
                numRecord = Integer.parseInt(line);
                counter += (numRecord + 1);
                bars = new Bar[numRecord];
                idxBar = 0;

                // Read block of data
                for (int j = 0; j < numRecord; j++) {
                    line = inputFile.readLine();
                    // Split line by comma
                    String[] arrLine = line.split(",");
                    // Instance values for Bar object
                    String name = arrLine[1].trim();
                    int value = Integer.parseInt(arrLine[3].trim());
                    String category = arrLine[4].trim();
                    // Create Bar object
                    bars[idxBar] = new Bar(name, value, category);
                    idxBar++;
                    caption = arrLine[0].trim();
                }

                Arrays.sort(bars);
                for (int j = bars.length - 1; j > (bars.length - 1 - k); j--)
                    newChart.add(bars[j].getName(), bars[j].getValue(), bars[j].getCategory());
                newChart.setCaption(caption);

                newChart.draw();
                StdDraw.show();
                StdDraw.pause(100);
                newChart.reset();
                StdDraw.clear();
                i += numRecord;
            }
            i++;
        }
        // System.out.println("Total call: " + countHasNextLine);
    }
}
