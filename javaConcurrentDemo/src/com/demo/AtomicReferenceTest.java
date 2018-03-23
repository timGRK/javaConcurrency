package com.demo;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {
public static AtomicReference<User> atomicReference=new AtomicReference<User>();
public static void main(String[] args) {
	User user=new User("tim", 23);
	atomicReference.set(user);
	User userUpdater=new User("tm",22);
	atomicReference.compareAndSet(user,userUpdater);
	System.out.println(atomicReference.get().getName());
	System.out.println(atomicReference.get().getOld());
}
static class User{
	private String name;
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
	private int old;
	public User(String name,int old){
		this.name=name;
		this.old=old;
	}
}
}
