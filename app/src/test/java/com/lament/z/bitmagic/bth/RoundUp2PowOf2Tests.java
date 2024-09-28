package com.lament.z.bitmagic.bth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoundUp2PowOf2Tests {

	@Test
	void getNext() {
		assertEquals(16, RoundUp2PowOf2.getNext(15));
	}

	@Test
	void getNext_InHashMap() {
		assertEquals(16, RoundUp2PowOf2.getNext(15));
		assertEquals(16, RoundUp2PowOf2.getNext(16));
	}
}