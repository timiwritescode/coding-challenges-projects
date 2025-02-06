package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Util {
    private Util() {}

    public static String readBufferFromFilePathIntoString(String filePath) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String currentLine = reader.readLine();


            while (currentLine != null) {
                stringBuilder.append(currentLine);
                stringBuilder.append("\n");
                currentLine = reader.readLine();
            }

        }
        if (!stringBuilder.isEmpty()) {
            stringBuilder.setLength(stringBuilder.length() - 1);
        }

        return stringBuilder.toString();
    }

    public static int checkNumber(int one, int two) {
        if (one > two) return 1;
        return -1;
    }
}