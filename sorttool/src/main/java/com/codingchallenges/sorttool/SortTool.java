package com.codingchallenges.sorttool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortTool {
//    private final String filepath;
//    private List<String> wordList;
//    private final String fileContent;
    private SortTool() {}

//    public SortTool(String filePath) throws IOException {
//        this.filepath = filePath;
//        String fileContent = Util.readBufferFromFilePathIntoString(filePath);
//        wordList = new ArrayList<>(List.of(fileContent.split("\n")));
////        System.out.println(wordList);
//    }
//
    public static List<String> getWordListFromFileContent(String filePath) throws IOException {
        String fileContent = Util.readBufferFromFilePathIntoString(filePath);

        return new ArrayList<>(List.of(fileContent.split("\n")));
    }

    public static String sortFileContentInAscendingOrder(String filepath) throws IOException {

        List<String> wordList = SortTool.getWordListFromFileContent(filepath);
        wordList.sort(String::compareTo);
        return String.join("\n", wordList);
    }

    public static String sortAndFilterUnique(String filepath) throws IOException {
        List<String> wordList = SortTool.getWordListFromFileContent(filepath);
        Set<String> wordSet =new TreeSet<>(wordList);
        return String.join("\n", wordSet);
    }

}