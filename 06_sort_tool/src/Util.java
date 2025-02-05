import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class Util {
    private Util() {}

    public static String readBufferFromFilePathIntoString(String filePath) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String currentLine = reader.readLine();

            StringBuilder stringBuilder = new StringBuilder();
            while (currentLine != null) {
                stringBuilder.append(currentLine += "\n");
                currentLine = reader.readLine();
            }


            return stringBuilder.toString();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return "";
    }
}