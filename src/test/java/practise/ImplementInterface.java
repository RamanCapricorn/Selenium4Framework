package practise;

public class ImplementInterface implements Drawable, Printable {

	public void draw(){
		System.out.println("Drawing.");
	}
	public static void main(String[] args) {

		ImplementInterface d = new ImplementInterface();
		d.draw();
//		d.drawmesg();
//		d.printmesg();
//		Drawable.msg();
//		Printable.msg();
	}

}
