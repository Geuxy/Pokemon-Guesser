package me.geuxy.util.type;

public class IntegerUtil {

    /*
     * Converts a string to an integer with a try-catch to prevent crashing.
     */
    public static int toInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch(Exception ignored) {
        }

        return 0;
    }

}
