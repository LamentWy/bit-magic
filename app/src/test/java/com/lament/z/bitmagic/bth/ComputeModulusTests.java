package com.lament.z.bitmagic.bth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputeModulusTests {

	@Test
	void modulus() {
		// 1 % 4
		assertEquals(1, ComputeModulus.modulus(1, 2));
		// 2 % 2
		assertEquals(0, ComputeModulus.modulus(2, 1));
		// 10 % 4
		assertEquals(2, ComputeModulus.modulus(10, 2));
		// 9 % 8
		assertEquals(1, ComputeModulus.modulus(9, 3));

		assertThrows(IllegalArgumentException.class, () -> ComputeModulus.modulus(-7, 2));

		assertThrows(IllegalArgumentException.class, () -> ComputeModulus.modulus(3, 0));
		assertThrows(IllegalArgumentException.class, () -> ComputeModulus.modulus(3, 32));
	}
}