package me.geuxy.util.other;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class ScannerUtil {

    /**
     * Gets all text in a website from URL (must be raw).
     *
     * @param url Raw URL to scan.
     *
     * @return contents from the given URL.
     */
    public static String scanURL(String url) {
        try {
            Scanner scanner = new Scanner(new URL(url).openStream());

            String text = "";

            while(scanner.hasNextLine()) {
                text += scanner.nextLine();
            }
            return text;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
