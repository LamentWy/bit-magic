package com.lament.z.bitmagic.bth;

/**
 * Counting bits set
 * */
public class CountBits {


	/**
	 * loop
	 * */
	public static int countBits(int n) {
		assert n >= 0;
		int count = 0;
		while (n != 0) {
			count += n & 1;
			n >>= 1;
		}
		return count;
	}

	/**
	 *  查表法
	 * */
	private static int[] table256 = createTable();
	private static int[] createTable() {
		int[] table256 = new int[256];
		table256[0] = 0;
		for (int i = 0; i < 256; i++) {
			table256[i] = (i & 1) + table256[i >> 1];
		}
		return table256;
	}
	public static int countBitsLookupTable(int n) {

		return table256[n & 0xff] +
				table256[(n >> 8) & 0xff] +
				table256[(n >> 16) & 0xff] +
				table256[(n >> 24)];
	}

	/**
	 * Counting bits set, in parallel
	 * countBitsParallel() 就是 Integer.bitCount() 方法的实现原理，和后面的 countBitsParallelV2 一样，他们都是前者的变体。
	 * 不过仍然是看看就好，毕竟 Integer.bitCount() 也有 @IntrinsicCandidate 注解。
	 * <p>
	 * 这些魔数可以眼熟一下: <br/>
	 * 0x55555555 = 01010101 01010101 01010101 01010101
	 * 0x33333333 = 00110011 00110011 00110011 00110011
	 * 0x0F0F0F0F = 00001111 00001111 00001111 00001111
	 * 0x00FF00FF = 00000000 11111111 00000000 11111111
	 * 0x0000FFFF = 00000000 00000000 11111111 11111111
	 *
	 * 0x01010101 = 00000001 00000001 00000001 00000001
	 * 0x0000003F = 00000000 00000000 00000000 00111111
	 *
	 * 注意 Mask1 和 Mask2 是 一一对应的，Mask2 的最后一个元素除外，这个元素就跟 Integer.bitCount() 里的 0x3F 一个性质。
	 * */
	private static final int[] MASK1 = {1,2,4,8,16};
	private static final int[] MASK2 = {
			0x55555555, //0
			0x33333333, //1
			0x0F0F0F0F, //2
			0x00FF00FF, //3
			0x0000FFFF, //4
			0x01010101  //5
	};

	// base
	public static int countBitsParallel(int n) {
		int count;

		count = n - ((n >> MASK1[0]) & MASK2[0]);
		count = ((count >> MASK1[1]) & MASK2[1]) + (count & MASK2[1]);
		count = ((count >> MASK1[2]) + count) & MASK2[2];
		count = ((count >> MASK1[3]) + count) & MASK2[3];
		count = ((count >> MASK1[4]) + count) & MASK2[4];

		return count;
	}
	// variation
	public static int countBitsParallelV2(int n) {
		int count = 0;
		n = n - ((n >> 1) & MASK2[0]);
		n = (n & MASK2[1]) + ((n >> 2) & MASK2[1]);
		count = ((n + (n >> 4) & MASK2[2]) * MASK2[5]) >> 24;
		return count;
	 }


}
