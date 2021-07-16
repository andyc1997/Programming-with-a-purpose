/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Huntingtons {

    public static int maxRepeats(String dna) {
        int count = 0;
        int maxCount = 0;
        int i = 0;
        String currCodon;

        while (i <= dna.length() - 3) {
            currCodon = dna.substring(i, i + 3);
            if (currCodon.equals("CAG")) {
                count += 1;
                i += 3;
                if (count > maxCount) maxCount = count; // Handling tail case
            }
            else {
                // if (count > maxCount) maxCount = count; // Non tail case
                count = 0;
                i += 1;
            }
            // System.out.println("count: " + count + " maxCount: " + maxCount);
        }
        return maxCount;
    }

    public static String removeWhitespace(String s) {
        s = s.replace(" ", "");
        s = s.replace("\n", "");
        s = s.replace("\t", "");
        return s;
    }

    public static String diagnose(int maxRepeats) {
        if ((maxRepeats >= 10) && (maxRepeats <= 35)) return "normal";
        else if ((maxRepeats >= 36) && (maxRepeats <= 39)) return "high risk";
        else if ((maxRepeats >= 40) && (maxRepeats <= 180)) return "Huntington’s";
        else return "not human";
    }

    public static void main(String[] args) {
        String inputGene = new In(args[0]).readAll();
        int found = maxRepeats(removeWhitespace(inputGene));
        System.out.println("max repeats = " + found);
        System.out.println(diagnose(found));
    }
}
