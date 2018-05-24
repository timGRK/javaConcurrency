package com.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class CountExample {
private static int threadTotal=200;
private static int clientTotal=5000;
private static long count=0;
public static void main(String[] args) {
	ExecutorService exec=Executors.newCachedThreadPool();
	final Semaphore semaphore=new Semaphore(threadTotal);
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
		});
		exec.shutdown();
		System.out.println("count:"+count);
		
	}
}
private static void add() {
	// TODO Auto-generated method stub
	count++;
}
}
