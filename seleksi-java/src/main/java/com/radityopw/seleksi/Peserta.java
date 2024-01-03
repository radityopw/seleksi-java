package com.radityopw.seleksi;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Collection;
import java.util.Iterator;

public class Peserta implements Comparable<Peserta> {

	private static final HashMap<String,Peserta> daftarPeserta = new HashMap<String,Peserta>();
	private static final PriorityQueue<Peserta> antrianProsesPeserta = new PriorityQueue<Peserta>();

	public static Peserta get(String kode) throws Exception{
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
			Peserta ps = antrianProsesPeserta.poll();
			Tempat t = Tempat.get(ps.kodeTempat());
			Peserta psDikeluarkan = t.daftarkanPeserta(ps);
			ps = null;

			if(psDikeluarkan != null){ 
				if(psDikeluarkan.masihAdaPilihanAntri()){
					antrianProsesPeserta.add(psDikeluarkan);
				}
			}

		}
	}

	public final String kode;
	private final List<Pilihan> daftarPilihan = new ArrayList<Pilihan>();
	private short pilihanAktif = 1;
	private short pilihanMax = 0;

	public Peserta(String kode){
		this.kode = kode;
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

	public void tambahPilihan(Pilihan p){
		pilihanMax++;
		daftarPilihan.add(p);
	}	

	public void diterima(){
		daftarPilihan.get(pilihanAktif - 1).status = Pilihan.DITERIMA;
	}

	public void ditolak(){
		daftarPilihan.get(pilihanAktif - 1).status = Pilihan.DITOLAK;
		pilihanAktif++;
	}
}


