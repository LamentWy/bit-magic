package com.lament.z.bitmagic.bth;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SignOfIntegerTests {

	Random random = new Random();

	int randomPos;
	int randomNeg;

	@BeforeEach
	void setUp() {
		randomPos = random.nextInt(0,Integer.MAX_VALUE);
		randomNeg =-randomPos;
	}

	@Test
	void getSign() {
		Assertions.assertEquals(0, SignOfInteger.getSign(Integer.MAX_VALUE));
		Assertions.assertEquals(-1, SignOfInteger.getSign(Integer.MIN_VALUE));
		Assertions.assertEquals(0, SignOfInteger.getSign(randomPos));
		Assertions.assertEquals(-1, SignOfInteger.getSign(randomNeg));
		Assertions.assertEquals(0, SignOfInteger.getSign(0));
	}

	@Test
	void getSignNoBrach() {
		Assertions.assertEquals(0, SignOfInteger.getSignNoBranch(Integer.MAX_VALUE));
		Assertions.assertEquals(-1, SignOfInteger.getSignNoBranch(Integer.MIN_VALUE));
		Assertions.assertEquals(0, SignOfInteger.getSignNoBranch(randomPos));
		Assertions.assertEquals(-1, SignOfInteger.getSignNoBranch(randomNeg));
		Assertions.assertEquals(0, SignOfInteger.getSignNoBranch(0));
	}

	@Test
	void getSign_r1() {
		Assertions.assertEquals(1, SignOfInteger.getSign_r1(Integer.MAX_VALUE));
		Assertions.assertEquals(-1, SignOfInteger.getSign_r1(Integer.MIN_VALUE));
		Assertions.assertEquals(1, SignOfInteger.getSign_r1(randomPos));
		Assertions.assertEquals(-1, SignOfInteger.getSign_r1(randomNeg));
		Assertions.assertEquals(0, SignOfInteger.getSign_r1(0));
	}
}