import wc_tool.WcTool;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = args[1];
        File file = new File(filePath);
        switch (args[0]) {
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