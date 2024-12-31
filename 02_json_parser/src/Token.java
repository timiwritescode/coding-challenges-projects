import java.io.*;

class Token {

}

class TestToken {
    public static void main(String[] args) throws IOException {
        String fileContent = Util.readFileContent("/home/alterego/personal_projects/coding-challenges-projects/02_json_parser/src/test.json");
        System.out.println(fileContent);
    }

    public static String buildString(BufferedReader reader) throws IOException {
        StringBuilder inputString = new StringBuilder();
        String endMarker = "pos";
        String currentLine = reader.readLine();

        while (currentLine != null) {
            inputString.append(currentLine).append("\n");

            currentLine = reader.readLine();
            if (currentLine == null) {
                // remove thrailing /n
                inputString.deleteCharAt(inputString.length()-1);
            }

        }
    System.out.println(inputString.toString());
        return inputString.toString();
    }


}