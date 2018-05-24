package com.algorithm;

import java.util.Arrays;

public class BubbleSort {
public static void mp(int a[]){
	int swap=0;
	for(int i=0;i<a.length;i++){
		for(int j=i;j<a.length;j++){
			if(a[j]>a[i]){
				swap=a[i];
				a[i]=a[j];
				a[j]=swap;
			}
		}
	}
	System.out.println(Arrays.toString(a));
}
}
