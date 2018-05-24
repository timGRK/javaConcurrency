package com.juc;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import com.google.common.collect.Maps;

public class MapExample {
	private static Map<Integer,Integer> map=Maps.newHashMap();
private static int threadNum=1;
private static int clientNum=5000;
private static long count=0;
public static void main(String[] args) {
	ExecutorService exec=Executors.newCachedThreadPool();
	final Semaphore semaphore=new Semaphore(threadNum);
	for(int index=0;index<clientNum;index++){
	final int threadNum=index;
		exec.execute(()->{
			try {
				semaphore.acquire();
				func(threadNum);
				semaphore.release();
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("exception:"+e);
			}
		});
		exec.shutdown();
		System.out.println("count:"+map.size());
		
	}
}
private static void func(int threadNum ) {
	map.put(threadNum,threadNum);
}
}
