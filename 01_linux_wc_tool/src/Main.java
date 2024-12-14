import wc_tool.WcTool;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = args[1];
        File file = new File(filePath);

        switch (args[0]) {
            case "--direct-input" -> {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String currentLine = reader.readLine();

                long wordCount = 0;
                while(currentLine != null) {
                    String[] words = currentLine.split(" ");
                    wordCount += words.length;

                    currentLine= reader.readLine();
                }
               System.out.println("Word count: " + wordCount);
            }
            case "--no-option" -> {
                long lineCount = WcTool.getNumberOfLines(filePath);
                long characterCount = WcTool.getCharacterCount(filePath);
                long wordCount = WcTool.getWordCount(filePath);
                System.out.println(" " + lineCount + " "+  wordCount + " " + characterCount + " " + file.getName());
            }
            case "-c" ->
                    System.out.println(WcTool.getByteCount(filePath) + " " + file.getName());
            case "-m" -> System.out.println(WcTool.getCharacterCount(filePath) + " " + file.getName());
            case "-l" -> System.out.println(WcTool.getNumberOfLines(filePath) + " " + file.getName());
            case "-w" -> System.out.println(WcTool.getWordCount(filePath) + " " + file.getName());
        }

    }
}