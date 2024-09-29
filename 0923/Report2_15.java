package Report;

import java.util.Scanner;

public class Report2_15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String boyMiddleList[] = {"가", "민", "용", "종", "진", "재", "승", "소", "상", "자"};
        String boyLastList[] = {"태", "진", "광", "혁", "우", "철", "반", "준", "구", "호", "석"};
        String girlMiddleList[] = {"은", "원", "경", "수", "현", "예", "여", "송", "서", "채", "하"};
        String girlLastList[] = {"진", "연", "경", "서", "라", "숙", "미", "원", "라", "희", "수"};

        // 성별 구분
        String male = "남";
        String female = "여";
        String stop = "그만";

        System.out.println("작명 프로그램을 시작합니다.");

        while (true) {
            // 남여 선택
            System.out.println("남/여 선택: ");
            String choose = scanner.next();

            if (choose.equals(male)) {
                System.out.print("성 입력> ");
                String firstName = scanner.next();
                System.out.println("추천 이름> " + firstName);

                int num = (int) (Math.random() * boyMiddleList.length);
                String Middle = boyMiddleList[num];

                num = (int) (Math.random() * boyLastList.length);
                String Last = boyLastList[num];

                System.out.println(firstName + Middle + Last);

            } else if (choose.equals(female)) {
                System.out.print("성 입력> ");
                String firstName = scanner.next();
                System.out.println("추천 이름> " + firstName);

                int num = (int) (Math.random() * girlMiddleList.length);
                String Middle = girlMiddleList[num];

                num = (int) (Math.random() * girlLastList.length);
                String Last = girlLastList[num];

                System.out.println(firstName + Middle + Last);
            } else {
                // 남/여가 아닌 다른 입력이 들어왔을 때
                System.out.println("남/여/그만/ 중에서 선택하세요: ");
                choose = scanner.next();

                if (choose.equals(stop)) {
                    break;
                }
            }
        }

        scanner.close();
    }
}
