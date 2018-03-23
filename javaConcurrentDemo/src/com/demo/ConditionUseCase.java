package com.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionUseCase {
Lock lock=new ReentrantLock();
Condition condition=lock.newCondition();
public void conditionWait() throws InterruptedException{
	try {
		condition.await();
	} finally {
		// con: handle finally clause
		lock.unlock();
	}
}
public void conditionSignal(){
	lock.lock();
	try {
		condition.signal();
	} finally {
		// TODO: handle finally clause
		lock.unlock();
	}
}
}
