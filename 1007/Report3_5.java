//247쪽 6번
package Report;

class Rectangle {
	int x, y, width, height;
	
	// 생성자
	public Rectangle(int x,int y,int width,int height) {
		this.x= x;
		this.y= y;
		this.width = width;
		this.height = height;
	}
	// 정사각형이면 true 아니면 false
	public boolean isSquare() {
			return width == height;
	}
	// 현재 내부에 매개변수로 받은 사각형 r 이 있으면 true 아니면 false
	public boolean contains(Rectangle r) {
		return (this.x <= r.x)&&(this.y <= r.y)
				&&(this.x+this.width>=r.x+r.width)
				&&(this.y+this.width>=r.y+r.height);
		}
	// show
	public void show() {
		System.out.println("("+x+","+y+")에서 크기가 "+width+","+height+"인 사각형");
	}
}


public class Report3_5 {
	public static void main(String[] args) {
		Rectangle a = new Rectangle(3,3,6,6);
		Rectangle b = new Rectangle(4,4,2,3);
		
		a.show();
		if(a.isSquare()) System.out.println("a는 정사각형입니다.");
		else System.out.println("a는 직사각형입니다");
		if(a.contains(b)) System.out.println("a는 b를 포함합니다");
		else System.out.println("b는 a를 포함합니다");
	}

}
