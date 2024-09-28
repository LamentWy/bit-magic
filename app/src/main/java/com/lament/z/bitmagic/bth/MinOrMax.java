package com.lament.z.bitmagic.bth;

/**
 * Compute the minimum (min) or maximum (max) of two integers without branching
 * */
public class MinOrMax {

	/**
	 * 依然是看看就好，这个在 Java 中问题更多。
	 * 比如下面我得把 a 和 b 强转为 long 类型，不然 (a-b) 这一步会溢出。
	 * <p>
	 * 	 这个的原理如下: <br/>
	 * 	 if (a < b) then (a-b) >> 31 为 -1，aka 111...111  <br/>
	 * 	 if (a >= b) then (a-b) >> 31 为 0，aka 000...000  <br/>
	 * 	  <br/>
	 * 	 而 a^b 相当于 a 和 b 做一个不进位的二进制加法  <br/>
	 * 	 最后 你用 b ^ 这个结果就是最小值，a ^ 这个结果就是最大值  <br/>
	 *
	 * */
	public static int min(int a, int b) {
		long aL = a;
		long bL = b;

		return (int) (bL ^ ((aL^bL) & ((aL-bL) >> 61)));
	}

	/**
	 * same
	 * */
	public static int max(int a, int b) {
		long aL = a;
		long bL = b;

		return (int) (aL ^ ((aL^bL) & ((aL-bL) >> 61)));
	}
}
