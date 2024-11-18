package Project08;

import java.io.*;
import java.util.Scanner;

public class Report4 {
    public static void main(String[] args) {
        try (Scanner fileScanner = new Scanner(new FileReader("c:\\windows\\system.ini"))) {
            int lineNumber = 1;
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                System.out.printf("%d: %s%n", lineNumber, line);
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다: " + e.getMessage());
        }
    }
}
