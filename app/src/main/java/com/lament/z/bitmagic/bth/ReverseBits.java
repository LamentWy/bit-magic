package com.lament.z.bitmagic.bth;

/**
 * Reverse bits
 * */
public class ReverseBits {

	/**
	 * 遍历
	 * */
	public static int reverseBits(int n) {
		assert n >= 0;

		int reversed = n;
		int size = 32 - 1;
		while (n != 0) {
			n >>= 1;
			reversed <<= 1;
			reversed |= (n & 1);
			size--;
		}
		return reversed <<= size;
	}

	// skip others
	// 不是我偷懒，是实在我对需要翻转比特位的需求完全不了解。
	// 似乎这个需求在某些领域还挺常见的，在此特意说明一下。


}
