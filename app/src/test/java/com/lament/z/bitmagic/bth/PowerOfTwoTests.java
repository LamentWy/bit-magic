package com.lament.z.bitmagic.bth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerOfTwoTests {

	@Test
	void isPowerOfTwo() {
		assertTrue(PowerOfTwo.isPowerOfTwo(1024));
		assertTrue(PowerOfTwo.isPowerOfTwo(1));
		assertFalse(PowerOfTwo.isPowerOfTwo(-2));

		// 特例。理论上 0 不是 2 的幂
		assertTrue(PowerOfTwo.isPowerOfTwo(0));
	}

	@Test
	void isPowerOfTwoCutZero() {
		assertTrue(PowerOfTwo.isPowerOfTwoCutZero(1024));
		assertTrue(PowerOfTwo.isPowerOfTwoCutZero(1));
		assertFalse(PowerOfTwo.isPowerOfTwoCutZero(-2));

		assertFalse(PowerOfTwo.isPowerOfTwoCutZero(0));
	}
}