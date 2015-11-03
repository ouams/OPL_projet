package opl;

public class A {



	public static void main(String[] args) {
		String fooString = new String("HalloWorld");
		int num = 15;

		foo(fooString, 4);
		faa(num);


	}

	private static void foo(String str, int num) {
		System.out.println("fonction foo " + str );		
	}

	private static void faa(int num) {
		for (int i = 0; i < num; i++) {
			System.out.println(num);
		}

	}
}
