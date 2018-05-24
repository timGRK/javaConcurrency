package com.java8;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

class Order{
	public Order(String title, int price, int amount) {
		super();
		this.title = title;
		this.price = price;
		this.amount = amount;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	private String title;
	private int price;
	private int amount;
}

public class MapReduceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
List<Order> all=new ArrayList<>();
all.add(new Order("cellphone", 18,2));
all.add(new Order("java", 28,23));
all.add(new Order("pc", 158,24));
all.add(new Order("book", 128,12));
//Integer money=all.stream().map((obj)->obj.getPrice()*obj.getAmount()).reduce((sum,x)->sum+x).get();
//mapreduce数据处理
IntSummaryStatistics money=all.stream().mapToInt((ojb)->ojb.getPrice()*ojb.getAmount()).summaryStatistics();
System.out.println("总量："+money.getCount());
System.out.println("平均值："+money.getAverage());
System.out.println("最大："+money.getMax());
System.out.println("最小："+money.getMin());
System.out.println("总和："+money.getSum());
	}

}
