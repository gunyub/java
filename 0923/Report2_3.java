package Report;

import java.util.Random;
import java.util.Scanner;

public class Report2_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random r = new Random();
        boolean playAgain = true; // 게임 반복 여부를 제어하는 변수

        while (playAgain) {
            int random = r.nextInt(100); // 새로운 랜덤 숫자 생성
            System.out.println("0~99까지 숫자 입력");
            int min=1;
            int max=99;
            int count = 0;
            while (true) {
                int num = scanner.nextInt();
                count+=1;
                if (random > num) {
                	System.out.println(count+">>"+num);
                    System.out.println("더 높게");
                    min = num;
                    System.out.println(min+"-"+max);
                } else if (random < num) {                	
                	System.out.println(count+">>"+num);
                	System.out.println("더 낮게");
                	max = num;
                	System.out.println(min+"-"+max);
                } else if(random==num) {
                    System.out.println("정답입니다! 다시 하시겠습니까? Y or N");
                    String str = scanner.next();
                    //equals 차이점 equalsignoreCase는 대소문자를 구분하지않음 
                    if (str.equalsIgnoreCase("N")) {
                        playAgain = false; // 외부 루프 종료
                        break; // 내부 루프 종료
                    } else {
                        System.out.println("새 게임을 시작합니다! 1~100까지 숫자 입력");
                        break; // 내부 루프 종료하고 새로운 게임 시작
                    }
                }
            }
        }
        System.out.println("게임을 종료합니다.");
        scanner.close();
    }
}
