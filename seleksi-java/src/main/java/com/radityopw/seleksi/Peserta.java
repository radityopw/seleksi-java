package com.radityopw.seleksi;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Collections;

public class Peserta implements Comparable<Peserta> {

	protected static HashMap<String,Peserta> daftarPeserta;
	protected static List<Peserta> antrianProsesPeserta;
	
	static{
		daftarPeserta = new HashMap<String,Peserta>();
		antrianProsesPeserta = new ArrayList<Peserta>();
	}


	public static void reset(){

		if(daftarPeserta != null){


			for(int i=0;i<daftarPeserta.size();i++){
				Peserta ps = daftarPeserta.get(i);
				if(ps != null) ps.resetPilihan();
			}

			daftarPeserta.clear();
		}else{
			daftarPeserta = new HashMap<String,Peserta>();
		}

		if(antrianProsesPeserta != null){
			antrianProsesPeserta.clear();
		}else{
			antrianProsesPeserta = new ArrayList<Peserta>();
		}
	}
	
	public static Peserta get(String kode) throws Exception{
		kode = kode.toUpperCase();
		if(!daftarPeserta.containsKey(kode)) throw new Exception("Kode "+kode+" tidak ditemukan");
		return daftarPeserta.get(kode);
	}

	public static Collection<Peserta> getAll(){
		return daftarPeserta.values();
	}

	public static void prosesDataPilihan(Pilihan pl){
		Peserta ps = daftarPeserta.get(pl.kodePeserta);
		if(ps == null){
			ps = new Peserta(pl.kodePeserta);
		}
		ps.tambahPilihan(pl);
		daftarPeserta.put(pl.kodePeserta,ps);

	}

	public static void prosesSeleksi() throws Exception{
		// isi antrian;
		antrianProsesPeserta.clear();
		
		Iterator<Peserta> daftarPesertaIterator = Peserta.getAll().iterator();
		while(daftarPesertaIterator.hasNext()){
			antrianProsesPeserta.add(daftarPesertaIterator.next());
		}
		
		// proses antrian 

		while(antrianProsesPeserta.size() > 0){
			Peserta ps = null;
			Tempat t = null;
			Peserta psDikeluarkan = null;
			
			ps = antrianProsesPeserta.remove(0);
			if(ps != null) t = Tempat.get(ps.kodeTempat());
			if(t != null) psDikeluarkan = t.daftarkanPeserta(ps);

			if(psDikeluarkan != null){ 
				if(psDikeluarkan.masihAdaPilihanAntri()){
					antrianProsesPeserta.add(psDikeluarkan);
				}
			}

		}
		
	}

	public final String kode;
	private List<Pilihan> daftarPilihan;
	private short pilihanAktif = 1;
	private short pilihanMax = 0;

	public Peserta(String kode){
		this.kode = kode.toUpperCase();
		daftarPilihan = new ArrayList<Pilihan>();
	}

	private void resetPilihan(){
		if(daftarPilihan != null){
			daftarPilihan.clear();
		}else{
			daftarPilihan = new ArrayList<Pilihan>();
		}
	}

	public boolean equals(Object o){
		if(o instanceof Peserta){
			Peserta p = (Peserta) o;
			if(this.kode.equals(p.kode)) return true;
		}
		return false;
	}

	public int compareTo(Peserta p){
		if(this.skor() == null && p.skor() !=null) return -1;
		if(p.skor() == null && this.skor() !=null) return 1;
		if(this.skor() == null && p.skor() == null) return 0;
		
		return this.skor().compareTo(p.skor());
	}

	public boolean masihAdaPilihanAntri(){
		if(pilihanAktif <= pilihanMax && pilihanAktif > 0) return true;
		return false;
	}

	public Pilihan pilihan(){
		if(masihAdaPilihanAntri()) return daftarPilihan.get(pilihanAktif-1);
		return null;
	}

	public BigDecimal skor(){
		Pilihan p = this.pilihan();
		if(p != null) return p.skor;
		return null;
	}

	public String kodeTempat(){
		Pilihan p = this.pilihan();
		if(p != null) return p.kodeTempat;
		return null;
	}

	private void tambahPilihan(Pilihan p){
		pilihanMax++;
		daftarPilihan.add(p);
		Collections.sort(daftarPilihan);
	}	

	public void diterima(){
		daftarPilihan.get(pilihanAktif - 1).status = Pilihan.DITERIMA;
	}

	public void ditolak(){
		daftarPilihan.get(pilihanAktif - 1).status = Pilihan.DITOLAK;
		pilihanAktif++;
	}

	public String toString(){
		String data = this.kode;
		data+="(";
		for(int i=0;i<daftarPilihan.size();i++){
			data+=daftarPilihan.get(i).kodeTempat+"("+daftarPilihan.get(i).skor+"),";
		}
		data+=")";
		return data;
	}
}
