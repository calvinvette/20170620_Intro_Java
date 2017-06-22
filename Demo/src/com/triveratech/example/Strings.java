package com.triveratech.example;

public class Strings {

	public static void main(String[] args) {
		
		String f1 = new String("foo");
		String f2 = new String("foo");
		
		System.out.println(f1 == f2);
		System.out.println("foo" == "foo");
		System.out.println("foo" == f2);
		
		System.out.println("foo".equals(f1));
		System.out.println("foo".equals(f2));
		System.out.println("foo".equals("foo"));
		System.out.println("foo".equalsIgnoreCase("Foo"));
		System.out.println("foo".length());
		String myString = "Now is the time for all good programmers to come to the aid of their country";
		System.out.println(myString.charAt(7));
		System.out.println(myString.indexOf('t'));
		System.out.println(myString.lastIndexOf('t'));
		System.out.println(myString.substring(7, 10));
		String myRecord = "Harry\tPotter\t+44 0206-555-2132\tharry@hogwarts.ac.uk";
		int firstTab = myRecord.indexOf('\t');
		String firstName = myRecord.substring(0, firstTab);
		System.out.println(firstName);
		int secondTab = myRecord.indexOf('\t', firstTab + 1);
		String lastName = myRecord.substring(firstTab + 1, secondTab);
		System.out.println(lastName);
		String fields[] = myRecord.toUpperCase().split("\t"); // myRecord.split("\t");
		for (int i = 0; i < fields.length; i++) {
			System.out.print(fields[i]);
			if (i != (fields.length - 1)) {
				System.out.print('\t');
			}
		}
		System.out.println();
		String fileName = "Resume.doc";
		if (fileName.endsWith("doc")) {
			System.out.println("MS Word Document");
		} else {
			System.out.println("Unknown Doc Type");
		}
		if (fileName.startsWith("Resume")) {
			System.out.println("It's a resume!");
		} else {
			System.out.println("Unknown Doc");
		}
		System.out.println("   foo bar gorp     ".trim());
		StringBuilder sbuilder = new StringBuilder(myString);
		sbuilder.append("foo");
		String result = sbuilder.toString();
		System.out.println(result);
		System.out.println(sbuilder);
	}

}
