package com.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class JucTest {
private static int count=0;
//请求总数
private static int clientTotal=3000;
//同时并发执行的线程数
private static int threadTotal=200;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
ExecutorService executorService=Executors.newCachedThreadPool();
final Semaphore semaphore=new Semaphore(threadTotal);
final CountDownLatch countDownLatch=new CountDownLatch(clientTotal);
for(int i=0;i<clientTotal;i++){
	executorService.execute(()->{
		try{
		semaphore.acquire();
		add();
		semaphore.release();
		}catch(Exception e){
			System.out.println("exp:"+e);
		}
		countDownLatch.countDown();//计数器减数
	});
	countDownLatch.await();
	executorService.shutdown();
	System.out.println("count:"+count);
}
	}
private static void add(){
	count++;
}
}
