package com.radityopw.seleksi;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class Peserta {

	public final String kode;
	public final List<Pilihan> daftarPilihan = new ArrayList<Pilihan>();
	private short pilihanAktif = 1;
	private short pilihanMax = 0;

	public Peserta(String kode){
		this.kode = kode;
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
		if(masihAdaPilihanAntri()) return daftarPilihan.get(pilihanAktif-1).skor;
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


