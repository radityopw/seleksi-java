package com.radityopw.seleksi;
import java.math.BigDecimal;


public class Pilihan implements Comparable<Pilihan> {

	public static final short ANTRI = 0;
	public static final short DITERIMA = 1;
	public static final short DITOLAK = 3;

	public final String kodeTempat;
	public final short pilihanKe;
	public final BigDecimal skor;
	public short status = Pilihan.ANTRI;
	public final String kodePeserta;
	public final String kode;

	public Pilihan(String kodePeserta, short pilihanKe,String kodeTempat, BigDecimal skor){
		this.kodePeserta = kodePeserta;
		this.pilihanKe = pilihanKe;
		this.kodeTempat = kodeTempat;
		this.skor = skor;
		this.kode = this.kodePeserta+"-"+this.pilihanKe;
	}

	public boolean equals(Object o){
		if(o instanceof Pilihan){
			Pilihan p = (Pilihan)o;
			if(this.kode.equals(p.kode)) return true;
		}
		return false;
	}
	
	public int compareTo(Pilihan p){
		if(this.pilihanKe > p.pilihanKe) return 1;
		if(this.pilihanKe < p.pilihanKe) return -1;
		return 0;
	}


}
