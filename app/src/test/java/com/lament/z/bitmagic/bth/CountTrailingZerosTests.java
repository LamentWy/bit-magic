package com.lament.z.bitmagic.bth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountTrailingZerosTests {

	@Test
	void countLinear() {

		assertEquals(1, CountTrailingZeros.count_Linear(2));
		assertEquals(1, CountTrailingZeros.count_Linear(6));
		assertEquals(5, CountTrailingZeros.count_Linear(32));

		assertEquals(0, CountTrailingZeros.count_Linear(-1));
		assertEquals(1, CountTrailingZeros.count_Linear(-2));
		assertEquals(5, CountTrailingZeros.count_Linear(-32));

		assertEquals(32, CountTrailingZeros.count_Linear(0));


	}

	@Test
	void count_Parallel() {
		assertEquals(1, CountTrailingZeros.count_Parallel(2));
		assertEquals(1, CountTrailingZeros.count_Parallel(6));
		assertEquals(5, CountTrailingZeros.count_Parallel(32));

		assertEquals(0, CountTrailingZeros.count_Parallel(-1));
		assertEquals(1, CountTrailingZeros.count_Parallel(-2));
		assertEquals(5, CountTrailingZeros.count_Parallel(-32));
		assertEquals(32, CountTrailingZeros.count_Parallel(0));
	}
}