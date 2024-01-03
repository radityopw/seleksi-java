package com.radityopw.seleksi;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.Collection;
import java.math.BigDecimal;

public class PilihanTest{

	@Test
	public void cekPilihanObject(){
		Pilihan p1 = new Pilihan("1",(short)2,"T1",new BigDecimal("3.14"));
		Pilihan p2 = new Pilihan("1",(short)2,"T2",new BigDecimal("3.16"));
		Pilihan p3 = new Pilihan("2",(short)1,"T1",new BigDecimal("3.10"));

		assertTrue(p1.equals(p2));
		assertFalse(p1.equals(p3));

		assertEquals(p1.compareTo(p1),0);
		assertEquals(p1.compareTo(p2),0);
		assertEquals(p1.compareTo(p3),1);
	}

}

