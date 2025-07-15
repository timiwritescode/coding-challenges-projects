package com.codingchallenges.wctool;

import java.io.*;


public class App {
    public static void main(String[] args) throws IOException {
        switch (args[0]) {
            case "--direct-input" -> {
                WcTool toolForStdin = new WcTool(System.in);


                switch (args[1]) {
                    case "--no-options" -> {

                        long wordCount = toolForStdin.getWordCountFromStdin();

                        long linesCount = toolForStdin.getLinesCountFromStdin();
                        long charCount = toolForStdin.getCharacterCountFromStdin();
                        System.out.println("Lines: " + linesCount + " Words: " + wordCount + " Characters: " + charCount);
                    }
                    case "-m" -> {
                        // characters count
                        System.out.println("Character count: " + toolForStdin.getCharacterCountFromStdin());
                    }
                    case "-w" -> {
                        // words count
                        System.out.println("Word Count:  " + toolForStdin.getWordCountFromStdin());
                    }

                    case "-l" -> {
                        // Lines count
                        System.out.println("Lines count: " + toolForStdin.getLinesCountFromStdin());
                    }

                    case "-c" -> {
                        // Bytes count
                        System.out.println("Bytes count: " + toolForStdin.getBytesCountFromStdin());
                    }
                }
            }
            case "--filepath" -> {
                String filePath = args[2];
                File file = new File(filePath);
                WcTool tool = new WcTool(filePath);
                switch (args[1]) {
                    case "--no-option" -> {
                        long lineCount = tool.getNumberOfLinesWithFilepath();
                        long characterCount = tool.getCharacterCountWithFilepath();
                        long wordCount = tool.getWordCountWithFilePath();
                        System.out.println("Lines:  " + lineCount + " Words: "+  wordCount + " Characters: " + characterCount + " file: " + file.getName());
                    }
                    case "-c" ->
                            System.out.println("Bytes: " + tool.getByteCountWithFilePath() + " " + file.getName());
                    case "-m" -> System.out.println("Characters: " + tool.getCharacterCountWithFilepath() + " " + file.getName());
                    case "-l" -> System.out.println("Lines: " + tool.getNumberOfLinesWithFilepath() + " " + file.getName());
                    case "-w" -> System.out.println("Words: " + tool.getWordCountWithFilePath() + " " + file.getName());
                }

            }
        }


    }

}