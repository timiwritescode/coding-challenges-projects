import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class Util {
    public static String readFileContentIntoString(String filepath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String currentLine = reader.readLine();
        StringBuilder stringBuilder = new StringBuilder();
        while (currentLine != null) {
            stringBuilder.append(currentLine).append("\n");
            currentLine = reader.readLine();
        }

        String content = stringBuilder.toString();
        // remove the last appended \n character
//        System.out.println(content.substring(0, content.length()-1));
        return content.substring(0, content.length()-1);
//
    }
}