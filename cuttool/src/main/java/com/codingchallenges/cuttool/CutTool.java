package com.codingchallenges.cuttool;

import com.codingchallenges.cuttool.exceptions.ColumnNotFoundException;
import com.codingchallenges.cuttool.exceptions.EmptyStandardInputException;
import com.codingchallenges.cuttool.exceptions.InvalidDelimeterException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


enum Delimeter {
    TAB("\t"),
    COMMA(",");
//    SPACE

    private final String value;

    Delimeter(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static boolean isValidDelimeter(String input) {
        for (Delimeter delimeter: values()) {
            if(delimeter.getValue().equals(input)) {
                return true;
            }
        }
        return false;
    }
}

class CutTool {
    private BufferedReader reader;
    private String fileContent = "";
    private String delimeter = "";

    CutTool(String filePath) throws IOException {
        try{
            fileContent = Util.readFileContentIntoString(filePath);
//            System.out.println(fileContent);
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }

//        System.out.print(fileContent);

        delimeter = "\t";
   }

    CutTool(String filePath, String delimeterInput) throws Exception {
        fileContent = Util.readFileContentIntoString(filePath);
        if (Delimeter.isValidDelimeter(delimeterInput)) {
            delimeter = delimeterInput;
        } else {
            throw new InvalidDelimeterException();
        };

    }

    CutTool(InputStream stdIn) throws IOException, EmptyStandardInputException {
        try {

            fileContent = Util.readBufferIntoString(stdIn);
            delimeter = "\t";
//            System.out.println(fileContent);
        } catch (IOException | EmptyStandardInputException e) {
           throw e;
        }

    }

    CutTool(InputStream stdIn, String delimeterInput) throws IOException {
        try {
            fileContent = Util.readBufferIntoString(stdIn);
            if (Delimeter.isValidDelimeter(delimeterInput)) {
                delimeter = delimeterInput;
            } else {
                throw new InvalidDelimeterException();
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (InvalidDelimeterException | EmptyStandardInputException e) {
            throw new RuntimeException(e);
        }
    }

//    public String handleTheFieldOptionForSingleColumn(int columnNumber) {
//        // assume it is a tab delimeter
//        if (columnNumber <= 0) {
//            System.out.println("Err: Only non-zero positive integers allowed");
//            return "";
//        }
//
//        String[] lines = fileContent.split("\n");
//        ArrayList<String[]> sections = new ArrayList<String[]>();
//        for (String line : lines) {
////            System.out.println(line);
//            sections.add(line.split(delimeter));
//
//        }
//        try{
//            StringBuilder columnValue = new StringBuilder();
//            for (String[] section : sections) {
//
//                columnValue.append(section[columnNumber] += "\n");
//            }
//            return String.join("\n", columnValue.toString().split("\n"));
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("Not that much columns");
//        }
//
//
//
//        return "";
//    }

    public String cut(ArrayList<Integer> columns) {
        // assume it is a tab delimeter

        try {
            ArrayList<Integer> columnIndices = new ArrayList<>();

            for (int column: columns) {
                columnIndices.add(column-1);
            }

            String[] lines = fileContent.split("\n");
            ArrayList<String[]> sections = new ArrayList<String[]>();
            for (String line : lines) {
//            System.out.println(line);
                sections.add(line.split(delimeter));

            }
            StringBuilder finalCut = new StringBuilder();
            for (String[] section : sections) {
                ArrayList<String> wordHolder = new ArrayList<>();
                for (int columnIndex: columnIndices) {
                    wordHolder.add(section[columnIndex]);

                }
                finalCut.append(String.join(delimeter, wordHolder)).append("\n");
            }
            //

            return String.join("\n", finalCut.toString().split("\n"));
        } catch (ArrayIndexOutOfBoundsException e) {
         throw new ColumnNotFoundException();
        }
    }

}