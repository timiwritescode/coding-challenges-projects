import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class SortTool {
    private final String filepath;
    private List<String> wordList;
//    private final String fileContent;


    SortTool(String filePath) throws IOException {
        this.filepath = filePath;
        String fileContent = Util.readBufferFromFilePathIntoString(filePath);
        wordList = new ArrayList<>(List.of(fileContent.split("\n")));
//        System.out.println(wordList);
    }

    public void sort() {

        wordList.sort((one, two) -> one.compareTo(two));
//        System.out.println(wordList.subList(0,100));
        System.out.println(String.join("\n", wordList.subList(0,100)));
    }




}