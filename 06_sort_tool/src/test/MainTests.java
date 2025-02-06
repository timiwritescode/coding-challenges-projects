package test;

import main.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class MainTests {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach()
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testHandleNormalOption_ValidFile() throws IOException {
        String fileContent = "judge\nGEORGE\nJUDGE";
        File tempFile = createTempFileWithContent(fileContent);
        String mockFilePath = tempFile.getAbsolutePath();

        Main.handleTheNormalOption(mockFilePath);

        String output = outputStreamCaptor.toString().trim();
        String expectedOutput = "GEORGE\nJUDGE\njudge";

        Assertions.assertEquals(expectedOutput, output);

    }

    @Test
    void testHandleNormalOption_FileNotFound() {
        Assertions.assertThrows(IOException.class, () -> Main.handleTheNormalOption("non-existenst.txt"));
    }

    private File createTempFileWithContent(String content) throws IOException {
        File tempFile = File.createTempFile("temp_file", "txt");
        tempFile.deleteOnExit();

        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write(content);

        }

        return tempFile;
    }
}