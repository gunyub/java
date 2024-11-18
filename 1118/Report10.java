package Project08;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Report10 {
    public static void main(String[] args) {
        HashMap<String, String> phoneDirectory = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String filePath = "c:\\temp\\phon.txt";


        // 파일에서 전화번호부 읽기
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",\\s*", 2);
                if (parts.length == 2) {
                    phoneDirectory.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("파일 읽기 중 오류가 발생했습니다: " + e.getMessage());
        }

        // 사용자로부터 이름을 입력받아 전화번호를 검색
        while (true) {
            System.out.print("이름을 입력하세요 (종료하려면 '그만' 입력): ");
            String name = scanner.nextLine();

            if (name.equals("그만")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            if (phoneDirectory.containsKey(name)) {
                System.out.println(name + "의 전화번호는 " + phoneDirectory.get(name) + " 입니다.");
            } else {
                System.out.println(name + "는 목록에 없습니다.");
            }
        }

        scanner.close();
    }
}
