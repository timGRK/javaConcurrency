package com.demo;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterTest {
	//1.创建原子更新器，并设置需要更新的对象类和对象属性
private static AtomicIntegerFieldUpdater<User> a=AtomicIntegerFieldUpdater.newUpdater(User.class,"old");
public static void main(String[] args) {
	User user=new User("en",3);
	//输出旧的年龄
	System.out.println(a.getAndIncrement(user));
	//输出长了1岁的年龄
	System.out.println(a.get(user));
	
}
public static class User{
	private String name;
	//2 更新类的字段必须使用public volatile修饰
	public  volatile int old;
	public User(String name,int old){
		this.name=name;
		this.old=old;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOld() {
		return old;
	}
	public void setOld(int old) {
		this.old = old;
	}
	
}
}
