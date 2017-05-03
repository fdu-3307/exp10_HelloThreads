/**
 * 
 */
package com.mycompany.exp10.one;

import java.util.Map;

import com.mycompany.exp10.common.HelloJava8streams;
import com.mycompany.exp10.common.MyLanguageEnum;

/**
 * Example Thread class showing concurrent programming in Java. 
 * Showing how to run threads by extending Thread
 * 
 * @author ilker
 *
 */
public class MyThread extends Thread {
	public static final int DEFAULT_LOOP_COUNT = 10;
	
	private MyLanguageEnum myLanguageEnum;
	private int loopCount;
	private Map<Integer, String> loopMap;
	
	public MyThread(MyLanguageEnum _myLanguageEnum) {
		this(_myLanguageEnum, DEFAULT_LOOP_COUNT);
	}
	
	public MyThread(MyLanguageEnum _myLanguageEnum, int _loopCount) {
		myLanguageEnum = _myLanguageEnum;
		loopCount = HelloJava8streams.getAdjustedMapSize(_loopCount);
		loopMap = HelloJava8streams.getMap2size(myLanguageEnum, loopCount);
	}
	
	@Override
	public void run() {
		for (Integer count : loopMap.keySet()) {
			System.out.println("MyThread id:" + Thread.currentThread().getId() + ", count:" + count + ", " + loopMap.get(count));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("BEF MyThread::main with thread id:" + Thread.currentThread().getId());
		
		MyThread t1 = new MyThread(MyLanguageEnum.English);
		t1.start();
		
		MyThread t2 = new MyThread(MyLanguageEnum.Turkish, 5);
		t2.start();
		
		MyThread t3 = new MyThread(MyLanguageEnum.Spanish, 15);
		t3.start();
		
		System.out.println("EOF MyThread::main");
	}
	
}
