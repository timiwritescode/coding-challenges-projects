package main;

import java.io.FileNotFoundException;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = args[0];
        try{
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