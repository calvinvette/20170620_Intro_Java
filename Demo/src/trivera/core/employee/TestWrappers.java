package trivera.core.employee;

import static java.lang.Math.*;

public class TestWrappers {

	public static void main(String[] args) {
		Integer i = new java.lang.Integer("1234");
		System.out.println("1234" + 5);			// 12345 (string concatenation)
		System.out.println(i + 5);				// 1239 (auto-unboxing)
		System.out.println(i.intValue() + 5);	// 1239 (explicit un-boxing)
		Float pi = new Float(3.14159265); // literal is a double
		System.out.println(pi);					// 3.1415927
		Double dpi = new Double(3.14159265); // literal is a double
		System.out.println(dpi);					// 3.14159265
		// can't put 64-bit double literal into a 32-bit literal
//		 float primPi = 3.14159265;
		
//		java.lang.Math has static methods and properties for trig and related math
		System.out.println(java.lang.Math.PI);
		
		System.out.println(Math.PI); 	// No need for import - java.lang.Math is always pre-imported
		System.out.println(PI);			// with static import, "Math." is unnecessary
		System.out.println(sin(90));		// sin(90) is 90 Radians, not degrees
		System.out.println(sin(toRadians(90)));	// toRadians(..) converts
		System.out.println(toDegrees(Math.PI * 2)); // There are 2PI Radians in a circle and 360 degrees
		
		
	}

}
