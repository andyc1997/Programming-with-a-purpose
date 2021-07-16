/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class ColorHSB {
    private final int hue;
    private final int saturation;
    private final int brightness;

    public ColorHSB(int h, int s, int b) {
        // Class variable
        hue = h;
        saturation = s;
        brightness = b;
        // Handle exception
        if ((hue < 0) || (hue > 359))
            throw new IllegalArgumentException("the hue must be between 0 and 359");
        if ((saturation < 0) || (saturation > 100))
            throw new IllegalArgumentException("the saturation must be between 0 and 100");
        if ((brightness < 0) || (brightness > 100))
            throw new IllegalArgumentException("the brightness must be between 0 and 100");
    }

    public String toString() {
        String output = "(" + hue + ", " + saturation + ", " + brightness + ")";
        return output;
    }

    public boolean isGrayscale() {
        return (saturation == 0) || (brightness == 0);
    }

    public int distanceSquaredTo(ColorHSB that) {
        if (that == null)
            throw new IllegalArgumentException("the input cannot be null");

        int diffHue = (hue - that.hue);
        int diffSaturation = (saturation - that.saturation);
        int diffBrightness = (brightness - that.brightness);

        return Math.min(diffHue * diffHue, (360 - Math.abs(diffHue)) * (360 - Math.abs(diffHue))) +
                diffSaturation * diffSaturation + diffBrightness * diffBrightness;
    }

    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);

        ColorHSB color = new ColorHSB(h, s, b);

        String codeColor;
        String mincodeColor = "";
        ColorHSB minColor = color;
        int inputHue;
        int inputSaturation;
        int inputBrightness;
        int minDist = 1000000;

        while (!StdIn.isEmpty()) {
            codeColor = StdIn.readString();
            inputHue = StdIn.readInt();
            inputSaturation = StdIn.readInt();
            inputBrightness = StdIn.readInt();

            ColorHSB inputColor = new ColorHSB(inputHue, inputSaturation, inputBrightness);
            int tempDist = color.distanceSquaredTo(inputColor);
            if (tempDist < minDist) {
                mincodeColor = codeColor;
                minColor = inputColor;
                minDist = tempDist;
            }
        }
        System.out.println(mincodeColor + " " + minColor.toString());
    }
}
