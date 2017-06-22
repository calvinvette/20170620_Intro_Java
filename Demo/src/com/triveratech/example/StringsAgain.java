package com.triveratech.example;

public class StringsAgain {

	public static void main(String[] args) {
		String string1 = "Hello";
		String string2 = new String("Hello");
		String string2b = "Hello";
		
		String string3 = "How are you?";
		String string4 = string3;
		System.out.println(string1.length());
		if (string1.equals(string2)) {
			System.out.println("1 & 2 are .equals() the same");
		} else {
			System.err.println("1 & 2 are NOT .equals() the same");
		}
		if (string1 == string2) {
			System.out.println("1 & 2 are == the same");
		} else {
			System.err.println("1 & 2 are NOT == the same");
		}
		if (string1.equals(string2b)) {
			System.out.println("1 & 2b are .equals() the same");
		} else {
			System.err.println("1 & 2b are NOT .equals() the same");
		}
		if (string1 == string2b) {
			System.out.println("1 & 2b are == the same");
		} else {
			System.err.println("1 & 2b are NOT == the same");
		}
		System.out.println(string1.toUpperCase());
	}

}
