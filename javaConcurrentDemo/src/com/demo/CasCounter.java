package com.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.LoggingMXBean;

import org.omg.CORBA.PRIVATE_MEMBER;

public class CasCounter {
private AtomicInteger atomiciI=new AtomicInteger(0);
private int i=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final CasCounter counter=new CasCounter();
		List<Thread> threads=new ArrayList<>();
		long start=System.currentTimeMillis();
		for(int j=0;j<100;j++){
			Thread thread=new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for(int i=0;i<10000;i++){
						counter.count();
						counter.safeCount();
					}
					
				}
			});
			threads.add(thread);
		}
		for(Thread t:threads){
			t.start();
		}
//等待所有线程执行完成
		for(Thread t:threads){
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		System.out.println(counter.i);
		System.out.println(counter.atomiciI.get());
		System.out.println(System.currentTimeMillis()-start);
	}
	/**
	 * 使用cas实现线程安全计数器
	 */
private void safeCount(){
	for(;;){
		int i=atomiciI.get();
		boolean suc=atomiciI.compareAndSet(i, ++i);
		if(suc){
			break;
		}
	}
	
}
/**
 * 非线程安全计数器
 */
private void count(){
	i++;
}
}
