package com.lament.z.bitmagic.bth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseBitsTests {

	@Test
	void reverseBits() {
		int n = 2;                 // 0000 0000 0000 0000 0000 0000 0000 0010
		int expected = 1073741824; // 0100 0000 0000 0000 0000 0000	0000 0000
		assertEquals(expected, ReverseBits.reverseBits(n));

		assertEquals(0,ReverseBits.reverseBits(0));
	}
}