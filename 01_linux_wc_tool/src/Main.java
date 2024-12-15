import wc_tool.WcTool;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = args[1];
        File file = new File(filePath);

        switch (args[0]) {
            case "--direct-input" -> {
                String input = Main.getString();
                switch (args[1]) {
                    case "--no-options" -> {


                        long wordCount = WcTool.getWordCountFromStdin(input);

                        long linesCount = WcTool.getLinesCountFromStdin(input);
                        long charCount = WcTool.getCharacterCountFromStdin(input);
                        System.out.println("Lines: " + linesCount + " Words: " + wordCount + " Characters: " + charCount);
                    }
                    case "-m" -> {
                        // characters count
                        System.out.println("Character count: " + WcTool.getCharacterCountFromStdin(input));
                    }
                    case "-w" -> {
                        // words count
                        System.out.println("Word Count:  " + WcTool.getWordCountFromStdin(input));
                    }

                    case "-l" -> {
                        // Lines count
                        System.out.println("Lines count: " + WcTool.getLinesCountFromStdin(input));
                    }

                    case "-c" -> {
                        // Bytes count
                        System.out.println("Bytes count: " + WcTool.getBytesCountFromStdin(input));
                    }
                }
            }
            case "--no-option" -> {
                long lineCount = WcTool.getNumberOfLines(filePath);
                long characterCount = WcTool.getCharacterCount(filePath);
                long wordCount = WcTool.getWordCount(filePath);
                System.out.println("Lines:  " + lineCount + " Words: "+  wordCount + " Characters: " + characterCount + " file: " + file.getName());
            }
            case "-c" ->
                    System.out.println("Bytes: " + WcTool.getByteCount(filePath) + " " + file.getName());
            case "-m" -> System.out.println("Characters: " + WcTool.getCharacterCount(filePath) + " " + file.getName());
            case "-l" -> System.out.println("Lines: " + WcTool.getNumberOfLines(filePath) + " " + file.getName());
            case "-w" -> System.out.println("Words: " + WcTool.getWordCount(filePath) + " " + file.getName());
        }

    }

    private static String getString() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder inputBuilder = new StringBuilder();
        String currentLine = reader.readLine();
        String line;
        while (currentLine != null) {
            inputBuilder.append(currentLine).append("\n");

            currentLine = reader.readLine();
        }
        String input = inputBuilder.toString();

        // remove the last appended \n because it is not in original file
        input = input.substring(0, input.length()-1);

        return input;
    }
}