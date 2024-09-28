package com.lament.z.bitmagic.bth;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ABSValueTests {

	@Test
	void abs() {

		Assertions.assertEquals(0, ABSValue.abs(0));
		Assertions.assertEquals(1, ABSValue.abs(1));
		Assertions.assertEquals(1, ABSValue.abs(-1));
		Assertions.assertEquals(2, ABSValue.abs(-2));
	}
}