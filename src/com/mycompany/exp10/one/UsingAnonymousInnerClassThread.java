/**
 * 
 */
package com.mycompany.exp10.one;

import java.util.Map;

import com.mycompany.exp10.common.HelloJava8streams;
import com.mycompany.exp10.common.MyLanguageEnum;

/**
 * Example class showing concurrent programming in Java. 
 * Showing how to run threads by creating anonymous inner class instances of Thread implementing run method
 * 
 * @author ilker
 *
 */
public class UsingAnonymousInnerClassThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("BEF UsingAnonymousInnerClassThread::main with thread id:" + Thread.currentThread().getId());

		Thread t1 = new Thread() {
			@Override
//			public void start() {	// WRONG
			// NOTE ilker - start is a "synchronized" method, so if you override it instead of run, threads will run in order, meaning not concurrently, but start after previous one finishes
			public void run() {
				Map<Integer, String> loopMap = HelloJava8streams.getMap2size(MyLanguageEnum.English, MyThread.DEFAULT_LOOP_COUNT);
				
				for (Integer count : loopMap.keySet()) {
					System.out.println("MyThread id:" + Thread.currentThread().getId() + ", count:" + count + ", " + loopMap.get(count));
//					System.out.println("MyThread id:" + this.getId() + ", count:" + count + ", " + loopMap.get(count));
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
				Map<Integer, String> loopMap = HelloJava8streams.getMap2size(MyLanguageEnum.Turkish, 5);
				
				for (Integer count : loopMap.keySet()) {
					System.out.println("MyThread id:" + Thread.currentThread().getId() + ", count:" + count + ", " + loopMap.get(count));
//					System.out.println("MyThread id:" + this.getId() + ", count:" + count + ", " + loopMap.get(count));
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
				Map<Integer, String> loopMap = HelloJava8streams.getMap2size(MyLanguageEnum.Spanish, 15);
				
				for (Integer count : loopMap.keySet()) {
					System.out.println("MyThread id:" + Thread.currentThread().getId() + ", count:" + count + ", " + loopMap.get(count));
//					System.out.println("MyThread id:" + this.getId() + ", count:" + count + ", " + loopMap.get(count));
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

		t3.start();
		t2.start();
		t1.start();
	
		System.out.println("EOF UsingAnonymousInnerClassThread::main");

	}

}
