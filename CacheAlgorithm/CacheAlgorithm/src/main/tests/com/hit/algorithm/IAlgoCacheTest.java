package com.hit.algorithm;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IAlgoCacheTest {

	@Test
	public void LRUTest() {
		LRUAlgoCacheImpl<Integer, String> Test = new LRUAlgoCacheImpl<Integer, String>(5);
		
		Test.putElement(Integer.valueOf(1), "a");
		Test.putElement(Integer.valueOf(2), "b");
		Test.putElement(Integer.valueOf(3), "c");
		Test.putElement(Integer.valueOf(4), "d");
		Test.putElement(Integer.valueOf(5), "e");
		Test.putElement(Integer.valueOf(6), "f");
		
		assertEquals(null, Test.getElement(Integer.valueOf(1)));
		assertEquals("b", Test.putElement(Integer.valueOf(7), "g"));
		
		Test.removeElement(Integer.valueOf(3));
		assertEquals(null, Test.getElement(Integer.valueOf(3)));
		
		Test.putElement(Integer.valueOf(8), "h");
		assertEquals("d", Test.getElement(Integer.valueOf(4)));
	
		Test.putElement(Integer.valueOf(9), "i");
		Test.putElement(Integer.valueOf(10), "j");
		assertEquals(null, Test.getElement(Integer.valueOf(5)));
		assertEquals(null, Test.getElement(Integer.valueOf(6)));
		System.out.println("LRU TEST ENDED SUCCESSFULLY");
	}
	
	@Test
	public void RandomTest() {
		RandomAlgoCacheImpl<Integer,String> Test = new RandomAlgoCacheImpl<Integer,String>(5);
		
		Test.putElement(Integer.valueOf(1), "A");
		Test.putElement(Integer.valueOf(2), "B");
		Test.putElement(Integer.valueOf(3), "C");
		Test.putElement(Integer.valueOf(4), "D");
		Test.putElement(Integer.valueOf(5), "E");
		
		Test.removeElement(Integer.valueOf(1));
		assertEquals(null,Test.getElement(Integer.valueOf(1)));
	
		Test.putElement(Integer.valueOf(6),"F");
		assertTrue("BCDEF".contains((CharSequence)Test.putElement(Integer.valueOf(7), "G")));//insert G and test charSeq
		assertTrue("BCDEFG".contains((CharSequence)Test.putElement(Integer.valueOf(8), "H")));//insert H and test charSeq
		System.out.println("RANDOM TEST ENDED SUCCESSFULLY");
	}
	
	
	
	@Test
	public void NRUTest() {
		NRUAlgoCacheImpl<Integer, String> Test = new NRUAlgoCacheImpl<Integer, String>(5);
		
		Test.putElement(Integer.valueOf(1), "AVI");
		Test.putElement(Integer.valueOf(2), "BENNY");
		Test.putElement(Integer.valueOf(3), "CASEY");
		Test.putElement(Integer.valueOf(4), "DANNY");
		Test.putElement(Integer.valueOf(5), "EFRAT");
		Test.putElement(Integer.valueOf(6), "FREDY");
		
		assertEquals(null, Test.getElement(Integer.valueOf(1)));
		assertEquals("BENNY", Test.putElement(Integer.valueOf(7), "GUY"));
		
		Test.removeElement(Integer.valueOf(3));
		assertEquals(null, Test.getElement(Integer.valueOf(3)));
		
		Test.putElement(Integer.valueOf(8), "HEN");
		assertEquals("DANNY", Test.getElement(Integer.valueOf(4)));

		Test.putElement(Integer.valueOf(9), "IAN");
		Test.putElement(Integer.valueOf(10), "JHON");
		assertEquals(null, Test.getElement(Integer.valueOf(5)));
		assertEquals(null, Test.getElement(Integer.valueOf(6)));
		System.out.println("NRU TEST ENDED SUCCESSFULLY");
	}
}
