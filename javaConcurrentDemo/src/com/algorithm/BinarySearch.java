package com.algorithm;
/**
 * 快速查找算法，可以根据想要找的是第几个大的数，
 * 每次循环都能固定下来一个数在数组完整排完序之后的位置，
 * 每次循环都能定一个数的位置，
 * 如果当前固定的数的位置和用户要找的第几个数匹配，则就直接返回。
 * 例如我要找第二大的数，如果循环一次固定的数的下标是1，那就是当前需要找的数。
 * @author tim
 *
 */
public class BinarySearch {
	public static int ef(int a[], int tag) {
		int first = 0;
		int end = a.length;
		for (int i = 0; i < a.length; i++) {
			int middle = (first + end) / 2;
			if (tag == a[middle]) {
				return middle;
			}
			if (tag > a[middle]) {
				first = middle + 1;
			}
			if (tag < a[middle]) {
				end = middle - 1;
			}
		}
		return 0;

	}
}
