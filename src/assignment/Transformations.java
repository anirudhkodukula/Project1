package assignment;
/**
 *
 * CS314H Programming Assignment 1 - Java image processing
 *
 * Included is the Invert effect from the assignment.  Use this as an
 * example when writing the rest of your transformations.  For
 * convenience, you should place all of your transformations in this file.
 *
 * You can compile everything that is needed with
 * javac -d bin src/assignment/*.java
 *
 * You can run the program with
 * java -cp bin assignment.JIP
 *
 * Please note that the above commands assume that you are in the prog1
 * directory.
 */

import java.util.ArrayList;

class Invert extends ImageEffect {
    public int[][] apply(int[][] pixels,
                         ArrayList<ImageEffectParam> params) {
        int width = pixels[0].length;
        int height = pixels.length;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixels[y][x] = ~pixels[y][x];
            }
        }
        return pixels;
    }
}

class NoRed extends ImageEffect {
    public int[][] apply(int[][] pixels,ArrayList<ImageEffectParam> params){
        int width = pixels[0].length;
        int height = pixels.length;

        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
              pixels[y][x] = makePixel(0, getGreen(pixels[y][x]),getBlue(pixels[y][x]));
            }
        }


        return pixels;
    }
}

class NoGreen extends ImageEffect {
    public int[][] apply(int[][] pixels,ArrayList<ImageEffectParam> params){
        int width = pixels[0].length;
        int height = pixels.length;

        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
              pixels[y][x] = makePixel(getRed(pixels[y][x]),0,getBlue(pixels[y][x]));
            }
        }


        return pixels;
    }
}

class NoBlue extends ImageEffect {
    public int[][] apply(int[][] pixels,ArrayList<ImageEffectParam> params){
        int width = pixels[0].length;
        int height = pixels.length;

        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
              pixels[y][x] = makePixel(getRed(pixels[y][x]),getGreen(pixels[y][x]),0);
            }
        }


        return pixels;
    }
}

class RedOnly extends ImageEffect {
    public int[][] apply(int[][] pixels,ArrayList<ImageEffectParam> params){
        int width = pixels[0].length;
        int height = pixels.length;

        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
              pixels[y][x] = makePixel(getRed(pixels[y][x]),0,0);
            }
        }


        return pixels;
    }
}

class GreenOnly extends ImageEffect {
    public int[][] apply(int[][] pixels,ArrayList<ImageEffectParam> params){
        int width = pixels[0].length;
        int height = pixels.length;

        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
              pixels[y][x] = makePixel(0,getGreen(pixels[y][x]),0);
            }
        }


        return pixels;
    }
}

class BlueOnly extends ImageEffect {
    public int[][] apply(int[][] pixels,ArrayList<ImageEffectParam> params){
        int width = pixels[0].length;
        int height = pixels.length;

        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
              pixels[y][x] = makePixel(0,0,getBlue(pixels[y][x]));
            }
        }


        return pixels;
    }
}

class BlackAndWhite extends ImageEffect {
    public int[][] apply(int[][] pixels,ArrayList<ImageEffectParam> params){
        int width = pixels[0].length;
        int height = pixels.length;

        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
                // local variable so I can just put red + blue + green average as a single variable
                // and it won't take too long to put in for the parameters
                int average = (getRed(pixels[y][x]) + getGreen(pixels[y][x]) + getBlue(pixels[y][x])) / 3;
              pixels[y][x] = makePixel(average,average,average);

            }
        }

        return pixels;
    }
}


class VerticalReflect extends ImageEffect {
// y relates to height; x relates to width
    public int[][] apply(int[][] pixels,ArrayList<ImageEffectParam> params){
        int width = pixels[0].length;
        int height = pixels.length;

        for (int x = 0; x < width/2; x++){
            for (int y = 0; y < height; y++){
                int temp = pixels[y][x];
                pixels[y][x] = pixels[y][width - 1 - x];
                pixels[y][width - 1 - x] = temp;
            }
        }

        return pixels;
    }
}


class HorizontalReflect extends ImageEffect {
// y relates to height; x relates to width
    public int[][] apply(int[][] pixels,ArrayList<ImageEffectParam> params){
        int width = pixels[0].length;
        int height = pixels.length;

        for (int x = 0; x < width; x++){
            for (int y = 0; y < height/2; y++){
                int temp = pixels[y][x];
                pixels[y][x] = pixels[height - 1 - y][x];
                pixels[height - 1 - y][x] = temp;
            }
        }

        return pixels;
    }
}

class Grow extends ImageEffect {
// y relates to height; x relates to width
    public int[][] apply(int[][] pixels,ArrayList<ImageEffectParam> params){
        int width = pixels[0].length;
        int height = pixels.length;

        int newArray [][] = new int[height * 2][width* 2];
        for (int x = 0; x < width*2; x++){
            for (int y = 0; y < height*2; y++){
                newArray[y][x] = pixels[y/2][x/2];
            }
        }
        return newArray;
    }
}

class Shrink extends ImageEffect {
// y relates to height; x relates to width
    public int[][] apply(int[][] pixels,ArrayList<ImageEffectParam> params){
        int width = pixels[0].length;
        int height = pixels.length;

        int newArray [][] = new int[height / 2][width / 2];
        for (int x = 0; x < width/2; x++){
            for (int y = 0; y < height/2; y++){
                
                int greenAverage = (getGreen(pixels[y*2][x*2]) + getGreen(pixels[y*2][x*2 + 1]) + getGreen(pixels[y*2 + 1][x*2]) + getGreen(pixels[y*2 + 1][x*2 + 1])) / 4;
                int blueAverage = (getBlue(pixels[y*2][x*2]) + getBlue(pixels[y*2][x*2 + 1]) + getBlue(pixels[y*2 + 1][x*2]) + getBlue(pixels[y*2 + 1][x*2 + 1])) / 4;
                int redAverage = (getRed(pixels[y*2][x*2]) + getRed(pixels[y*2][x*2 + 1]) + getRed(pixels[y*2 + 1][x*2]) + getRed(pixels[y*2 + 1][x*2 + 1])) / 4;
                
                newArray[y][x] = makePixel(redAverage, greenAverage, blueAverage);
            }
        }
        return newArray;
    }
}

class Threshold extends ImageEffect {
    public Threshold() {
    super();
    params = new ArrayList<ImageEffectParam>();
    params.add(new ImageEffectParam("Threshold", "Threshold value", 127, 0, 255));
    }

    public int[][] apply(int[][] pixels,
                         ArrayList<ImageEffectParam> params) {
        int threshold = params.get(0).getValue();
        for (int x = 0; x<pixels[0].length;x++){
            for (int y = 0; y<pixels.length;y++){
                int red = getRed(pixels[y][x]);
                int green = getGreen(pixels[y][x]);
                int blue = getBlue(pixels[y][x]);
                if (red > threshold) {
                    red = 255;
                } else {
                    red = 0;
                }
                if (green > threshold) {
                    green = 255;
                } else {
                    green = 0;
                }
                if (blue > threshold) {
                    blue = 255;
                } else {
                    blue = 0;
                }
                pixels[y][x] = makePixel(red, green, blue);
            }
        }
        return pixels;
    }


}



class Dummy extends ImageEffect {

    public Dummy() {
        super();
        params = new ArrayList<ImageEffectParam>();
        params.add(new ImageEffectParam("ParamName",
                                           "Description of param.",
                                           10, 0, 1000));
    }

    public int[][] apply(int[][] pixels,
                         ArrayList<ImageEffectParam> params) {
        // Use params here.
        return pixels;
    }
}
