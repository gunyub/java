package Report;

import java.util.Scanner;

public class Report2_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
	//자동차 상태를 나타내는 정수입력
	int status = scanner.nextInt();
	
	if((status & 0b01000000)!=0) System.out.println("에어컨 켜진 상태");
	else System.out.println("에어컨 꺼진 상태");
	
	if((status & 0b10000000)!=0) System.out.println("달리는 상태");
	else System.out.println("멈춘 상태");
	
	int temperature = status & 0b00011111; 
    System.out.println("자동차 온도: " + temperature + "°C");
    
    scanner.close(); 
}
}
