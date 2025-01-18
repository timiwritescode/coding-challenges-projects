import picocli.CommandLine;

import java.io.IOException;


@CommandLine.Command(
        name = "cc_cut",
        mixinStandardHelpOptions = true,
        description = "Linux cut command line tool")
public class Main implements Runnable {
    @CommandLine.Option(names = "-f", description = "Specify the column number to pick", required = true)
    private int column;


    @Override
    public void run() {
        if (column <= 0) {
            System.out.println("Error: -f must be a positive integer");
            System.exit(1);
        }
        System.out.println("The number is: " + column);

    }

    public static void main(String[] args) throws IOException {
//
//        String filePath = "challenge-cut/fourchords.csv";
//        CutTool tool = new CutTool(filePath, Delimeter.COMMA);
//
//        tool.handleTheFieldOption(4);
        int exitCode = new CommandLine(new Main()).execute(args);
    }

}