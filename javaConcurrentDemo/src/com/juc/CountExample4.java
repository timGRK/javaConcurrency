package com.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.LongAdder;

public class CountExample4 {
private static int threadTotal=200;
private static int clientTotal=5000;
private static LongAdder count=new LongAdder();
public static void main(String[] args) throws InterruptedException {
	ExecutorService exec=Executors.newCachedThreadPool();
	final Semaphore semaphore=new Semaphore(threadTotal);
	final CountDownLatch countDownLatch=new CountDownLatch(clientTotal);
	for(int index=0;index<clientTotal;index++){
		exec.execute(()->{
			try {
				semaphore.acquire();
				add();
				semaphore.release();
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("exception:"+e);
			}
			countDownLatch.countDown();
		});
		countDownLatch.await();
		exec.shutdown();
		System.out.println("count:"+count);
		
	}
}
private static void add() {
	// TODO Auto-generated method stub
	count.increment();
}
}
