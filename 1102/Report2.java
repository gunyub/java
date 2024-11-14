// 실습 2번
package reportPackage;

public class Report2 {
	public static void main(String[] args) {
		Book a = new Book("황기태","명품자바","김하진");
		Book b = new Book("황기태","명품자바","하여린");
		
		System.out.println(a);
		System.out.println(b);
		if(a.equals(b))
			System.out.println("같은 책");
		else 
			System.out.println("다른 책");
	}
}

class Book {
	String author, book, name;

	public Book(String author, String book, String name) {
		this.author = author;
		this.book = book;
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name+"이 구입한 도서:"+this.author+"의 "+this.book;
	}
	
	public boolean equals(Object obj) {
		Book b = (Book)obj; //다운캐스팅
		if(author==b.author && book==b.book) {
			return true;
		}else {
			return false;
		}
	}
	
} 
