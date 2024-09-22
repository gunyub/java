package Report;

import java.util.Scanner;


public class report1_7 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("여행지 >> ");
		String Country = scanner.nextLine();
		
		System.out.print("인원수>> ");
		int People = scanner.nextInt();
		
		System.out.print("숙박일>> ");
		int Day = scanner.nextInt();
		int Days = Day+1;
		
		System.out.print("1인당 항공료>> ");
		int Airport = scanner.nextInt();
		
		System.out.print("1방 숙박비>> ");
		int Room_Charge = scanner.nextInt();
		
		// 방 개수 구하는 거
		int Rooms;
		if(People%2 == 1) {
			Rooms = (People+1)/2;
		}else {
			Rooms = People/2;
		}
		// 항공비 왕복, 숙박비
		int All = (Airport*People)*2 + (Rooms*Room_Charge)*Day;
		
		System.out.print(People + "명의 " + Country + Day + "박 " + Days + "일 여행에는 방이" + Rooms + "개 필요하며 경비는" + All +"입니다");
		scanner.close();
	}

}
