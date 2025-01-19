import exceptions.EmptyStandardInputException;

import java.io.*;

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

    public static String readBufferIntoString(InputStream stdIn) throws IOException, EmptyStandardInputException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stdIn));

        String currentLine = reader.readLine();

        StringBuilder outputString = new StringBuilder();
        while(currentLine != null) {
            outputString.append(currentLine);
            outputString.append("\n");
            currentLine = reader.readLine();
        }

        String returnValue = String.join("\n", outputString.toString().split("\n")); // so as to remove the trailing line break
        if (returnValue.isEmpty()) {
            throw new EmptyStandardInputException();
        }
        return returnValue;
    }
}