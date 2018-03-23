package com.demo3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class CountTask extends RecursiveTask<Integer> {
	private static final int THRESHOLD = 2;// 阈值
	private int start;
	private int end;

	public CountTask(int start, int end) {
		// TODO Auto-generated constructor stub
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		// TODO Auto-generated method stub
		int sum = 0;
		boolean canCompute = (end - start) <= THRESHOLD;
		if (canCompute) {
			for (int i = start; i <= end; i++) {
				sum += i;
			}
		} else {
			int middle = (start + end) / 2;
			CountTask leftTask = new CountTask(start, end);
			CountTask rightTask = new CountTask(middle + 1, end);
			// 执行子任务
			leftTask.fork();
			rightTask.fork();
			// 等待子任务执行完成，并得到其结果
			int leftResult = leftTask.join();
			int rightResult = rightTask.join();
			// 合并子任务
			sum = leftResult + rightResult;

		}
		return sum;
	}

	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		// 生成一个计算任务
		CountTask task = new CountTask(1, 4);
		// 执行任务
		Future<Integer> result = forkJoinPool.submit(task);
		try {
			System.out.println(result.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
