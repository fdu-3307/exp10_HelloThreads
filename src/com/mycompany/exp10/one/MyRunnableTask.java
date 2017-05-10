/**
 * 
 */
package com.mycompany.exp10.one;

import java.util.Map;

import com.mycompany.exp10.common.HelloJava8streams;
import com.mycompany.exp10.common.MyLanguageEnum;

/**
 * Example task class implementing Runnable showing concurrent programming in Java. 
 * Showing how to run tasks that extend Runnable in threads
 * 
 * @author ilker
 *
 */
public class MyRunnableTask implements Runnable {
	public static final int DEFAULT_LOOP_COUNT = 10;
	
	private MyLanguageEnum myLanguageEnum;
	private int loopCount;
	private Map<Integer, String> loopMap;
	
	public MyRunnableTask(MyLanguageEnum _myLanguageEnum) {
		this(_myLanguageEnum, DEFAULT_LOOP_COUNT);
	}
	
	public MyRunnableTask(MyLanguageEnum _myLanguageEnum, int _loopCount) {
		myLanguageEnum = _myLanguageEnum;
		loopCount = HelloJava8streams.getAdjustedMapSize(_loopCount);
		loopMap = HelloJava8streams.getMap2size(myLanguageEnum, loopCount);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for (Integer count : loopMap.keySet()) {
			System.out.println("MyThread id:" + Thread.currentThread().getId() + ", count:" + count + ", " + loopMap.get(count));
			// NOTE ilker - TODO run with below commented and below unCommented and see difference
/*			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
*/		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("BEF MyRunnableTask::main with thread id:" + Thread.currentThread().getId());
		
		Runnable r1 = new MyRunnableTask(MyLanguageEnum.English);
		Thread t1 = new Thread(r1);
		t1.start();
		
		Runnable r2 = new MyRunnableTask(MyLanguageEnum.Turkish, 5);
		Thread t2 = new Thread(r2);
		t2.start();
		
		Runnable r3 = new MyRunnableTask(MyLanguageEnum.Spanish, 15);
		Thread t3 = new Thread(r3);
		t3.start();
		
		System.out.println("EOF MyRunnableTask::main");
	}

}
