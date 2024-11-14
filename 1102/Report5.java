package reportPackage;
import java.util.Scanner;

public class Report5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float sum = 0;
        
        System.out.print("여러 과목의 학점을 빈칸으로 분리 입력>> ");
        String line = sc.nextLine();
        String array = line.toUpperCase();
        String[] gradeArray = array.split(" ");
        
        for (int i = 0; i < gradeArray.length; i++) {
            if ("A".equals(gradeArray[i])) {
                sum += 100;
            } else if ("B".equals(gradeArray[i])) {
                sum += 90;
            } else if ("C".equals(gradeArray[i])) {
                sum += 80;
            } else if ("D".equals(gradeArray[i])) {
                sum += 70;
            } else if ("F".equals(gradeArray[i])) {
                sum += 0;
            }
        }

        // gradeArray.length로 과목 수로 나눠 평균 계산
        double aver = sum / gradeArray.length;
        System.out.println("평균은 " + aver);
        sc.close();
    }
}
