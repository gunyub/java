package Report;
import java.util.Scanner;

public class Report2_19{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;  // 양수들의 합
        int count = 0;  // 양수의 개수

        while (true) {
            System.out.print("양의 정수를 입력하세요>> ");
            String input = scanner.nextLine();
            
            try {
                int number = Integer.parseInt(input);  // 문자열을 정수로 변환
                
                if (number <= 0) {  // 양수가 아닌 경우 무시
                    System.out.println(number + "은 양수가 아닙니다.");
                    continue;
                }
                
                sum += number;  // 양수의 합
                count++;  // 양수 개수 증가
                
            } catch (NumberFormatException e) {
                System.out.println(input + "은 정수가 아닙니다.");
                continue;  // 잘못된 입력을 무시하고 다음 입력을 받음
            }
            
            // 음수를 입력하면 반복 종료
            if (input.equals("-1")) {
                break;
            }
        }
        
        // 평균 계산 및 출력
        if (count > 0) {
            System.out.println("평균은 " + (sum / count));
        } else {
            System.out.println("입력된 양수가 없습니다.");
        }
        
        scanner.close();
    }
}
