package com.juc;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicExample {
private static AtomicReference<Integer> count=new AtomicReference<Integer>(0);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
count.compareAndSet(0,2);
count.compareAndSet(0, 1);
count.compareAndSet(2, 18);
count.compareAndSet(1, 3);
System.out.println("count:"+count.get());
	}

}
