package com.radityopw.seleksi;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.Collection;

public class TempatTest{

	@Test
	public void cekTempatObject(){
		Tempat t = new Tempat("1",(short)2);
		assertEquals(t.kode,"1");
		assertEquals(t.ukuranMax,(short)2);

		Tempat t1 = new Tempat("1",(short)3);
		assertTrue(t.equals(t1));

		Tempat t2 = new Tempat("2", (short)2);
		assertFalse(t.equals(t2));
	}

	@Test
	public void cekTempatClass(){
		Tempat t = new Tempat("1",(short)2);
		
		Tempat.put("1",t);
		assertEquals(t , Tempat.get("1"));


		Tempat t1 = new Tempat("2",(short)2);
		Tempat.put("2",t1);


		Collection<Tempat> semuaTempat = Tempat.getAll();
		assertEquals(semuaTempat.size(),2);
	}

}

