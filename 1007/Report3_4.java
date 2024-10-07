// 246 5번
package Report;

import java.util.Scanner;

class Song{
	String title;
	String singer;
	int year;
	String lang;
	
	//생성자
	public Song(String title,String singer,int year,String lang) {
		this.title=title;
		this.singer=singer;
		this.year=year;
		this.lang=lang;
	}
	// 노래 정보 출력 메소드
	public void show() {
		System.out.println(year+"년 "+lang+"의 "+singer+"가 부른 "+title);
	}
	
}

public class Report3_4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("제목");
		String title = scanner.nextLine();
		System.out.println("가수");
		String singer = scanner.nextLine();
		System.out.println("년도");
		int year = scanner.nextInt();
		System.out.println("나라");
		String lang = scanner.next();
		
		Song song = new Song(title, singer, year, lang);
		song.show();
		scanner.close();
		
	}
}
