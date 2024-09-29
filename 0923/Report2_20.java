package Report;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Report2_20{
    public static void main(String[] args) {
        String[] coffee = {"핫아메리카노", "아이스아메리카노", "카푸치노", "라떼"};
        int[] price = {3000, 3500, 4000, 5000};
        
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            try {
                System.out.println("핫아메리카노, 아이스아메리카노, 카푸치노, 라떼 있습니다.");
                System.out.print("주문>> ");
                String order = scanner.nextLine();
                int index = -1;  // 메뉴의 인덱스를 저장
                
                // 주문한 메뉴 찾기
                for (int i = 0; i < coffee.length; i++) {
                    if (coffee[i].equals(order)) {
                        index = i;
                        break;
                    }
                }
                
                if (index == -1) {
                    System.out.println("없는 메뉴입니다.");
                    continue;
                }
                
                System.out.print("잔 수를 입력해주세요>> ");
                int quantity = scanner.nextInt();  // 주문 수량 입력
                scanner.nextLine();  // 버퍼 초기화
                
                int total = price[index] * quantity;  // 총 가격 계산
                System.out.println("주문한 음료: " + coffee[index]);
                System.out.println("가격은 " + total + "원입니다!");
                
            } catch (InputMismatchException e) {
                System.out.println("잔 수는 양의 정수로 입력해주세요!");
                scanner.nextLine();  // 버퍼 초기화
                continue;
            }
            
            System.out.print("주문을 그만하시겠습니까?(그만)>> ");
            String endOrder = scanner.nextLine();
            if (endOrder.equals("그만")) {
                break;
            }
        }
        
        System.out.println("주문을 종료합니다.");
        scanner.close();
    }
}
