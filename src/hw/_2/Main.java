package hw._2;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        FileAnalysis fileAnalysis = new FileAnalysis();
        try {
            fileAnalysis.analyse(args[0]);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage() + "\nПроверьте корректность входных данных.");
        } catch (IOException ioEx) {
            System.out.println(ioEx.getMessage());
        }
    }

}
