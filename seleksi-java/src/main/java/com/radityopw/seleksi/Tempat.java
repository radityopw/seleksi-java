package com.radityopw.seleksi;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.util.Collection;
import java.math.BigDecimal;

public class Tempat {

	private static HashMap<String,Tempat> daftarTempat;

	static{
		daftarTempat = new HashMap<String,Tempat>();
	}

	public static void reset(){
		if(daftarTempat != null){
			daftarTempat.clear();
		}else{
			daftarTempat = new HashMap<String,Tempat>();
		}
	}
	
	
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
	private final java.util.logging.Logger logger =  java.util.logging.Logger.getLogger(this.getClass().getName());

	public Tempat(String kode,short ukuranMax){
		this.kode = kode;
		this.ukuranMax = ukuranMax;
	}

	public List<Peserta> daftarPeserta(){
		return daftarPeserta;
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
			//logger.severe("Peserta salah masuk tempat");
			throw new Exception("Peserta salah masuk Tempat");
		}

		//logger.info("peserta "+p+" diproses di "+this.kode);

		Peserta pesertaDikeluarkan = null;

		daftarPeserta.add(p);
		Collections.sort(daftarPeserta);
		
		if(this.ukuranSekarang == this.ukuranMax){
			pesertaDikeluarkan = daftarPeserta.remove(0);
			pesertaDikeluarkan.ditolak();
			//logger.info("peserta "+pesertaDikeluarkan+" dikeluarkan dari "+this.kode);
		}else{
			p.diterima();
			ukuranSekarang++;
			//logger.info("peserta "+p+" diterima di "+this.kode);
		}

		this.skorMin = daftarPeserta.get(0).skor();
		return pesertaDikeluarkan;
	}
}
