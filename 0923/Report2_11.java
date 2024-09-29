package Report;

import java.util.Arrays;
import java.util.Scanner;

public class Report2_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int intArray[];
        int count = 0;
        double aver = 0;

        System.out.println("정수 몇개 저장");
        int number = scanner.nextInt();
        intArray = new int[number];

        while (true) {
            int k = (int) (Math.random() * 100 + 1);
            boolean isDuplicate = false;

            // 중복 확인
            for (int i = 0; i < count; i++) {
                if (intArray[i] == k) {
                    isDuplicate = true;
                    break;
                }
            }

            // 중복이 아니면 저장
            if (!isDuplicate) {
                intArray[count] = k;
                aver += k;
                count++;
            }

            // 배열이 가득 차면 반복 종료
            if (count >= intArray.length) {
                break;
            }
        }

        System.out.println(Arrays.toString(intArray));
        System.out.println("평균은: " + (aver / number));

        scanner.close();
    }
}
