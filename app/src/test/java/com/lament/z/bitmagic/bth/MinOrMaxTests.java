package com.lament.z.bitmagic.bth;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinOrMaxTests {


	@Test
	void min() {
		Assertions.assertEquals(1, MinOrMax.min(1, 2));
		Assertions.assertEquals(2, MinOrMax.min(2, 2));
		Assertions.assertEquals(0, MinOrMax.min(2, 0));
		Assertions.assertEquals(-1, MinOrMax.min(-1, 0));
		Assertions.assertEquals(-1, MinOrMax.min(-1, 1));
		Assertions.assertEquals(-2, MinOrMax.min(-2, -1));

		// this will cause overflow if not using long
		Assertions.assertEquals(-1479782479, MinOrMax.min( -1479782479, 827810539));

		Random random = new Random();

		int randomPos = random.nextInt(0,Integer.MAX_VALUE);
		int randomNeg = random.nextInt(0,Integer.MAX_VALUE) * -1;
		System.out.println("Random positive: " + randomPos);
		System.out.println("Random negative: " + randomNeg);
		Assertions.assertEquals(randomNeg, MinOrMax.min(randomPos, randomNeg));

		Assertions.assertEquals(Integer.MIN_VALUE, MinOrMax.min(Integer.MAX_VALUE, Integer.MIN_VALUE));
	}

	@Test
	void max() {
		Assertions.assertEquals(2,MinOrMax.max(1, 2));
		Random random = new Random();

		int randomPos = random.nextInt(0,Integer.MAX_VALUE);
		int randomNeg = random.nextInt(0,Integer.MAX_VALUE) * -1;

		Assertions.assertEquals(randomPos, MinOrMax.max(randomPos, randomNeg));
	}
}