package com.radityopw.seleksi;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.util.Collection;
import java.math.BigDecimal;

public class Tempat {

	private static final HashMap<String,Tempat> daftarTempat = new HashMap<String,Tempat>();

	public static Tempat get(String kode){
		return daftarTempat.get(kode);
	}

	public static void put(String kode,Tempat t){
		daftarTempat.put(kode,t);
	}

	public static Collection<Tempat> getAll(){
		return daftarTempat.values();
	}

	public final String kode;
	public final int ukuranMax;
	private int ukuranSekarang = 0;
	private BigDecimal skorMin;
	private final List<Peserta> daftarPeserta = new ArrayList<Peserta>();


	public Tempat(String kode,short ukuranMax){
		this.kode = kode;
		this.ukuranMax = ukuranMax;
	}

	public boolean equals(Object o){
		if(o instanceof Tempat){
			Tempat t = (Tempat) o;
			if(this.kode == t.kode) return true;
		}
		return false;
	}

	public Peserta daftarkanPeserta(Peserta p) throws Exception {
		if(!p.kodeTempat().equals(this.kode)){
			throw new Exception("Peserta salah masuk Tempat");
		}

		Peserta pesertaDikeluarkan = null;

		daftarPeserta.add(p);
		Collections.sort(daftarPeserta);
		
		if(this.ukuranSekarang == this.ukuranMax){
			pesertaDikeluarkan = daftarPeserta.remove(0);
			pesertaDikeluarkan.ditolak();
		}else{
			p.diterima();
			ukuranSekarang++;
		}

		this.skorMin = daftarPeserta.get(0).skor();
		return pesertaDikeluarkan;
	}
}
