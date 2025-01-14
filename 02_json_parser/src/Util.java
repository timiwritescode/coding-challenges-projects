import java.io.*;

class Util {
    private Util() {}

    public static String readFileContent(String filePath) {
        try {
//            String filePath = "/home/alterego/personal_projects/coding-challenges-projects/02_json_parser/src/test.json";
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            StringBuilder inputString = new StringBuilder();

            String currentLine = reader.readLine();

            while (currentLine != null) {
                inputString.append(currentLine).append("\n");

                currentLine = reader.readLine();
                if (currentLine == null) {
                    // remove thrailing /n
                    inputString.deleteCharAt(inputString.length() - 1);
                }

            }
//            System.out.println(inputString.toString());
            return inputString.toString();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return filePath;
    }
}


