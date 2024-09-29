package Report;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Report2_21{
    public static void main(String[] args) {
        int[] studentIDs = new int[10];  // 학번을 저장할 배열
        int[] scores = new int[10];  // 점수를 저장할 배열
        Scanner scanner = new Scanner(System.in);
        
        for (int i = 0; i < 10; i++) {
            try {
                System.out.print("학생의 학번과 점수를 입력하세요>> ");
                studentIDs[i] = scanner.nextInt();  // 학번 입력
                scores[i] = scanner.nextInt();  // 점수 입력
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 학번과 점수는 정수로 입력해주세요.");
                scanner.nextLine();  // 버퍼 초기화
                i--;  // 잘못된 입력 시 반복문 인덱스 유지
                continue;
            }
        }
        
        while (true) {
            try {
                System.out.print("학번으로 검색: ");
                int searchID = scanner.nextInt();
                
                boolean found = false;
                for (int i = 0; i < 10; i++) {
                    if (studentIDs[i] == searchID) {
                        System.out.println("학생의 점수는 " + scores[i] + "점 입니다.");
                        found = true;
                        break;
                    }
                }
                
                if (!found) {
                    System.out.println("해당 학번을 찾을 수 없습니다.");
                }
                
                System.out.print("계속 검색하시겠습니까? (종료하려면 0 입력)>> ");
                int exit = scanner.nextInt();
                if (exit == 0) {
                    break;
                }
                
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 정수를 입력해주세요.");
                scanner.nextLine();  // 버퍼 초기화
                continue;
            }
        }
        
        System.out.println("프로그램을 종료합니다.");
        scanner.close();
    }
}
