package com.demo1;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPoolTest {
	static ConnectionPool pool = new ConnectionPool(10);
	// 保证所有ConnectionRunner能同时开始
	static CountDownLatch start = new CountDownLatch(1);
	static CountDownLatch end;// 等待所有ConnectionRunner结束才能执行

	public static void main(String[] args) throws Exception {
		// 线程数量，可以修改线程数量进行观察
		int threadCount = 10;
		end = new CountDownLatch(threadCount);
		int count = 20;
		AtomicInteger got = new AtomicInteger();
		AtomicInteger notGot = new AtomicInteger();
		for (int i = 0; i < threadCount; i++) {
			Thread thread = new Thread(new ConnectionRunner(count, got, notGot), "ConnectionRunnerThread");
			thread.start();
		}
		start.countDown();
		end.await();
		System.out.println("totla invoke:" + (threadCount * count));
		System.out.println("got connection:" + notGot);

	}

	static class ConnectionRunner implements Runnable {
		int count;
		AtomicInteger got;
		AtomicInteger notGot;

		public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
			// TODO Auto-generated constructor stub
			this.count = count;
			this.got = got;
			this.notGot = notGot;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				start.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while (count > 0) {
				Connection connection;
				try {
					connection = pool.fetchConnection(1000);
					if (connection != null) {
						try {
							connection.createStatement();
							connection.commit();
						} finally {
							// TODO: handle finally clause
							pool.releaseConnection(connection);
							got.incrementAndGet();
						}

					} else {
						notGot.incrementAndGet();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					count--;
				}
			}
			end.countDown();
		}
	}
}
