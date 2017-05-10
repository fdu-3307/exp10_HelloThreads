/**
 * 
 */
package com.mycompany.exp10.one;

/**
 * Example class showing concurrent programming in Java. 
 * Showing how to run threads by creating anonymous inner class instances of Thread implementing run method
 * Showing "join" of threads (the thread that is letting another thread join will wait for that thread to finish)
 * 
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
//			public void start() {	// WRONG
			// NOTE ilker - start is a "synchronized" method, so if you override it instead of run, threads will run in order, meaning not concurrently, but start after previous one finishes
			public void run() {
				for (int count=0; count < 10; count++) {
					System.out.println("MyThread id:" + Thread.currentThread().getId() + ", count:" + count);
//					System.out.println("MyThread id:" + this.getId() + ", count:" + count);

					if(count <= 3) {
						for (int i = 0; i < 1E9; i++) {
							// just burning CPU cycles
						}
					} else {
						this.yield();
					}

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
					
					if(count%2 == 0 || count%3 == 0) {
//					if(count <= 10) {
						this.yield();
					} else {
						for (int i = 0; i < 1E9; i++) {
							// just burning CPU cycles
						}
					}
					
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
	
		// NOTE ilker without below join main thread normally will finish long before t3. But with join, main thread will wait for t3 to finish
		try {
			t2.join();	// NOTE ilker - TODO run using t3 instead of t2 and see difference 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("EOF UsingAnonymousInnerClassThreadSimple::main");

	}

}
