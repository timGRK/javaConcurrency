package com.demo;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerTest {
private static final Exchanger<String> exgr=new Exchanger<>();
private static ExecutorService threadPool=Executors.newFixedThreadPool(2);
public static void main(String[] args) {
	threadPool.execute(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			String A="银行A";
			try {
				exgr.exchange(A);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	});
	
	threadPool.execute(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			String B="银行A";
			String A;
			try {
				A = exgr.exchange(B);
				System.out.println("是否一致："+A.equals(B)+",A录入的是："+A+",B录入的是："+B);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	});
}
}
