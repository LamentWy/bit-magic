package com.lament.z.bitmagic.bth;

/**
 * Determining if an integer is a power of 2
 * */
public class PowerOfTwo {

	/**
	 * 这个技巧在特定场景很好用。
	 *
	 * 不过需要注意，这个方法的缺陷是会把 0 也算做 2 的幂。
	 * */
	public static boolean isPowerOfTwo(int n) {
		return (n & (n - 1)) == 0;
	}

	public static boolean isPowerOfTwoCutZero(int n) {
		return  (n & (n - 1)) == 0 && (n != 0);
	}
}
