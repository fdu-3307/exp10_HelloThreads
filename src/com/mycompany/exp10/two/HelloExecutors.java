/**
 * 
 */
package com.mycompany.exp10.two;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.mycompany.exp10.common.MyLanguageEnum;
import com.mycompany.exp10.one.MyRunnableTask;

/**
 * Example class showing concurrent programming in Java using executors framework. 
 * showing how to put Runnable tasks into thread pool (each thread will get a Runnable task)
 * showing the threads in the pool will take tasks as they are done with what they were doing
 * 
 * @author ilker
 *
 */
public class HelloExecutors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("BEF HelloExecutors::main with thread id:" + Thread.currentThread().getId());

		// Create a fixed thread pool of maximum 3 threads
		ExecutorService es = Executors.newFixedThreadPool(3);
		
		// put Runnable tasks into thread pool (each thread will get a Runnable task)
		// NOTE ilker the threads in the pool will take tasks as they are done with what they were doing
		es.execute(new MyRunnableTask(MyLanguageEnum.English));
		es.execute(new MyRunnableTask(MyLanguageEnum.Turkish, 5));
		es.execute(new MyRunnableTask(MyLanguageEnum.Spanish, 15));
		es.execute(new MyRunnableTask(MyLanguageEnum.Turkish, 10));
		es.execute(new MyRunnableTask(MyLanguageEnum.Turkish, 15));
		es.execute(new MyRunnableTask(MyLanguageEnum.Spanish, 5));
		es.execute(new MyRunnableTask(MyLanguageEnum.British, 15));

		// shutdown ExecutorService, so it stops accepting new tasks and initiates an orderly winding down.
		es.shutdown();

		System.out.println("EOF HelloExecutors::main");
	}

}
