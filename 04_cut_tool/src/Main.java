import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        String filePath = "/home/alterego/Downloads/challenge-cut/fourchords.csv";
        CutTool tool = new CutTool(filePath, Delimeter.COMMA);

        tool.handleTheFieldOption(4);
    }
}