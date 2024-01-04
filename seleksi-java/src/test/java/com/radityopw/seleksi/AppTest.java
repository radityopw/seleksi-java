package com.radityopw.seleksi;

import static org.junit.Assert.*;

import org.junit.*;

import java.util.List;

import java.math.BigDecimal;

public class AppTest{
	@Test
	public void cekSeleksi(){
		
		
		Tempat t1 = new Tempat("K1",(short)1);
		Tempat t2 = new Tempat("K2",(short)2);
		Tempat t3 = new Tempat("K3",(short)1);
		
		
		Pilihan p1 = new Pilihan("P1",(short)1,"K1", new BigDecimal("3.1"));
		Pilihan p2 = new Pilihan("P1",(short)2,"K2", new BigDecimal("3.1"));
		Pilihan p3 = new Pilihan("P1",(short)3,"K3", new BigDecimal("3.1"));
		Pilihan p4 = new Pilihan("P2",(short)1,"K1", new BigDecimal("3.2"));
		Pilihan p5 = new Pilihan("P2",(short)2,"K3", new BigDecimal("3.2"));
		Pilihan p6 = new Pilihan("P3",(short)1,"K1", new BigDecimal("3.3"));
		Pilihan p7 = new Pilihan("P4",(short)1,"K2", new BigDecimal("3.4"));
		Pilihan p8 = new Pilihan("P5",(short)1,"K3", new BigDecimal("3.5"));
		Pilihan p9 = new Pilihan("P6",(short)1,"K1", new BigDecimal("3.6"));
		Pilihan p10 = new Pilihan("P7",(short)1,"K2", new BigDecimal("3.7"));
		Pilihan p11 = new Pilihan("P8",(short)1,"K3", new BigDecimal("3.8"));
		Pilihan p12 = new Pilihan("P9",(short)1,"K1", new BigDecimal("3.9"));
		Pilihan p13 = new Pilihan("P9",(short)2,"K2", new BigDecimal("3.9"));

		Peserta.prosesDataPilihan(p1);
		Peserta.prosesDataPilihan(p2);
		Peserta.prosesDataPilihan(p3);
		Peserta.prosesDataPilihan(p4);
		Peserta.prosesDataPilihan(p5);
		Peserta.prosesDataPilihan(p6);
		Peserta.prosesDataPilihan(p7);
		Peserta.prosesDataPilihan(p8);
		Peserta.prosesDataPilihan(p9);
		Peserta.prosesDataPilihan(p10);
		Peserta.prosesDataPilihan(p11);
		Peserta.prosesDataPilihan(p12);
		Peserta.prosesDataPilihan(p13);

		try{
			Peserta.prosesSeleksi();
			List<Peserta> pt1 = t1.daftarPeserta();
			
			//assertEquals(Peserta.get("P9").kode,"P9");
			assertEquals(pt1.get(0),Peserta.get("P9"));
		}catch(Exception e){
			assertEquals("",e.toString());
		}

			
	}
}
