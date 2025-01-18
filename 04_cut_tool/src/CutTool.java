import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

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

    public String handleTheFieldOption(int columnNumber) {
        // assume it is a tab delimeter
        if (columnNumber <= 0) {
            System.out.println("Err: Only non-zero positive integers allowed");
            return "";
        }

        String[] lines = fileContent.split("\n");
        ArrayList<String[]> sections = new ArrayList<String[]>();
        for (String line : lines) {
//            System.out.println(line);
            sections.add(line.split(delimeter));

        }
        try{
            StringBuilder columnValue = new StringBuilder();
            for (String[] section : sections) {
//                System.out.println(section.length);
//                return section[columnNumber];

                columnValue.append(section[columnNumber] += "\n");
            }
            return String.join("\n", columnValue.toString().split("\n"));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Not that much columns");
        }



        return "";
    }

}