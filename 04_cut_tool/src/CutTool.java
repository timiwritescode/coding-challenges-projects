import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

enum Delimeter {
    TAB,
    COMMA,
    SPACE
}

class CutTool {
    BufferedReader reader;
    String fileContent = "";
    String delimeter = "";

    CutTool(String filePath) throws IOException {
        try{
            fileContent = Util.readFileContentIntoString(filePath);
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }

//        System.out.print(fileContent);

        delimeter = "\t";
    }

    CutTool(String filePath, Delimeter delimeterInput) throws IOException {
        fileContent = Util.readFileContentIntoString(filePath);
        if (delimeterInput.equals(Delimeter.COMMA)) {
            delimeter = ",";
        } else if (delimeterInput.equals(Delimeter.TAB)) {
            delimeter = "\t";
        } else if (delimeterInput.equals(Delimeter.SPACE)) {
            delimeter = " ";
        }
    }

    public void handleTheFieldOption(int columnNumber) {
        // assume it is a tab delimeter
        if (columnNumber <= 0) {
            System.out.println("Err: Only non-zero positive integers allowed");
            return;
        }

        String[] lines = fileContent.split("\n");
        ArrayList<String[]> sections = new ArrayList<String[]>();
        for (String line : lines) {
            sections.add(line.split(delimeter));

        }
        try{
            for (String[] section : sections) {
                System.out.println(section[columnNumber]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Not that much columns");
        }




    }

}