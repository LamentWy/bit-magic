package com.lament.z.bitmagic.bth;


/**
 * Compute the sign of an integer
 * */
public class SignOfInteger {

	/**
	 * normal way
	 * @return -1 if the given value is negative,otherwise 0
	 * */
	public static int getSign(int value) {
		return (value < 0) ? -1 : 0;
	}


	/**
	 * avoid branch.
	 * Java 中 int 类型为 32 位，而最高位为符号位，因此只要右移 31 位，得到的结果就是符号的值。
	 * @return -1 if the given value is negative,otherwise 0
	 * */
	public static int getSignNoBranch(int value){
		return value >> 31 ;
	}

	/**
	 * 这里没办法实现 Bit Twiddling Hacks 中的诸如 {@code sign = (v != 0) | (v >> (sizeof(int) * CHAR_BIT - 1)); } 这类技巧。
	 * 与很多语言不同， Java 中 true 不是 1，false 不是 0,也不能强制转换。
	 * @return -1,0,1 if the given value is negative,zero,positive
	 * */
	public static int getSign_r1(int value){
		return (value >> 31) | (value > 0 ? 1 : 0);
	}


}
