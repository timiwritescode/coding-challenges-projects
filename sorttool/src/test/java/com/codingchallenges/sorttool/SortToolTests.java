package com.codingchallenges.sorttool;

import com.codingchallenges.sorttool.SortTool;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


class SortToolTests {

    @Test
    public void testSort() throws IOException {
        String content = "Adjust\nADJUST\nadjust";
        File tempFile = createTempFileWithContent(content);

        String result = SortTool.sortFileContentInAscendingOrder(tempFile.getAbsolutePath());

        String expectedOutcome = "ADJUST\nAdjust\nadjust";
        Assertions.assertEquals(expectedOutcome, result);
    }

    @Test
    public void testSortThrowsFileNotFoundException() {
        Assertions.assertThrows(IOException.class, () -> SortTool.sortFileContentInAscendingOrder("fake_file.txt"));
    }

    @Test
    public void testSortWithUniqueOption() throws IOException {
        String content = "adjust\nADJUST\nAdjust\nADJUST\nAdjust\nadjust\nAdjust\nADJUST\nadjust";
        File tempFile = createTempFileWithContent(content);

        String result = SortTool.sortAndFilterUnique(tempFile.getAbsolutePath());
        String expectedOutcome = "ADJUST\nAdjust\nadjust";

        Assertions.assertEquals(expectedOutcome, result);
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