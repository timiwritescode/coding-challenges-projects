package wc_tool;

import java.io.*;
import java.lang.instrument.Instrumentation;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WcTool {

    public static long getByteCount(String filePath) {
        File file = new File(filePath);
        return file.length();
    }


    public static long getWordCount(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String current_line = reader.readLine();

        long worcCount = 0;
        while (current_line != null) {
            String[] words = current_line.split(" ");
            worcCount += words.length;

            current_line = reader.readLine();
        }


        return worcCount;
    }

    public static long getNumberOfLines(String filePath) throws IOException {
        byte[] bytes = Files.readAllBytes(Path.of(filePath));
        long lineCount = 0;
        for (byte _byte : bytes ) {
            if (_byte == '\n') {
                lineCount++;
            }
        }

        return lineCount;
    }
    public static int getCharacterCount(String filePath) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String current_line = reader.readLine();

        int charCount = 0;
        while (current_line != null) {
            if (current_line.isEmpty()) {
                charCount += 1;
            }
            charCount += current_line.length();



            current_line = reader.readLine();
        }
        return charCount;
    }


    public static long getBytesCountFromStdin(String input) throws UnsupportedEncodingException {
        return input.getBytes(StandardCharsets.UTF_8).length + WcTool.getLinesCountFromStdin(input); // + /n characters
    }

    public  static long getWordCountFromStdin(String input) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new StringReader(input));
        String currentLine = reader.readLine();
        long wordCount = 0;
        while(currentLine != null) {
            if (!currentLine.isEmpty()) {
                String[] words = currentLine.split("\\s+");
                ArrayList<String> wordsWithoutSpace = new ArrayList<String>(Arrays.asList(words));

                wordsWithoutSpace.removeAll(Collections.singleton(""));

                wordCount += wordsWithoutSpace.size();
            }


            currentLine= reader.readLine();
        }

        return wordCount;
    }

    public static long getCharacterCountFromStdin(String input) throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader(input));
        String current_line = reader.readLine();
//        char[] strArray = current_line.toCharArray();
//        System.out.println(strArray);
        int charCount = 0;
        while (current_line != null) {
            if (current_line.isEmpty()) {
                charCount += 1;
            } else {
                charCount += current_line.length() + 1; // add a factor of 1 to also count \n
            }


            current_line = reader.readLine();

        }
//        // also remove 1 to the last line's \n that i added
//        charCount -= 1;
        return charCount;
    }

    public static long getLinesCountFromStdin(String input) {
        char[] charArray = input.toCharArray();
        long lines = 0;
        for (char character : charArray) {
            if (character == '\n') {
                lines++;
            }
        }
        return lines;
    }

}


