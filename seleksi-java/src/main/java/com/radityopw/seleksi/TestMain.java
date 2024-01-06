package com.radityopw.seleksi;

import java.util.*;
import java.math.*;
public class TestMain{

	public static void main(String[] a){
		Tempat.reset();
		Peserta.reset();


		Tempat t1 = new Tempat("K1",(short)1);
		Tempat t2 = new Tempat("K2",(short)2);
		Tempat t3 = new Tempat("K3",(short)1);
		Tempat.put(t1.kode,t1);
		Tempat.put(t2.kode,t2);
		Tempat.put(t3.kode,t3);
		
		Pilihan pl1 = new Pilihan("P1",(short)1,"K1", new BigDecimal("3.1"));
		Pilihan pl2 = new Pilihan("P1",(short)2,"K2", new BigDecimal("3.1"));
		Pilihan pl3 = new Pilihan("P1",(short)3,"K3", new BigDecimal("3.1"));
		Pilihan pl4 = new Pilihan("P2",(short)1,"K1", new BigDecimal("3.2"));
		Pilihan pl5 = new Pilihan("P2",(short)2,"K3", new BigDecimal("3.2"));
		Pilihan pl6 = new Pilihan("P3",(short)1,"K1", new BigDecimal("3.3"));
		Pilihan pl7 = new Pilihan("P4",(short)1,"K2", new BigDecimal("3.4"));
		Pilihan pl8 = new Pilihan("P5",(short)1,"K3", new BigDecimal("3.5"));
		Pilihan pl9 = new Pilihan("P6",(short)1,"K1", new BigDecimal("3.6"));
		Pilihan pl10 = new Pilihan("P7",(short)1,"K2", new BigDecimal("3.7"));
		Pilihan pl11 = new Pilihan("P8",(short)1,"K3", new BigDecimal("3.8"));
		Pilihan pl12 = new Pilihan("P9",(short)1,"K1", new BigDecimal("3.9"));
		Pilihan pl13 = new Pilihan("P9",(short)2,"K2", new BigDecimal("3.9"));

		Peserta.prosesDataPilihan(pl1);
		Peserta.prosesDataPilihan(pl2);
		Peserta.prosesDataPilihan(pl3);
		Peserta.prosesDataPilihan(pl4);
		Peserta.prosesDataPilihan(pl5);
		Peserta.prosesDataPilihan(pl6);
		Peserta.prosesDataPilihan(pl7);
		Peserta.prosesDataPilihan(pl8);
		Peserta.prosesDataPilihan(pl9);
		Peserta.prosesDataPilihan(pl10);
		Peserta.prosesDataPilihan(pl11);
		Peserta.prosesDataPilihan(pl12);
		Peserta.prosesDataPilihan(pl13);

		try{
			Peserta.prosesSeleksi();
			List<Peserta> pt1 = t1.daftarPeserta();
			List<Peserta> pt2 = t2.daftarPeserta();
			List<Peserta> pt3 = t3.daftarPeserta();

			System.out.println();
			System.out.println(t1.kode);
			System.out.println("--------");
			for(int i=0;i<pt1.size();i++){
				Peserta ps = pt1.get(i);
				System.out.print(ps+",");
			}
			
			System.out.println();
			System.out.println(t2.kode);
			System.out.println("--------");
			for(int i=0;i<pt2.size();i++){
				Peserta ps = pt2.get(i);
				System.out.print(ps+",");
			}

			System.out.println();
			System.out.println(t3.kode);
			System.out.println("--------");
			for(int i=0;i<pt3.size();i++){
				Peserta ps = pt3.get(i);
				System.out.print(ps+",");
			}

			
			System.out.println();

		}catch(Exception e){
			System.out.println(e);
		}
	}
}
