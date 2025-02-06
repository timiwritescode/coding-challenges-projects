package test;

import main.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UtilTests {

    @Test
    public void testReadBufferFromFilePathIntoString() throws IOException {
        // temporary file
        File tempFile = File.createTempFile("mock", ",txt");
        tempFile.deleteOnExit();

        try(FileWriter writer = new FileWriter(tempFile)) {
            writer.write("Some and all of us\nare not friends");
        }
        String result = Util.readBufferFromFilePathIntoString(tempFile.getAbsolutePath());
        String expectedResult = "Some and all of us\nare not friends";

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testFileNotFound() {
        Assertions.assertThrows(IOException.class, () -> {
            Util.readBufferFromFilePathIntoString("fake_file.txt");
        });
    }
}