package com.lament.z.bitmagic.bth;

/**
 * Swapping values with subtraction and addition
 * */
public class SwapValue {

	/**
	 * 人生中第一次面 Java 时的面试题之一。
	 * 注意 java 只有值传递, swap(a,b) 不会改变外部变量 a,b 的值。
	 * */
	public static void swap() {
		int a = 1;
		int b = -1;
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("a = " + a + ", b = " + b);
	}

	/**
	 * 这是我进入公司后老大说他实际上期待的答案是这个版本
	 * */
	public static void swap_bit(){
		int a = 1;
		int b = 2;
		a ^= b;
		b ^= a;
		a ^= b;
		System.out.println("a = " + a + ", b = " + b);
	}


}
