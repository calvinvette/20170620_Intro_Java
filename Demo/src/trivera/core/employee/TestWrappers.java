package trivera.core.employee;

import static java.lang.Math.*;

public class TestWrappers {

	public static void main(String[] args) {
		Integer i = new Integer("1234");
		System.out.println("1234" + 5);			// 12345 (string concatenation)
		System.out.println(i + 5);				// 1239 (auto-unboxing)
		System.out.println(i.intValue() + 5);	// 1239 (explicit un-boxing)
		Float pi = new Float(3.14159265); // literal is a double
		System.out.println(pi);
		Double dpi = new Double(3.14159265); // literal is a double
		System.out.println(dpi);
		// can't put 64-bit double literal into a 32-bit literal
		// float primPi = 3.14159265;
		
//		java.lang.Math
		
		System.out.println(PI);
		System.out.println(sin(toRadians(90)));
		
	}

}
