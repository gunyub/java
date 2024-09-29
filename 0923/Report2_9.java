package Report;

import java.util.Scanner;

public class Report2_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int intArray[] = new int[10];
        int ones = 0, tens = 0, hundreds = 0;

        System.out.println("정수 10개 입력:");
        // 10개 정수 입력받아 배열에 저장
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = scanner.nextInt();
            
            // while 문 
            for (int num : intArray) {
                int sum = 0;  
                int currentNumber = num; 

                while (currentNumber > 0) {
                    sum += currentNumber % 10; // 일의 자리 추출 및 합산
                    currentNumber /= 10;       // 다음 자리로 이동
                }

                // 합이 9인 경우 출력
                if (sum == 9) {
                    System.out.println(num);
                }
            }
        }
    

        //배열을 순회하면서 자리수 합이 9인 수 찾기 for-each
//        for(int circuit : intArray ) {
//    		hundreds = (circuit/100)%10;
//    		tens = (circuit/10)%10;
//    		ones = circuit%10;
//    		if(hundreds + tens + ones==9) {
//    			System.out.println(circuit);
//    		}
//        }
//    }
//        // 배열을 순회하면서 자리수 합이 9인 수 찾기
//        for (int i = 0; i < intArray.length; i++) {
//            int num = intArray[i];
//
//            ones = 0;
//            tens = 0;
//            hundreds = 0;
//
//            if (num >= 100) { // 세 자리 수일 때
//                hundreds = (num / 100) % 10; 
//                tens = (num / 10) % 10;      
//                ones = num % 10;             
//            } else if (num >= 10) { // 두 자리 수일 때
//                tens = (num / 10) % 10;      
//                ones = num % 10;             
//            } else { // 한 자리 수일 때
//                ones = num;                  
//            }
//
//            // 합이 9인지 확인
//            if (hundreds + tens + ones == 9) {
//                System.out.print(intArray[i] + " ");
//            }
//        }
//
//        scanner.close();
    }
}
