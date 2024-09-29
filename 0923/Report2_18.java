package Report;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Report2_18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;  // 입력받은 점수를 저장할 변수

        while (true) {
            try {
                System.out.print("점수를 입력하세요: ");
                score = scanner.nextInt();  // 사용자로부터 정수를 입력받음
                break;  // 예외가 발생하지 않으면 반복문을 빠져나감
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 정수를 입력해주세요.");
                scanner.nextLine();  // 잘못된 입력을 지우고 다음 입력을 받기 위해 scanner 초기화
            }
        }

        System.out.println("입력한 점수: " + score);
        scanner.close();
    }
}
