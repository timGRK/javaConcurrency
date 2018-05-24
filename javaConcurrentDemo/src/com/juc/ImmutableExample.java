package com.juc;

import java.util.Collections;
import java.util.Map;

import com.google.common.collect.Maps;

public class ImmutableExample {
private static Map<Integer,Integer> map=Maps.newHashMap();
static{
	map.put(1,2);
	map.put(3,4);
	map.put(5,6);
	map=Collections.unmodifiableMap(map);//不允许修改对象
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
map.put(1,3);
System.out.println("result:"+map.get(1));
	}

}
