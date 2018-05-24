package com.demo;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//ThreadPoolExecutor poolExecutor=(ThreadPoolExecutor) Executors.newSingleThreadExecutor();
Thread thread=new Thread(new Runnable() {
	public void run() {
		System.out.println("$$$$$$$");
	}
});
thread.start();
thread.start();
	}

}
