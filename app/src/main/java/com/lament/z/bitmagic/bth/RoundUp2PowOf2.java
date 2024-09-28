package com.lament.z.bitmagic.bth;

import java.util.HashMap;
import java.util.Map;

/**
 * Round up to the next highest power of 2
 * <p>
 * 给出一个数找到下一个最接近它的2的幂。
 *
 * 核心思路基本都是把 n 的有效二进制位全部变成1，这样再 + 1 就得到了下一个最接近它的2的幂。
 *
 * HashMap 根据你给的值计算初始化容积时涉及到的需求就跟这个差不多。
 *
 * 详见 {@link java.util.HashMap#tableSizeFor(int)}
 *
 *
 * */
public class RoundUp2PowOf2 {


	/**
	 * 数学原理：1 << (log(n-1) + 1), log 的底数为 2
	 *
	 * <p>
	 *
	 * 以 n = 15 为例： log2(15-1) = 3.8xxxx 向下取整 3
	 * 1 << (3 +1) = 16
	 * 例外是 n = 2^x 时，此时直接返回 n，公式则会返回 n * 2。
	 *
	 * 可以利用下方的 log2 方法自行验证。
	 * */
	public static int getNext(int n) {
		n--;
		n |= n >> 1;
		n |= n >> 2;
		n |= n >> 4;
		n |= n >> 8;
		n |= n >> 16;
		n++;
		return n;
	}


	/**
	 * HashMap 计算容量的方式。
	 * */
	static final int getNext_InHashMap(int cap) {
		int n = -1 >>> Integer.numberOfLeadingZeros(cap - 1);
		return (n < 0) ? 0 : n + 1;
	}

	/**
	 * 换底公式: logx(y) = loge(y)/loge(x)
	 * */
	private static double log2(double n) {
		return Math.log(n) / Math.log(2);
	}


}
