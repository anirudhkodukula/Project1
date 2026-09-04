package assignment;

import org.junit.jupiter.api.Test;

import static assignment.ImageEffect.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

public class TransformationsTest {


    final int WHITE = makePixel(255, 255, 255);
    final int BLACK = makePixel(0, 0, 0);
    final int RED = makePixel(255, 0, 0);
    final int GREEN = makePixel(0, 255, 0);
    final int BLUE = makePixel(0, 0, 255);
    final int GREY = makePixel(85, 85, 85);

    @Test
    public void testInvert() {
        final int WHITE = makePixel(255, 255, 255);
        final int BLACK = makePixel(0, 0, 0);

        int[][] pixels = {
                { WHITE, BLACK, WHITE },
                { BLACK, WHITE, BLACK },
                { WHITE, BLACK, WHITE }
        };

        int[][] expected = {
                { BLACK, WHITE, BLACK },
                { WHITE, BLACK, WHITE },
                { BLACK, WHITE, BLACK }
        };

        ImageEffect invertEffect = new Invert();

        int[][] actual = invertEffect.apply(pixels, new ArrayList<>());

        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                assertEquals(getRed(expected[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expected[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expected[i][j]), getBlue(actual[i][j]));
            }
        }

    }
    @Test
    public void testNoRed() {
        int[][] pixels = {
                { RED, GREEN },
                { BLUE, BLACK }
        };
 
        int[][] expected = {
                { BLACK, GREEN },
                { BLUE, BLACK }
        };
 
        ImageEffect noRedEffect = new NoRed();
 
        int[][] actual = noRedEffect.apply(pixels, new ArrayList<>());
 
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i].length, actual[i].length);
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(getRed(expected[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expected[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expected[i][j]), getBlue(actual[i][j]));
            }
        }
    }
    @Test
    public void testNoGreen() {
        int[][] pixels = {
                { RED, GREEN },
                { BLUE, BLACK }
        };
 
        int[][] expected = {
                { RED, BLACK },
                { BLUE, BLACK }
        };
 
        ImageEffect noGreenEffect = new NoGreen();
 
        int[][] actual = noGreenEffect.apply(pixels, new ArrayList<>());
 
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i].length, actual[i].length);
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(getRed(expected[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expected[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expected[i][j]), getBlue(actual[i][j]));
            }
        }
    }
 
    @Test
    public void testNoBlue() {
        int[][] pixels = {
                { RED, GREEN },
                { BLUE, BLACK }
        };
 
        int[][] expected = {
                { RED, GREEN },
                { BLACK, BLACK }
        };
 
        ImageEffect noBlueEffect = new NoBlue();
 
        int[][] actual = noBlueEffect.apply(pixels, new ArrayList<>());
 
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i].length, actual[i].length);
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(getRed(expected[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expected[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expected[i][j]), getBlue(actual[i][j]));
            }
        }
    }
     @Test
    public void testRedOnly() {
        int[][] pixels = {
                { WHITE, GREEN },
                { BLUE, RED }
        };
 
        int[][] expected = {
                { RED, BLACK },
                { BLACK, RED }
        };
 
        ImageEffect redOnlyEffect = new RedOnly();
 
        int[][] actual = redOnlyEffect.apply(pixels, new ArrayList<>());
 
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i].length, actual[i].length);
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(getRed(expected[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expected[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expected[i][j]), getBlue(actual[i][j]));
            }
        }
    }
 
    @Test
    public void testGreenOnly() {
        int[][] pixels = {
                { WHITE, RED },
                { BLUE, GREEN }
        };
 
        int[][] expected = {
                { GREEN, BLACK },
                { BLACK, GREEN }
        };
 
        ImageEffect greenOnlyEffect = new GreenOnly();
 
        int[][] actual = greenOnlyEffect.apply(pixels, new ArrayList<>());
 
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i].length, actual[i].length);
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(getRed(expected[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expected[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expected[i][j]), getBlue(actual[i][j]));
            }
        }
    }
 
    @Test
    public void testBlueOnly() {
        int[][] pixels = {
                { WHITE, RED },
                { GREEN, BLUE }
        };
 
        int[][] expected = {
                { BLUE, BLACK },
                { BLACK, BLUE }
        };
 
        ImageEffect blueOnlyEffect = new BlueOnly();
 
        int[][] actual = blueOnlyEffect.apply(pixels, new ArrayList<>());
 
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i].length, actual[i].length);
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(getRed(expected[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expected[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expected[i][j]), getBlue(actual[i][j]));
            }
        }
    }
 
    @Test
    public void testBlackAndWhite() {
        int[][] pixels = {
                { WHITE, BLACK, RED },
                { GREEN, BLUE, WHITE }
        };
 
        int[][] expected = {
                { WHITE, BLACK, GREY },
                { GREY, GREY, WHITE }
        };
 
        ImageEffect blackAndWhiteEffect = new BlackAndWhite();
 
        int[][] actual = blackAndWhiteEffect.apply(pixels, new ArrayList<>());
 
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i].length, actual[i].length);
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(getRed(expected[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expected[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expected[i][j]), getBlue(actual[i][j]));
            }
        }
    }
 
    @Test
    public void testVerticalReflect() {
        int[][] pixels = {
                { RED, GREEN, BLUE },
                { WHITE, BLACK, RED }
        };
 
        int[][] expected = {
                { BLUE, GREEN, RED },
                { RED, BLACK, WHITE }
        };
 
        ImageEffect verticalReflectEffect = new VerticalReflect();
 
        int[][] actual = verticalReflectEffect.apply(pixels, new ArrayList<>());
 
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i].length, actual[i].length);
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(getRed(expected[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expected[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expected[i][j]), getBlue(actual[i][j]));
            }
        }
    }
 
    @Test
    public void testHorizontalReflect() {
        int[][] pixels = {
                { RED, GREEN },
                { BLUE, WHITE },
                { BLACK, RED }
        };
 
        int[][] expected = {
                { BLACK, RED },
                { BLUE, WHITE },
                { RED, GREEN }
        };
 
        ImageEffect horizontalReflectEffect = new HorizontalReflect();
 
        int[][] actual = horizontalReflectEffect.apply(pixels, new ArrayList<>());
 
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i].length, actual[i].length);
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(getRed(expected[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expected[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expected[i][j]), getBlue(actual[i][j]));
            }
        }
    }
 
    @Test
    public void testGrow() {
        int[][] pixels = {
                { RED, GREEN },
                { BLUE, WHITE }
        };
 
        int[][] expected = {
                { RED, RED, GREEN, GREEN },
                { RED, RED, GREEN, GREEN },
                { BLUE, BLUE, WHITE, WHITE },
                { BLUE, BLUE, WHITE, WHITE }
        };
 
        ImageEffect growEffect = new Grow();
 
        int[][] actual = growEffect.apply(pixels, new ArrayList<>());
 
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i].length, actual[i].length);
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(getRed(expected[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expected[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expected[i][j]), getBlue(actual[i][j]));
            }
        }
    }
 
    @Test
    public void testShrink() {
        int[][] pixels = {
                { WHITE, WHITE, BLACK, BLACK },
                { WHITE, WHITE, BLACK, BLACK },
                { RED, RED, GREEN, GREEN },
                { RED, RED, GREEN, GREEN }
        };
 
        int[][] expected = {
                { WHITE, BLACK },
                { RED, GREEN }
        };
 
        ImageEffect shrinkEffect = new Shrink();
 
        int[][] actual = shrinkEffect.apply(pixels, new ArrayList<>());
 
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i].length, actual[i].length);
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(getRed(expected[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expected[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expected[i][j]), getBlue(actual[i][j]));
            }
        }
    }
 
    @Test
    public void testThreshold() {
        int[][] pixels = {
                { WHITE, BLACK, RED },
                { GREEN, BLUE, WHITE }
        };
 
        int[][] expected = {
                { WHITE, BLACK, RED },
                { GREEN, BLUE, WHITE }
        };
 
        ArrayList<ImageEffectParam> params = new ArrayList<ImageEffectParam>();
        params.add(new ImageEffectParam("Threshold", "Threshold value", 127, 0, 255));
 
        ImageEffect thresholdEffect = new Threshold();
 
        int[][] actual = thresholdEffect.apply(pixels, params);
 
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i].length, actual[i].length);
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(getRed(expected[i][j]), getRed(actual[i][j]));
                assertEquals(getGreen(expected[i][j]), getGreen(actual[i][j]));
                assertEquals(getBlue(expected[i][j]), getBlue(actual[i][j]));
            }
        }
    }  

    @Test
    public void testJaggedArray() {
        ImageEffect[] effects = new ImageEffect[] {
                new Invert(),
                new NoRed(),
                new NoGreen(),
                new NoBlue(),
                new RedOnly(),
                new GreenOnly(),
                new BlueOnly(),
                new BlackAndWhite(),
                new VerticalReflect(),
                new HorizontalReflect(),
                new Grow(),
                new Shrink(),
                new Threshold()
        };


        String[] expected = new String[effects.length];
        String[] actual = new String[effects.length];

        for (int i = 0; i < effects.length; i++) {
            int[][] pixels = {
                    { RED, GREEN, BLUE },
                    { WHITE },
                    { GREEN, BLACK }
            };

            String name = effects[i].getClass().getSimpleName();
            expected[i] = name + " rejected the jagged array";

            try {
                ArrayList<ImageEffectParam> params = new ArrayList<ImageEffectParam>();
                params.add(new ImageEffectParam("Threshold", "Threshold value", 127, 0, 255));
                effects[i].apply(pixels, params);
                actual[i] = name + " jagged array passed ";
            } catch (ArrayIndexOutOfBoundsException e) {
                actual[i] = name + " jagged array failed";
            }
        }

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testOddWidthAndHeight() {
        ImageEffect[] effects = new ImageEffect[] {
                new Invert(),
                new NoRed(),
                new NoGreen(),
                new NoBlue(),
                new RedOnly(),
                new GreenOnly(),
                new BlueOnly(),
                new BlackAndWhite(),
                new VerticalReflect(),
                new HorizontalReflect(),
                new Grow(),
                new Shrink(),
                new Threshold()
        };

        String[] expected = new String[effects.length];
        String[] actual = new String[effects.length];

        for (int i = 0; i < effects.length; i++) {
            int[][] pixels = {
                    { RED, GREEN, BLUE, WHITE, BLACK },
                    { GREEN, BLUE, WHITE, BLACK, RED },
                    { BLUE, WHITE, BLACK, RED, GREEN }
            };

            String name = effects[i].getClass().getSimpleName();
            expected[i] = name + " odd width/height passed";

            try {
                ArrayList<ImageEffectParam> params = new ArrayList<ImageEffectParam>();
                params.add(new ImageEffectParam("Threshold", "Threshold value", 127, 0, 255));
                effects[i].apply(pixels, params);
                actual[i] = name + " odd width/height passed";
            } catch (Exception e) {
                actual[i] = name + " odd width/height failed";
            }
        }

        assertArrayEquals(expected, actual);
    }
}
