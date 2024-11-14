//실습 10번
package reportPackage;

import java.util.Random;
import java.util.Scanner;

public class Report10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // 단어 목록 정의
        String[] words = { "happy", "morning", "package", "together", "present", "extract", "connect", "nation" };

        while (true) {
            // 랜덤한 단어 선택
            String word = words[random.nextInt(words.length)];

            // 단어 출력
            System.out.println("10초 안에 단어를 맞추세요!!");
            System.out.println(word);

            // 시작 시간 기록
            long startTime = System.currentTimeMillis();

            // 사용자 입력 받기
            System.out.print("입력>> ");
            String userInput = scanner.nextLine();

            // 종료 조건
            if (userInput.equals("그만")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            // 끝난 시간 기록
            long endTime = System.currentTimeMillis();

            // 경과 시간 계산 (초 단위로 변환)
            double elapsedTime = (endTime - startTime) / 1000.0;

            // 결과 판단 및 출력
            if (userInput.equals(word)) {
                if (elapsedTime <= 10) {
                    System.out.printf("성공!!! %.3f초 경과\n", elapsedTime);
                } else {
                    System.out.printf("실패!!! %.3f초 경과\n", elapsedTime);
                }
            } else {
                System.out.printf("틀렸습니다. %.3f초 경과\n", elapsedTime);
            }
        }

        scanner.close();
    }
}
