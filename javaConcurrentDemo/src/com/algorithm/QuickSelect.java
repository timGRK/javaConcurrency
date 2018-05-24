package com.algorithm;

public class QuickSelect {
public static int quickSelect(int[] arr,int selectIndex) {
	int s=0;
	int i=s+1;
	while(i<arr.length){
		if(arr[i]<arr[0]){
			int t=arr[s+1];
			arr[s+1]=arr[i];
			arr[i]=t;
			s+=1;
			i=s+1;
			continue;
		}
		i++;
	}
	//i找到最后将下表为s的值和第一个值交换
	int temp= arr[0];
	arr[0]=arr[s];
	arr[s]=temp;
	if(selectIndex-1==s){
		return arr[s];
	}else{
		//将数组不需要的切掉，用后一部分去回调
		int arrs[]=new int[arr.length-s];
		for(int j=s;j<arr.length;j++){
			arrs[j-s]=arr[j];
		}
		quickSelect(arrs, selectIndex);
	}
	return 0;
}


}
