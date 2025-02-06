package test;

import main.SortTool;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class SortToolTests {

    @Test
    public void testSort() throws IOException {
        String content = "adjust\nAdjust\nADJUST";
        File tempFile = createTempFileWithContent(content);



        List<String> words = List.of("adjust", "Adjust", "ADJUST");
        words = new ArrayList<>(words);
        words.sort(String::compareTo);

        String result = SortTool
                        .sortFileContentInAscendingOrder(tempFile.getAbsolutePath());
        String expectedOutcome = String.join("\n", words);
        Assertions.assertEquals(expectedOutcome, result);


    }

    @Test
    public void testSortThrowsFileNotFoundexception() {
        Assertions.assertThrows(IOException.class,
                () -> SortTool.sortFileContentInAscendingOrder("fake_file.txt"));
    }

    private File createTempFileWithContent(String content) throws IOException {
        File tempFile = File.createTempFile("temp_file", "txt");
        tempFile.deleteOnExit();

        try(FileWriter writer = new FileWriter(tempFile)) {
            writer.write(content);

        }

        return tempFile;
    }
}