package wc_tool;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class WcTool {

    public static long getByteCount(String filePath) {
        File file = new File(filePath);
        return file.length();
    }

//    public static int getCharacterCount(String filePath) throws IOException {
////        File file = new File(filePath);
//        byte[] bytes = Files.readAllBytes(Path.of(filePath));
//
//        return bytes.length;
//    }

//    public long getWordCount() {
//
//    }

    public static long getWordCount(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String current_line = reader.readLine();

        long worcCount = 0;
        while (current_line != null) {
            String[] words = current_line.split(" ");
            worcCount += words.length;

            current_line = reader.readLine();
        }


        return worcCount;
    }

    public static long getNumberOfLines(String filePath) throws IOException {
        byte[] bytes = Files.readAllBytes(Path.of(filePath));
        long lineCount = 0;
        for (byte _byte : bytes ) {
            if (_byte == '\n') {
                lineCount++;
            }
        }

        return lineCount;
    }
    public static int getCharacterCount(String filePath) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String current_line = reader.readLine();

        int charCount = 0;
        while (current_line != null) {
            if (current_line.isEmpty()) {
                charCount += 1;
            }
            charCount += current_line.length();



            current_line = reader.readLine();
        }
        return charCount;
    }


    public static long getDirectInputCharacterCount(String directInput) {
//        Charset charset = StandardCharsets.UTF_8;
//        ByteBuffer byteBuffer = charset.encode(directInput);
//
        final byte[] utfBytes = directInput.getBytes(StandardCharsets.UTF_8);
        return  utfBytes.length;
    }
}
