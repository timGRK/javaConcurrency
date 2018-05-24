package com.juc;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicExample2 {
private static AtomicIntegerFieldUpdater<AtomicExample2> updater=AtomicIntegerFieldUpdater.newUpdater(AtomicExample2.class, "count");

private volatile int count=100;// 必须用volatile修饰，并且不能是static
private static AtomicExample2 example2=new AtomicExample2();
	public static void main(String[] args) {
	if(updater.compareAndSet(example2, 100, 120)){
		System.out.println("count1:"+example2.getCount());
	}
	if(updater.compareAndSet(example2, 100, 120)){
		System.out.println("count2:"+example2.getCount());
	}else{
		System.out.println("udpate fail:"+example2.getCount());
	}
	}
	public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
}
