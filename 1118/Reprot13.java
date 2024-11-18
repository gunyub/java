package Project08;

import java.io.File;
import java.util.Scanner;

public class Reprot13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File currentDirectory = new File("c:\\");

        while (true) {
            System.out.println("\n현재 디렉터리: " + currentDirectory.getAbsolutePath());
            File[] files = currentDirectory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        System.out.println("dir  " + file.getName());
                    } else {
                        System.out.println("file " + file.getName());
                    }
                }
            }

            System.out.print("\n이동할 디렉터리 이름을 입력하세요 (부모 디렉터리로 이동은 '..', 종료는 '그만' 입력): ");
            String input = scanner.nextLine();

            if (input.equals("그만")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (input.equals("..")) {
                currentDirectory = currentDirectory.getParentFile();
                if (currentDirectory == null) {
                    currentDirectory = new File("c:\\");
                }
            } else {
                File newDirectory = new File(currentDirectory, input);
                if (newDirectory.exists() && newDirectory.isDirectory()) {
                    currentDirectory = newDirectory;
                } else {
                    System.out.println("잘못된 디렉터리 이름입니다. 다시 시도하세요.");
                }
            }
        }

        scanner.close();
    }
}