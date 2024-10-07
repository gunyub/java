//250쪽 10번
package Report;
import java.util.Scanner;

public class Report3_10 {
    public static void main(String[] args) {
        MonthlyDiary monthlyDiary = new MonthlyDiary(2024, 10); // 2024년 10월 다이어리
        monthlyDiary.runDiary();
    }
}

class DailyDiary {
    private String dailyMemo;

    public DailyDiary() {
        this.dailyMemo = "";
    }

    public void setDailyMemo(String memo) {
        this.dailyMemo = memo;
    }

    public String getDailyMemo() {
        return dailyMemo;
    }
}

class MonthlyDiary {
    private int diaryYear;
    private int diaryMonth;
    private DailyDiary[] dailyEntries;
    private Scanner inputScanner;

    public MonthlyDiary(int year, int month) {
        this.diaryYear = year;
        this.diaryMonth = month;
        this.dailyEntries = new DailyDiary[30];
        for (int i = 0; i < 30; i++) {
            dailyEntries[i] = new DailyDiary();
        }
        this.inputScanner = new Scanner(System.in);
    }

    public void runDiary() {
        System.out.println("***** " + diaryYear + "년 " + diaryMonth + "월 다이어리 *****");
        while (true) {
            int userChoice = getUserChoice();
            if (userChoice == 1) {
                enterMemo();
            } else if (userChoice == 2) {
                displayMemos();
            } else if (userChoice == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }

    private int getUserChoice() {
        System.out.print("기록:1, 보기:2, 종료:3>>");
        return inputScanner.nextInt();
    }

    private void enterMemo() {
        System.out.print("날짜(1~30)와 텍스트(빈칸없이 4글자이하)>>");
        int selectedDay = inputScanner.nextInt();
        String newMemo = inputScanner.next();
        if (selectedDay >= 1 && selectedDay <= 30 && newMemo.length() <= 4) {
            dailyEntries[selectedDay - 1].setDailyMemo(newMemo);
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }

    private void displayMemos() {
        System.out.println("***** " + diaryYear + "년 " + diaryMonth + "월 다이어리 *****");
        for (int i = 0; i < 30; i++) {
            if (!dailyEntries[i].getDailyMemo().isEmpty()) {
                System.out.println((i + 1) + "일: " + dailyEntries[i].getDailyMemo());
            }
        }
    }
}
