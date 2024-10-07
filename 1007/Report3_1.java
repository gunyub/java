package Report;

class TV{
	String maker;
	int size;
	int price;
	
	public TV(String maker, int size, int price){
		this.maker = maker;
		this.size = size;
		this.price = price;
	}
	public void show() {
		System.out.println(maker+"에서 만든"+price+"만원짜리의 "+size+"인치 TV");
	}
}


public class Report3_1 {
	public static void main(String[] args) {
		TV tv = new TV("Samsung",50,300);
		tv.show();
	}
	
}
