package read;

public class TestThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Thread thread = new Thread(){
				public void run() {
					song();
				};
			};
			thread.run();
			System.out.println("sing");
			String str = "hello";
			String str1 = "he" + "llo";
			System.out.println(str == str1);
	}

	static void song(){
		System.out.println("song");
	}
}
