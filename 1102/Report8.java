//실습문제8번
package reportPackage;

import java.util.Calendar;
import java.util.Scanner;

public class Report8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 오늘 날짜 설정
            Calendar today = Calendar.getInstance();

            // 사용자로부터 생년월일 입력받기
            System.out.print("생일 입력 (년 월 일)>> ");
            String input = scanner.nextLine();

            // "그만" 입력 시 프로그램 종료
            if (input.equals("그만")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            // 입력값을 공백으로 분리하여 연, 월, 일로 구분
            String[] birthDateInput = input.split(" ");
            int year = Integer.parseInt(birthDateInput[0]);
            int month = Integer.parseInt(birthDateInput[1]) - 1; // Calendar의 MONTH는 0부터 시작
            int day = Integer.parseInt(birthDateInput[2]);

            // 생년월일 설정
            Calendar birthDate = Calendar.getInstance();
            birthDate.set(year, month, day);

            // 생년월일로부터 오늘까지의 일수를 계산
            long millisecondsLived = today.getTimeInMillis() - birthDate.getTimeInMillis();
            long daysLived = millisecondsLived / (1000 * 60 * 60 * 24) + 1; // 오늘 포함해서 1일 추가

            // 출력문을 예시와 동일하게 출력
            System.out.printf("오늘은 %d년 %d월 %d일입니다.\n", today.get(Calendar.YEAR), today.get(Calendar.MONTH) + 1, today.get(Calendar.DAY_OF_MONTH));
            System.out.printf("생일 입력(년 월 일)>> %d %d %d\n", year, month + 1, day); // 생일 입력 다시 출력
            System.out.printf("생일로부터 %d일 살았습니다.\n", daysLived);
        }

        scanner.close();
    }
}
