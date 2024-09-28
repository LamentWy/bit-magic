package com.lament.z.bitmagic.bth;

/**
 * Compute the integer absolute value (abs) without branching
 *
 * */
public class ABSValue {

	/**
	 * 看看就好，现代处理器基本都有对应的指令集，可以直接清除数值的符号。
	 * */
	public static int abs(int x) {
		int mask = x >> 31; // 0 or -1
		return (x + mask) ^ mask;
	}

}
