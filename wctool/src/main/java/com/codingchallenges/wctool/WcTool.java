package com.codingchallenges.wctool;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WcTool {
    private final BufferedReader reader;
    private String filePath = "";
    private String input = "";
    public WcTool(String inputFilepath) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(inputFilepath));
        filePath = inputFilepath;
    }

    public WcTool(InputStream stdin) throws IOException {
        reader = new BufferedReader(new InputStreamReader(stdin));
        StringBuilder inputBuilder = new StringBuilder();
        String currentLine = reader.readLine();
        String line;
        while (currentLine != null) {
            inputBuilder.append(currentLine).append("\n");

            currentLine = reader.readLine();
        }
        String fileContent = inputBuilder.toString();

        // remove the last appended \n because it is not in original file
        input = fileContent.substring(0, fileContent.length()-1);


    }

    public long getByteCountWithFilePath() {
        File file = new File(filePath);
        return file.length();
    }


    public long getWordCountWithFilePath() throws IOException {
        String current_line = reader.readLine();

        long worcCount = 0;
        while (current_line != null) {
            String[] words = current_line.split(" ");
            worcCount += words.length;

            current_line = reader.readLine();
        }


        return worcCount;
    }

    public long getNumberOfLinesWithFilepath() throws IOException {
        byte[] bytes = Files.readAllBytes(Path.of(filePath));
        long lineCount = 0;
        for (byte _byte : bytes ) {
            if (_byte == '\n') {
                lineCount++;
            }
        }

        return lineCount;
    }
    public long getCharacterCountWithFilepath() throws IOException {

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


    public long getBytesCountFromStdin() throws UnsupportedEncodingException {
        return input.getBytes(StandardCharsets.UTF_8).length + getLinesCountFromStdin(); // + /n characters
    }

    public long getWordCountFromStdin() throws IOException {
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

    public long getCharacterCountFromStdin() throws IOException {
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

    public long getLinesCountFromStdin() {
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


