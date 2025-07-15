package com.codingchallenges.sorttool;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        String option = args[0];
        String filePath = args[1];
        if (option.equals("--no-option")) {
            Main.handleTheNormalOption(filePath);
        }
        if (option.equals("-u")) System.out.println(SortTool.sortAndFilterUnique(filePath));


    }

    public static void handleTheNormalOption(String filePath){
        try {
            String result = SortTool.sortFileContentInAscendingOrder(filePath);
            System.out.println(result);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            System.out.println("Code error");
            System.exit(1);
        }
    }
}