package com.triveratech.example;

public class ThreadDemo {
	static int numberOfThreadsPrinted = 0;

	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					numberOfThreadsPrinted++;
					System.out.println("Background Thread1: " + i);
				}
			}
		});
		t.start();
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					numberOfThreadsPrinted++;
					System.out.println("Background Thread2: " + i);
				}
			}
		});
		t2.start();
		
		for (int i = 0; i < 1000; i++) {
			numberOfThreadsPrinted++;
			System.out.println("Main Thread: " + i);
		}
		System.out.println(numberOfThreadsPrinted);
	}

}
