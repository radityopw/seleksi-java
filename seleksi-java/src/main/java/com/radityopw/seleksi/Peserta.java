package com.radityopw.seleksi;
import java.util.ArrayList;
import java.util.List;

public class Peserta {

	public String kode;
	public List<Pilihan> daftarPilihan = new ArrayList<Pilihan>();
	public short pilihanAktif = 1;
	public short pilihanMax = 1;

	public boolean hasPilihan(){
		if(pilihanAktif <= pilihanMax) return true;
		return false;
	}

	public Pilihan pilihan(){
		if(hasPilihan()) return daftarPilihan.get(pilihanAktif-1);
		return null;
	}
}


