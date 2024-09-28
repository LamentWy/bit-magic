package com.lament.z.bitmagic.bth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DetermineByteInWordTests {

	@Test
	void hasZero() {
		assertEquals(true, DetermineByteInWord.hasZero(0));
		assertEquals(true, DetermineByteInWord.hasZero(1));
		assertEquals(true, DetermineByteInWord.hasZero(2));
		assertEquals(false, DetermineByteInWord.hasZero((1<<31) -1));
		assertEquals(false, DetermineByteInWord.hasZero(-1));
		assertEquals(true, DetermineByteInWord.hasZero(1 << 8));

	}

	@Test
	void hasZero_v2() {
		assertEquals(true, DetermineByteInWord.hasZero(0));
		assertEquals(true, DetermineByteInWord.hasZero(1));
		assertEquals(true, DetermineByteInWord.hasZero(2));
		assertEquals(false, DetermineByteInWord.hasZero((1<<31) -1));
		assertEquals(false, DetermineByteInWord.hasZero(-1));
		assertEquals(true, DetermineByteInWord.hasZero(1 << 8));
	}

	@Test
	void hasX() {
		assertEquals(true, DetermineByteInWord.hasX(315,(byte) ';'));
	}
}