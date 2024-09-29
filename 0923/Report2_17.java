package Report;
import java.util.Scanner;

public class Report2_17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***** 겜블링 게임을 시작합니다. *****");
        
        while (true) {
            System.out.print("사용자는 <Enter>키 입력>>");
            scanner.nextLine();  // Enter 키 입력 대기
            
            int num1 = (int) (Math.random() * 3);  // 0~2 사이의 랜덤 수
            int num2 = (int) (Math.random() * 3);  // 0~2 사이의 랜덤 수
            int num3 = (int) (Math.random() * 3);  // 0~2 사이의 랜덤 수
            
            System.out.println(num1 + " " + num2 + " " + num3);
            
            // 세 숫자가 모두 같은지 확인
            if (num1 == num2 && num2 == num3) {
                System.out.println("성공, 대박났습니다!");
                break;  // 게임 종료
            }
        }
        
        scanner.close();
        System.out.println("프로그램을 종료합니다.");
    }
}
