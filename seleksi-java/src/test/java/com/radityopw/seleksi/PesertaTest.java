package com.radityopw.seleksi;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.Collection;
import java.math.BigDecimal;

public class PesertaTest{

	@Test
	public void cekPesertaObject(){
		Peserta p1 = new Peserta("K1");
		Peserta p2 = new Peserta("K1");
		Peserta p3 = new Peserta("K3");

		assertTrue(p1.equals(p2));
		assertFalse(p1.equals(p3));

		assertEquals(p1.skor(),null);
		assertEquals(p1.pilihan(),null);
		assertEquals(p1.kodeTempat(),null);

		assertFalse(p1.masihAdaPilihanAntri());
			
	}

	@Test
	public void cekPesertaClass(){
		Pilihan p1 = new Pilihan("P1",(short)1,"K1", new BigDecimal("3.14"));
		Pilihan p2 = new Pilihan("P1",(short)2,"K2", new BigDecimal("3.9"));
		Pilihan p3 = new Pilihan("P1",(short)3,"K3", new BigDecimal("3.8"));
		Pilihan p4 = new Pilihan("P2",(short)1,"K1", new BigDecimal("3.8"));
		Pilihan p5 = new Pilihan("P2",(short)2,"K3", new BigDecimal("3.8"));

		Peserta.prosesDataPilihan(p2);
		Peserta.prosesDataPilihan(p1);
		Peserta.prosesDataPilihan(p3);
		Peserta.prosesDataPilihan(p4);
		Peserta.prosesDataPilihan(p5);

		try{
			assertEquals(Peserta.get("P1").kode,"P1");
			assertEquals(Peserta.get("P2").kode,"P2");
		}catch(Exception e){
			assertTrue(false);
		}

		try{
			Peserta.get("P3");
			assertTrue(false);
		}catch(Exception e){
			assertTrue(true);
		}

		Collection<Peserta> daftarPeserta = Peserta.getAll();
		assertEquals(daftarPeserta.size(),2);
		
		try{
			Peserta ps1 = Peserta.get("P1");
			assertEquals(ps1.skor(),new BigDecimal("3.14"));
			assertEquals(ps1.pilihan(),p1);
			assertEquals(ps1.kodeTempat(),"K1");

			assertTrue(ps1.masihAdaPilihanAntri());

			Peserta ps2 = Peserta.get("P2");

			assertEquals(ps1.compareTo(ps2),-1);

			ps1.diterima();

			assertEquals(ps1.compareTo(ps2),-1);
			
			ps1.ditolak();

			assertEquals(ps1.compareTo(ps2),1);

			ps1.ditolak();
			
			assertEquals(ps1.compareTo(ps2),0);

		}catch(Exception e){
			
			assertTrue(false);

		}


	}

}

