package com.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
private static final int THREAD_COUNT=30;
private static ExecutorService threadpool=Executors.newFixedThreadPool(THREAD_COUNT);
private static Semaphore semaphore=new Semaphore(10);
public static void main(String[] args) {
	for(int i=0;i<THREAD_COUNT;i++){
		threadpool.execute(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					semaphore.acquire();//获取一个许可证
					System.out.println("save data");
					semaphore.release();//归还许可证
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
	}
	threadpool.shutdown();
}
}
