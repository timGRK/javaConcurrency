package com.juc;

import java.util.Collections;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;

public class ImmutableExample2 {
private final static  ImmutableList list=ImmutableList.of(1, 2, 3, 4);
private final static  ImmutableSet set=ImmutableSet.copyOf(list);
private final static ImmutableMap<Integer, Integer> map=ImmutableMap.of(1,2,3,4);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//list.add(4);
//set.add(4);
//map.put(1, 4);
		System.out.println(map.get(2));
		
//		ThreadLocal
	}

}
