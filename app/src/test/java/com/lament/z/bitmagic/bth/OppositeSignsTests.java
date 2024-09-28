package com.lament.z.bitmagic.bth;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OppositeSignsTests {

	Random random = new Random();

	int randomPos;
	int randomNeg;

	@BeforeEach
	void setUp() {
		randomPos = random.nextInt(0,Integer.MAX_VALUE);
		randomNeg = random.nextInt(0,Integer.MAX_VALUE) * -1;
	}
	@Test
	void hasOppositeSigns() {
		Assertions.assertEquals(false, OppositeSigns.hasOppositeSigns(0, 0));
		Assertions.assertEquals(true, OppositeSigns.hasOppositeSigns(randomPos, randomNeg));
		Assertions.assertEquals(false, OppositeSigns.hasOppositeSigns(randomPos, randomPos));
		Assertions.assertEquals(false, OppositeSigns.hasOppositeSigns(randomNeg, randomNeg));
	}
}