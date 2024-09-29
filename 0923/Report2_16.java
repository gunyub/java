
//과목과 학점이 들어 있는 다음 2개의 배열을 활용하여
// 과목명을 입력받아 학점을 출력하는 프로그램을 작성하라."그만" 이 입력되면프로그램을 종료한다.
package Report;
import java.util.Scanner;

public class Report2_16 {
    public static void main(String[] args) {
        String[] course = {"C", "C++", "Python", "Java", "HTML5"};
        String[] grade = {"A", "B+", "C", "B", "D"};
        
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("과목명을 입력하세요: ");
            String courseName = scanner.nextLine();  // 과목명 입력
            
            boolean found = false;  // 입력된 과목이 배열에 있는지 확인하기 위한 변수
            
            // 입력된 과목을 배열에서 검색
            for (int i = 0; i < course.length; i++) {
                if (course[i].equals(courseName)) {
                    System.out.println("과목명: " + course[i] + ", 점수: " + grade[i]);
                    found = true;
                    break;
                }
            }
            
            if (!found) {  // 과목을 찾지 못한 경우
                System.out.println("없는 과목입니다.");
            }
            
            System.out.print("계속하려면 '계속', 그만하려면 '그만'을 입력하세요: ");
            String continueInput = scanner.nextLine();
            if (continueInput.equals("그만")) {
                break;  // 반복문 종료
            }
        }
        
        scanner.close();
        System.out.println("프로그램을 종료합니다.");
    }
}
