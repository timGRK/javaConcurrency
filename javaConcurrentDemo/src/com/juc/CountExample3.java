package com.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class CountExample3 {
private static int threadTotal=200;
private static int clientTotal=5000;
private static AtomicLong count=new AtomicLong(0);
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
		System.out.println("count:"+count.get());
		
	}
}
private static void add() {
	// TODO Auto-generated method stub
	count.incrementAndGet();
}
}
