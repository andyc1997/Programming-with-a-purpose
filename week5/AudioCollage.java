/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class AudioCollage {
    public static double[] amplify(double[] a, double alpha) {
        double[] amplifiedAudio = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            amplifiedAudio[i] = alpha * a[i];
        }
        return amplifiedAudio;
    }

    public static double[] reverse(double[] a) {
        double[] reversedAudio = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            reversedAudio[i] = a[a.length - 1 - i];
        }
        return reversedAudio;
    }

    public static double[] merge(double[] a, double[] b) {
        // New array for merged audio
        int newSize = a.length + b.length;
        double[] mergedAudio = new double[newSize];
        // Fill audio A
        for (int i = 0; i < a.length; i++) {
            mergedAudio[i] = a[i];
        }
        // Append audio B
        for (int i = 0; i < b.length; i++) {
            mergedAudio[a.length + i] = b[i];
        }
        return mergedAudio;
    }

    public static double[] mix(double[] a, double[] b) {
        int outputSize;
        double[] mixedAudio;
        // Swap if Audio A is shorter in length
        if (a.length < b.length) {
            double[] temp = new double[a.length];
            for (int i = 0; i < a.length; i++) {
                temp[i] = a[i];
            }
            a = b;
            b = temp;
        }
        // Mixing
        outputSize = a.length;
        mixedAudio = new double[outputSize];
        for (int i = 0; i < a.length; i++) {
            if (i < b.length) {
                mixedAudio[i] = b[i];
            }
            mixedAudio[i] += a[i];
        }
        return mixedAudio;
    }

    public static double[] changeSpeed(double[] a, double alpha) {
        // Resampled audio
        int newSize = (int) Math.floor(a.length / alpha);
        double[] speededAudio = new double[newSize];
        // Resampling
        for (int i = 0; i < newSize; i++) {
            speededAudio[i] = a[(int) Math.floor(i * alpha)];
        }
        return speededAudio;
    }

    private static double[] normalize(double[] a) {
        // Find the note with the highest pitch
        double maxNote = 0;
        for (int i = 0; i < a.length; i++) {
            if (Math.abs(a[i]) > maxNote) {
                maxNote = Math.abs(a[i]);
            }
        }
        // Normalize the audio
        for (int i = 0; i < a.length; i++) {
            a[i] /= maxNote;
        }
        return a;
    }

    public static void main(String[] args) {
        double[] samples_a = StdAudio.read("beatbox.wav");
        double[] samples_b = StdAudio.read("buzzer.wav");
        double[] samples_c = StdAudio.read("chimes.wav");
        double[] samples_d = StdAudio.read("cow.wav");
        double[] samples_e = StdAudio.read("dialup.wav");
        double[] output = merge(merge(mix(merge(samples_a, changeSpeed(samples_e, 2.0)),
                                          amplify(samples_c, 0.2)), amplify(samples_b, 0.2)),
                                amplify(samples_d, 0.5));
        StdAudio.play(normalize(output));
    }
}
