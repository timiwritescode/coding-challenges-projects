import picocli.CommandLine;

import java.io.IOException;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;


@CommandLine.Command(
        name = "cc_cut",
        mixinStandardHelpOptions = true,
        description = "Linux cut command line tool")
public class Main implements Runnable {
    @CommandLine.Parameters(index = "0", description = "File to cut")
    private String filePath;

    @CommandLine.Option(names = "-f", description = "Specify the column number to pick", required = true)
    private String fOption;

    @CommandLine.Option(names = "-d", description = "Specify the delimeter to se")
    private String delimeter = "";

    @Override
    public void run() {
        ArrayList<Integer> options = getFOptionValues();
        try {
            CutTool file;
            if (!delimeter.isEmpty()) {
                System.out.println(delimeter);
                file = new CutTool(filePath, delimeter);
            } else {
                file = new CutTool(filePath);
            }

            System.out.println(file.handleTheFieldOption(options.getFirst()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
//            throw new RuntimeException(e);
        }
    }

    private ArrayList<Integer> getFOptionValues() {
        ArrayList<Integer> options = new ArrayList<Integer>();
        try{
            if (fOption.contains(",")) {
                // split at comma
                String[] refOptions = fOption.split(",");
                for (String refOpt: refOptions) {
                    if (isValuePresent(options, formatNumber(refOpt))) {
                        continue;
                    }
                    options.add(formatNumber(refOpt));
                }

            } else {
                // split at space
                String[] refOptions = fOption.split(" ");
                for (String refOpt: refOptions) {
                    if (isValuePresent(options, formatNumber(refOpt))) {
                        continue;
                    }
                    options.add(formatNumber(refOpt));
                }
            }

            return options;
        } catch (NumberFormatException e) {

            System.out.println("Error: 0ne or more value of input in -f is not a positive, non-zero integer");
            System.exit(1);
        }
        return new ArrayList<>();
    }

    private int formatNumber(String input) {
        int number = Integer.parseInt(input);
        if (number <= 0 ) {
            throw new NumberFormatException("one or more input less than or equal to zero");
        }

        return number;
    }

    private boolean isValuePresent(ArrayList<Integer> list, int value) {
        return list.contains(value);
    }

    public static void main(String[] args) throws IOException {
//
//        String filePath = "challenge-cut/fourchords.csv";
//        CutTool tool = new CutTool(filePath, Delimeter.COMMA);
//
//        tool.handleTheFieldOption(4);
        int exitCode = new CommandLine(new Main()).execute(args);
        System.exit(exitCode);
    }

}