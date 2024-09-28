package com.lament.z.bitmagic.bth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParityTests {

	@Test
	void isRankOdd() {
		assertEquals(false, Parity.isRankOdd(0));
		assertEquals(true, Parity.isRankOdd(1));
		assertEquals(true, Parity.isRankOdd(2));
		assertEquals(false, Parity.isRankOdd(20)); //16 + 4
		assertEquals(true, Parity.isRankOdd(22)); //16 + 4 + 2
		assertEquals(false, Parity.isRankOdd(-1));
	}

	@Test
	void isRankOdd_Multiply() {
		assertEquals(false, Parity.isRankOdd_Multiply(0));
		assertEquals(true, Parity.isRankOdd_Multiply(1));
		assertEquals(true, Parity.isRankOdd_Multiply(2));
		assertEquals(false, Parity.isRankOdd_Multiply(20)); //16 + 4
		assertEquals(true, Parity.isRankOdd_Multiply(22)); //16 + 4 + 2
		assertEquals(false, Parity.isRankOdd_Multiply(-1));
	}

	@Test
	void isRankOdd_InParallel() {
		assertEquals(false, Parity.isRankOdd_InParallel(0));
		assertEquals(true, Parity.isRankOdd_InParallel(1));
		assertEquals(true, Parity.isRankOdd_InParallel(2));
		assertEquals(false, Parity.isRankOdd_InParallel(20)); //16 + 4
		assertEquals(true, Parity.isRankOdd_InParallel(22)); //16 + 4 + 2
		assertEquals(false, Parity.isRankOdd_InParallel(-1));
	}
}