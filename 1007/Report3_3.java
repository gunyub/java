//246쪽 3번
package Report;

import java.util.Scanner;

class Grade{
	String name;
	double sub1;
	double sub2;
	double sub3;

	// 생성자
	public Grade(String name, double sub1, double sub2, double sub3) {
		this.name = name;
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
	}
	// 평균 메소드
	public double aver() {
		return (sub1+sub2+sub3)/3;
	}
	// 이름 
	public String getName() {
		return name;
	}
}


public class Report3_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("이름, 자바. 웹프로그래밍, 운영체제 순으로 점수 입력>> ");
		String name = scanner.next();
		double java = scanner.nextDouble();
		double web = scanner.nextDouble();
		double os = scanner.nextDouble();
		Grade st = new Grade(name,java,web,os);
		
		System.out.println(st.getName()+" 의 평균은 "+st.aver());
		scanner.close();
	}
}
