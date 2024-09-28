package com.lament.z.bitmagic.bth;
/**
 *  Determine if a word has a some specific byte
 * */
public class DetermineByteInWord {

	/**
	 * Determine if a word has a zero byte (0000 0000， 8 bits)
	 * */
	public static boolean hasZero(int n) {
		// 0x7F7F7F7F
		// 01111111 01111111 01111111 01111111
		n = ~((((n & 0x7F7F7F7F) + 0x7F7F7F7F) | n) | 0x7F7F7F7F);
		return n != 0;
	}

	//  0x01010101 = 00000001 00000001 00000001 00000001
	// -0x01010101 = 11111110 11111110 11111110 11111111
	//  0x80808080 = 10000000 10000000 10000000 10000000

	/**
	 * 只要 n 中对应的 8 bits 位的值等于0，或者大于 0x80，
	 * 那么 n - 0x01010101 的结果就一定会设置高位
	 * 而 ~n & 0x80808080 这是给 0～0x80 之间的值设置高位
	 * 二者 & 之后，后者的结果可以屏蔽前者结果中大于 0x80 的高位。
	 * 因此也就只返回 0 的高位，所以这个值不为 0，就意味着 n 中对应位有 8bits 的 0。
	 * */
	public static boolean hasZero_v2(int n) {
		n = (n - 0x01010101) & ~n & 0x80808080;
		System.out.println("n = " + Integer.toBinaryString(n));
		return n != 0;
	}

	/**
	 * Determine if n has a byte equal to byte x
	 *
	 * 0x01010101 = 0xFFFFFFFFFFFFFFFF / 0xFF (255)
	 *
	 * 这个方案很有意思， a ^ a = 0，所以可以用 ^ 来判断是否相等。
	 * ((int) x * 0x01010101) 就是不断重复 x ，直到与 n 位数对齐。
	 *
	 * 这样如果 n 中包含任意一个 x，那么 n ^ ((int) x * 0x01010101); 的结果中至少有一个 8bits 的 0。
	 *
	 * 此时你把这个值传入 hasZero() 即可判断是否有 x。
	 *
	 * 以测试中使用的数据为例，n = 315 = 256+59, byte x = 59 = ';'
	 *
	 * n = 315 = 0000 0000 0000 0000 0000 0001 0011 1011
	 * x =  59 = 0000 0000 0000 0000 0000 0000 0011 1011
	 * t = 59 * 0x01010101 = 00111011 00111011 00111011 00111011
	 *
	 * n ^ t = 00111011 00111011 00111010 00000000
	 * 最右的 8bits 全为 0，说明 n 中包含 x。
	 *
	 * hasZero(n) / hasZero_v2(n) 都可以用在这里。
	 * */
	public static boolean hasX(int n, byte x) {

		n = n ^ ((int) x * 0x01010101);

		return hasZero_v2(n);

	}

	// 其他比大小和区间的跳过

}
