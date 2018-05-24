package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//Arrays.asList("a","b","d").forEach(e -> System.out.println(e));
List<String> all=new ArrayList<>();
all.add("java");
all.add("python");
all.add("javascript");
all.add("jsp");
Stream<String> stream=all.stream();
//System.out.println(stream.count());//数据统计
//System.out.println(stream.filter((e) ->e.contains("java")).count());//统计一类内容
//统计匹配的收集内容
//List<String>list=stream.filter((e) ->e.contains("java")).collect(Collectors.toList());
List<String>list=stream.skip(3).limit(2).map((s)->s.toUpperCase()).collect(Collectors.toList());

System.out.println(list);
	
	//mapreduce2个阶段组成：
//map():指对数据进行先期的操作；reduce():进行数据的统计分析
	}

}
