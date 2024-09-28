package com.lament.z.bitmagic.bth;

/**
 * Count the consecutive zero bits (trailing) on the right
 * */
public class CountTrailingZeros {

	/**
	 * 就是把 n 的尾0 置换为 1，并把 n 原本的值置换为 0.
	 * 之后遍历尾部的 1 并计数就得到结果。
	 * */
	public static int count_Linear(int n) {
		int count = 0;
		if (n != 0){
			n = (n ^ (n-1)) >> 1; // turn tailing 0s to 1s,
			while (n != 0){
				count++;
				n >>= 1;
			}
		}
		else { // n == 0
			count = 32; // 类型的位数，Java 中 int 类型为 32 位。
		}
		return count;
	}

	/**
	 * 这个就跟 Integer.numberOfTrailingZeros() 原理一样，
	 * */
	public static int count_Parallel(int n) {
		int count = 32;

		n = n & -n; // 最右的 1 和尾 0 不动，其他高位全部置为 0
		if (n != 0){count--;}
		if ((n & 0x0000FFFF) != 0){count-=16;}
		if ((n & 0x00FF00FF) != 0){count-=8;}
		if ((n & 0x0F0F0F0F) != 0){count-=4;}
		if ((n & 0x33333333) != 0){count-=2;}
		if ((n & 0x55555555) != 0){count-=1;}

		return count;
	}

	// 二分查找的版本和 count_Parallel 原理一样
	// 感兴趣可以去看 Integer.numberOfTrailingZeros() 的代码
	// 注意在 bth 中的版本 n = 0 时返回 31，而 Integer.numberOfTrailingZeros(0) 返回 32。

	// 其他几个版本跳过。
}
