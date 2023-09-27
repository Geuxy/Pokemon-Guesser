package me.geuxy.util;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

import java.net.URL;

import java.nio.file.Files;

public class FileUtils {

    public static void downloadImage(URL url, File file) throws Exception {
        InputStream input;
        OutputStream output;

        input = url.openStream();
        output = Files.newOutputStream(file.toPath());

        int charr;
        while((charr = input.read()) != -1) {
            output.write(charr);
        }

        input.close();
        output.close();
    }

}
