package com.lament.z.bitmagic.bth;

/**
 * Compute modulus division by 1 << s without a division operator
 * 这个还挺常见的，就是不用除法对 2 的幂取模
 *
 * 其余几个跳过。
 * */
public class ComputeModulus {

	/**
	 * 这里默认 n >= 0 因为负数取模在不同语言中处理方式不一样。
	 *  例子见下方的 demo() 方法。
	 * @param n the number to be divided
	 * @param s 2^s
	 * */
	public static int modulus(int n, int s) {
		if (s <=0 || s > 31){
			throw new IllegalArgumentException("s should be in the range [1, 31]");
		}
		if (n < 0){
			throw new IllegalArgumentException("n should be greater than zero");
		}

		int powOf2 = 1 << s;
		return n & (powOf2- 1);
	}

	/**
	 * 关于负数取模的简单说明：
	 * 基本公式为: a = b * q + r, a 是被除数，b 是除数，q 是商，r 是余数。
	 * 变化一下就是 r = a - b*q。
	 *
	 * 之所以 r 会不一样，就是因为 q 不一样，毕竟 a、b 是给定的值。
	 * q 之所以会不一样是因为负数除法涉及到取整，取整方式不一样，q 自然也不一样。 ceiling 向上取整，floor 向下取整,truncate 向 0 取整。
	 *
	 * ComputeModulus.modulus() 与 python 3 中的结果一致，按位取模相当于 floor 的方式，也就是向下取整。
	 * -7/8 = -0.875,向下取整为 -1，也就是 q = -7//8 = -1, b=8, a=-7, 因此, r = a - n*q = -7 - 8*(-1) = 1
	 *
	 * 而 Java 是 truncate 的方式，也就是向 0 取整，
	 * 也就是 q = -7/8 = 0, n=8, a=-7, 因此, r = a - n*q = -7 -  8 * 0 = -7
	 *
	 * 运行 demo() 前先注释掉异常检测。
	 * */
	public static void demo() {
		System.out.println("Java: -7 % 8 = " + (-7 % 8)); // -7
		System.out.println("ComputeModulus.modulus(-7, 3) = " + modulus(-7, 3)); // 1
	}


}
