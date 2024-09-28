package com.lament.z.bitmagic.bth;

/**
 * Detect if two integers have opposite signs.
 * */
public class OppositeSigns {


	/**
	 * 这个技巧的本质就是在给 a b 两个值的符号位做异或运算，如果异或结果为负数，则说明 a b 符号不同，否则相同。
	 *
	 * @return true if a and b have opposite signs, false otherwise.
	 * */
	public static boolean hasOppositeSigns(int a, int b) {
		return (a^b) < 0;
	}
}
