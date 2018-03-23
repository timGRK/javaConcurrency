package com.demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest2 {
	static CyclicBarrier cBarrier = new CyclicBarrier(2);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread=new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					cBarrier.await();
				} catch (Exception e) {
					// TODO: handle exception
				}
				// TODO Auto-generated method stub
			
			}
		});
		thread.start();
		thread.interrupt();
		
		try {
			cBarrier.await();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(cBarrier.isBroken());//判断阻塞线程是否被中断
		} 
		
	}

}
