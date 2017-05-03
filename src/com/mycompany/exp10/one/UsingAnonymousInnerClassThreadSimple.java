/**
 * 
 */
package com.mycompany.exp10.one;

/**
 * @author ilker
 *
 */
public class UsingAnonymousInnerClassThreadSimple {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("BEF UsingAnonymousInnerClassThreadSimple::main with thread id:" + Thread.currentThread().getId());

		Thread t1 = new Thread() {
			@Override
//			public void start() {
			public void run() {
				for (int count=0; count < 10; count++) {
					System.out.println("MyThread id:" + Thread.currentThread().getId() + ", count:" + count);
//					System.out.println("MyThread id:" + this.getId() + ", count:" + count);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
//		t1.start();

		Thread t2 = new Thread() {
			@Override
//			public void start() {
			public void run() {
				for (int count=0; count < 5; count++) {
					System.out.println("MyThread id:" + Thread.currentThread().getId() + ", count:" + count);
//					System.out.println("MyThread id:" + this.getId() + ", count:" + count);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
//		t2.start();
		
		Thread t3 = new Thread() {
			@Override
//			public void start() {
			public void run() {
				for (int count=0; count < 15; count++) {
					System.out.println("MyThread id:" + Thread.currentThread().getId() + ", count:" + count);
//					System.out.println("MyThread id:" + this.getId() + ", count:" + count);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
//		t3.start();

		t1.start();
		t2.start();
		t3.start();
	
		System.out.println("EOF UsingAnonymousInnerClassThreadSimple::main");

	}

}
