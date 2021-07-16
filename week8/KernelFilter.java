/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import java.awt.Color;

public class KernelFilter {
    private static Color operatorKernel(int c, int r, Picture picture, double[][] kernel) {
        double red = 0;
        double blue = 0;
        double green = 0;

        for (int i = 0; i < kernel[0].length; i++) {
            for (int j = 0; j < kernel[0].length; j++) {
                // Pixel on which to be operated
                int targetR = r - 1 + i;
                int targetC = c - 1 + j;
                // Periodic boundary conditions
                if (r == 0) {
                    if (i == 0) targetR = picture.height() - 1;
                }

                if (r == picture.height() - 1) {
                    if (i == kernel[0].length - 1) targetR = 0;
                }

                if (c == 0) {
                    if (j == 0) targetC = picture.width() - 1;

                }

                if (c == picture.width() - 1) {
                    if (j == kernel[0].length - 1) targetC = 0;
                }
                // Convolution
                red += kernel[i][j] * picture.get(targetC, targetR).getRed();
                blue += kernel[i][j] * picture.get(targetC, targetR).getBlue();
                green += kernel[i][j] * picture.get(targetC, targetR).getGreen();
            }
        }
        // Rounding
        int Red = (int) Math.round(red);
        int Blue = (int) Math.round(blue);
        int Green = (int) Math.round(green);
        // Clamping
        if (Red < 0) Red = 0;
        else if (Red > 255) Red = 255;
        if (Blue < 0) Blue = 0;
        else if (Blue > 255) Blue = 255;
        if (Green < 0) Green = 0;
        else if (Green > 255) Green = 255;
        // New color
        return new Color(Red, Green, Blue);
    }

    private static Color operatorMotionBlurKernel(int c, int r, Picture picture) {
        double red = 0;
        double blue = 0;
        double green = 0;

        for (int i = 0; i < 9; i++) {
            // Pixel on which to be operated
            int targetR = r - 4 + i;
            int targetC = c - 4 + i;
            // Periodic boundary conditions
            if (r - 4 + i < 0) targetR = Math.floorMod((r - 4 + i), picture.height());
            if (r - 4 + i >= picture.height())
                targetR = Math.floorMod((r - 4 + i), picture.height());
            if (c - 4 + i < 0) targetC = Math.floorMod((c - 4 + i), picture.width());
            if (c - 4 + i >= picture.width()) targetC = Math.floorMod((c - 4 + i), picture.width());
            // Convolution
            red += picture.get(targetC, targetR).getRed();
            blue += picture.get(targetC, targetR).getBlue();
            green += picture.get(targetC, targetR).getGreen();
        }
        // Rounding
        int Red = (int) (Math.round(red / 9.0));
        int Blue = (int) (Math.round(blue / 9.0));
        int Green = (int) (Math.round(green / 9.0));
        // Clamping
        if (Red < 0) Red = 0;
        else if (Red > 255) Red = 255;
        if (Blue < 0) Blue = 0;
        else if (Blue > 255) Blue = 255;
        if (Green < 0) Green = 0;
        else if (Green > 255) Green = 255;
        // New color
        return new Color(Red, Green, Blue);
    }

    public static Picture identity(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        Picture target = new Picture(width, height);

        for (int c = 0; c < width; c++) {
            for (int r = 0; r < height; r++) {
                target.set(c, r, picture.get(c, r));
            }
        }
        return target;
    }

    public static Picture gaussian(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        Picture target = new Picture(width, height);

        double[][] kernel = {
                { 0.0625, 0.125, 0.0625 }, { 0.125, 0.250, 0.125 }, { 0.0625, 0.125, 0.0625 }
        };

        for (int c = 0; c < width; c++) {
            for (int r = 0; r < height; r++) {
                target.set(c, r, operatorKernel(c, r, picture, kernel));
            }
        }
        return target;
    }

    public static Picture sharpen(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        Picture target = new Picture(width, height);

        double[][] kernel = { { 0.0, -1.0, 0.0 }, { -1.0, 5.0, -1.0 }, { 0.0, -1.0, 0.0 } };

        for (int c = 0; c < width; c++) {
            for (int r = 0; r < height; r++) {
                target.set(c, r, operatorKernel(c, r, picture, kernel));
            }
        }
        return target;
    }

    public static Picture laplacian(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        Picture target = new Picture(width, height);

        double[][] kernel = { { -1.0, -1.0, -1.0 }, { -1.0, 8.0, -1.0 }, { -1.0, -1.0, -1.0 } };

        for (int c = 0; c < width; c++) {
            for (int r = 0; r < height; r++) {
                target.set(c, r, operatorKernel(c, r, picture, kernel));
            }
        }
        return target;
    }

    public static Picture emboss(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        Picture target = new Picture(width, height);

        double[][] kernel = { { -2.0, -1.0, 0.0 }, { -1.0, 1.0, 1.0 }, { 0.0, 1.0, 2.0 } };

        for (int c = 0; c < width; c++) {
            for (int r = 0; r < height; r++) {
                target.set(c, r, operatorKernel(c, r, picture, kernel));
            }
        }
        return target;
    }

    public static Picture motionBlur(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        Picture target = new Picture(width, height);

        for (int c = 0; c < width; c++) {
            for (int r = 0; r < height; r++) {
                target.set(c, r, operatorMotionBlurKernel(c, r, picture));
            }
        }
        return target;
    }

    public static void main(String[] args) {
        String filename = args[0];
        String reffilename = args[1];
        Picture sourcePic = new Picture(filename); // baboon.png
        Picture refPic = new Picture(reffilename); // baboon-motion.png
        identity(sourcePic).show();
        gaussian(sourcePic).show();
        sharpen(sourcePic).show();
        laplacian(sourcePic).show();
        emboss(sourcePic).show();
        System.out.println(
                motionBlur(sourcePic).get(0, 0).getRed() + " " +
                        motionBlur(sourcePic).get(0, 0).getGreen()
                        + " " + motionBlur(sourcePic).get(0, 0).getBlue());
        System.out.println(refPic.get(0, 0).getRed() + " " +
                                   refPic.get(0, 0).getGreen()
                                   + " " + refPic.get(0, 0).getBlue());
    }
}
