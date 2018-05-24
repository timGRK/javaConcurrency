package com.lock;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.FileChannel;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class LockDemo2 {
public static void main(String[] args) throws Exception {
//	ThreadLocal
//	Buffer buffer;
	FileInputStream fInputStream=new FileInputStream(new File("/Users/tim/Downloads/ebook/MacTalk·人生元编程.azw3"));
	FileChannel fChannel=fInputStream.getChannel();
	ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
	int count=fChannel.read(byteBuffer);
	
	fChannel.close();
	byteBuffer.flip();
	System.out.println(count);
	
	AsynchronousServerSocketChannel server=AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(1024));
	//使用上的accept方法
	
//	AsynchronousSocketChannel
	AtomicInteger aInteger;
	AtomicReference aReference;
	AtomicStampedReference aStampedReference;
	AtomicIntegerArray array;
	AtomicIntegerFieldUpdater updater;
//	Vector
	
	
}
}
