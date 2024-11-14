package reportPackage;
import java.util.Calendar;
import java.util.Scanner;

public class Report7 {
    public static void main(String[] args) {
        // Scanner 객체 생성하여 사용자 입력 받기
        Scanner scanner = new Scanner(System.in);
        int year;

        // 무한 반복을 통해 연도를 반복적으로 입력 받음
        while (true) {
            System.out.print("년도 입력(-10 입력 시 종료) >> ");
            year = scanner.nextInt(); // 사용자가 연도 입력

            // 입력이 -1인 경우 프로그램 종료
            if (year == -1) {
                System.out.println("프로그램을 종료합니다.");
                break; // while 루프를 종료하여 프로그램이 종료됨
            }

            // 입력된 연도의 달력 출력
            printYearCalendar(year);
        }

        scanner.close(); // Scanner 객체 닫기
    }

    /**
     * 특정 연도의 달력을 출력하는 메서드
     * @param year - 출력할 연도
     */
    private static void printYearCalendar(int year) {
        // 1월부터 12월까지 반복하여 각 월의 달력을 출력
        for (int month = 0; month < 12; month++) {
            printMonthCalendar(year, month); // 월별 달력 출력
            System.out.println(); // 각 달력 사이에 빈 줄 추가
        }
    }

    /**
     * 특정 연도의 특정 월의 달력을 출력하는 메서드
     * @param year - 출력할 연도
     * @param month - 출력할 월 (0: 1월, 1: 2월, ..., 11: 12월)
     */
    private static void printMonthCalendar(int year, int month) {
        // Calendar 객체 생성 및 설정
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year); // 연도 설정
        calendar.set(Calendar.MONTH, month); // 월 설정 (0부터 시작)
        calendar.set(Calendar.DAY_OF_MONTH, 1); // 일 설정 (해당 월의 첫째 날)

        // 해당 월의 첫 번째 날의 요일을 가져옴 (1: 일요일, 2: 월요일, ..., 7: 토요일)
        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        // 해당 월의 마지막 날짜 (예: 2월은 28일 또는 29일)
        int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // 헤더 부분 출력 (예: "2025년 1월")
        System.out.printf("%d년 %d월\n", year, month + 1);
        System.out.println("일 월 화 수 목 금 토"); // 요일 헤더 출력

        // 첫 주의 공백 처리
        // 첫 번째 날의 요일 값 이전에는 공백으로 채움
        for (int i = 1; i < firstDayOfWeek; i++) {
            System.out.print("   "); // 세 칸의 공백을 추가하여 요일 맞춤
        }

        // 날짜 출력
        for (int day = 1; day <= lastDay; day++) {
            System.out.printf("%2d ", day); // 날짜를 두 자리로 출력 (예: " 1 ", "10")

            // 토요일마다 줄바꿈 처리하여 다음 줄로 이동
            if ((firstDayOfWeek + day - 1) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println(); // 해당 월의 달력 출력 후 한 줄 띄움
    }
}

