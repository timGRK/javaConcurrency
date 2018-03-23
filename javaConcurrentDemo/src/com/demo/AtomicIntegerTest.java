package com.demo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerTest {
static AtomicInteger ai=new AtomicInteger(1);
static int[] value=new int[]{1,2};
static AtomicIntegerArray aiArray=new AtomicIntegerArray(value);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 System.out.println(ai.getAndIncrement());
System.out.println(ai.get());

aiArray.getAndSet(0,3);
System.out.println(aiArray.get(0));
System.out.println(value[0]);
	}

}
