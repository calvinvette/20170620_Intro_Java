package com.triveratech.example;

public class StringBufferAndBuilder {

	public static void main(String[] args) {
		StringBuffer buff = new StringBuffer();
		buff.append("Hello");
		buff.append(", I'm home!");
		String newString = buff.toString();
		System.out.println(newString);
		buff = new StringBuffer(newString);
		buff.append("\nWhat's for dinner?");
		System.out.println(buff);
		
		StringBuilder build = new StringBuilder();
		build.append("Hello");
		build.append(", I'm home!");
		String newString2 = build.toString();
		System.out.println(newString2);
		build = new StringBuilder(newString2);
		build.append("\nWhat's for dinner?");
		System.out.println(build);
		System.out.println();
		String paulTest = "Now is the time\nFor all good \"programmers\"\nTo come to the aid...";
		System.out.println(paulTest);
		String paulFixed = paulTest.replaceAll("\n", "\t");
		System.out.println(paulFixed);
	}

}
