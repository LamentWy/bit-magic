package com.lament.z.bitmagic.bth;

/**
 * Computing parity
 *
 * 注意这个计算的是 n 的二进制中的 1 的个数是否为奇数，而不是判断 n 是否为奇数。
 * 也就是 n 的 rank 的奇偶性，其实这个我也想跳过的，毕竟 rank 都跳过了。
 * */
public class Parity {

	/**
	 * Native way
	 * 核心就是遍历。
	 * @Return true if n's rank is odd
	 * */
	public static boolean isRankOdd(int n) {
		boolean isOdd = false;
		while (n != 0) {
			isOdd = !isOdd;
			n = n & (n - 1);
		}
		return isOdd;
	}

	// 查表跳过

	public static boolean isRankOdd_Multiply(int n) {
		n ^= n >> 1;
		n ^= n >> 2;
		// 0x11111111 : 0001 0001 0001 0001 0001 0001 0001 0001
		n = (n & 0x11111111) * 0x11111111;
		return ((n >> 28) & 1) == 1;
	}

	// 二进制乘法：遇0则0，遇1则抄，逐位计算，最后相加。
	/* 2： 0010 * 3： 0011 = 6：0110
	*      0010
	*      0011
	* ---------
	* 	   0010 （遇1则抄）
	*     0010  （遇1则抄）
	*    0000   （遇0则0）
	*   0000    （遇0则0）
	* ---------
	*   0000110  （最后相加）
	* */

	public static boolean isRankOdd_InParallel(int n) {
		n ^= n >> 16;
		n ^= n >> 8;
		n ^= n >> 4;
		n &= 0xf;
		return ((0x6996 >> n) & 1)== 1;
	}


}
