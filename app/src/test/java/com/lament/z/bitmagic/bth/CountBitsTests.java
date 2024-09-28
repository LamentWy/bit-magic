package com.lament.z.bitmagic.bth;

import java.util.Random;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountBitsTests {

	private static Random rand = new Random();

	@Test
	void countBits() {
		assertEquals(Integer.bitCount(0), CountBits.countBits(0));
		assertEquals(Integer.bitCount(1), CountBits.countBits(1));
		assertEquals(Integer.bitCount(2), CountBits.countBits(2));
		assertEquals(Integer.bitCount(3), CountBits.countBits(3));

		int randomPos=rand.nextInt(Integer.MAX_VALUE);
		assertEquals(Integer.bitCount(randomPos), CountBits.countBits(randomPos));
	}

	@Test
	void countBitsLookupTable() {
		assertEquals(Integer.bitCount(0), CountBits.countBitsLookupTable(0));
		assertEquals(Integer.bitCount(1), CountBits.countBitsLookupTable(1));
		assertEquals(Integer.bitCount(2), CountBits.countBitsLookupTable(2));
		assertEquals(Integer.bitCount(3), CountBits.countBitsLookupTable(3));
		int randomPos=rand.nextInt(Integer.MAX_VALUE);
		assertEquals(Integer.bitCount(randomPos), CountBits.countBits(randomPos));
	}

	@Test
	void countBitsParallel() {
		assertEquals(Integer.bitCount(0), CountBits.countBitsParallel(0));
		assertEquals(Integer.bitCount(1), CountBits.countBitsParallel(1));
		assertEquals(Integer.bitCount(2), CountBits.countBitsParallel(2));
		assertEquals(Integer.bitCount(3), CountBits.countBitsParallel(3));
		int randomPos=rand.nextInt(Integer.MAX_VALUE);
		assertEquals(Integer.bitCount(randomPos), CountBits.countBitsParallel(randomPos));
	}

	@Test
	void countBitsParallelV2() {
		assertEquals(Integer.bitCount(0), CountBits.countBitsParallelV2(0));
		assertEquals(Integer.bitCount(1), CountBits.countBitsParallelV2(1));
		assertEquals(Integer.bitCount(2), CountBits.countBitsParallelV2(2));
		assertEquals(Integer.bitCount(3), CountBits.countBitsParallelV2(3));
		assertEquals(Integer.bitCount(1272142798), CountBits.countBitsParallelV2(1272142798));
		int randomPos=rand.nextInt(Integer.MAX_VALUE);
		System.out.println(randomPos);
		assertEquals(Integer.bitCount(randomPos), CountBits.countBitsParallelV2(randomPos));
	}


}