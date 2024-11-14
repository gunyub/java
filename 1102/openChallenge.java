package reportPackage;

import java.util.Scanner;

public class openChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] alphabetCount = new int[26]; // 알파벳 빈도 저장 배열

        System.out.println("영문 텍스트를 입력하고 세미콜론(;)만 있는 줄에서 입력을 마칩니다.");

        while (true) {
            String line = scanner.nextLine(); // 한 줄 입력받기
            if (line.equals(";")) { // 세미콜론만 있는 줄에서 종료
                break;
            }

            // 입력받은 줄을 소문자로 변환하고, 알파벳 문자만 검사하여 빈도 계산
            line = line.toLowerCase();
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if (ch >= 'a' && ch <= 'z') { // 알파벳인 경우만 카운트 증가
                    alphabetCount[ch - 'a']++;
                }
            }
        }

        scanner.close();

        // 히스토그램 출력
        System.out.println("히스토그램을 출력합니다.");
        for (int i = 0; i < alphabetCount.length; i++) {
            char ch = (char) (i + 'A'); // 대문자로 출력
            System.out.print(ch + ": ");
            for (int j = 0; j < alphabetCount[i]; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
}
