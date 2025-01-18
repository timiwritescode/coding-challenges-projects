import picocli.CommandLine;

import java.io.IOException;
import java.util.ArrayList;


@CommandLine.Command(
        name = "cc_cut",
        mixinStandardHelpOptions = true,
        description = "Linux cut command line tool")
public class Main implements Runnable {
    @CommandLine.Option(names = "-f", description = "Specify the column number to pick", required = true)
    private String fOption;

    @CommandLine.Option(names = "d", description = "Specify the delimeter to se")
    private String delimeter;

    @Override
    public void run() {
        ArrayList<Integer> options = getFOptionValues();



    }

    private ArrayList<Integer> getFOptionValues() {
        ArrayList<Integer> options = new ArrayList<Integer>();
        System.out.println(fOption);
        int sum = 0;
        try{
            if (fOption.contains(",")) {
                // split at comma
                String[] refOptions = fOption.split(",");
                for (String refOpt: refOptions) {
                    options.add(Integer.parseInt(refOpt));
                }

            } else {
                // split at space
                String[] refOptions = fOption.split(" ");
                for (String refOpt: refOptions) {
                    options.add(Integer.parseInt(refOpt));
                }
            }

            return options;
        } catch (NumberFormatException e) {
            System.out.println("Error: 0ne or more value of input is not a positive integer");
            System.exit(1);
        }
        return new ArrayList<>();
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