package Project08;

import java.io.*;
import java.util.Scanner;

public class Report1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("이름과 전화번호를 입력하세요 (예: 홍길동, 010-5555-7777). 종료하려면 '그만' 입력: ");
            String input = scanner.nextLine();

            if (input.equals("그만")) {
                System.out.println("프로그램을 종료합니다.");
                scanner.close();
                break;
            }

            saveToFile(input);
        }
    }

    private static void saveToFile(String contactInfo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("phone.txt", true))) {
            writer.write(contactInfo);
            writer.newLine();
            System.out.println("입력된 정보가 phone.txt 파일에 저장되었습니다.");
        } catch (IOException e) {
            System.out.println("파일 저장 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}
