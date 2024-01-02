package com.radityopw.seleksi;
import java.math.BigDecimal;

public class Pilihan {

	public static final short ANTRI = 0;
	public static final short DITERIMA = 1;
	public static final short DITOLAK = 3;

	public Tempat tempat;
	public short pilihanKe;
	public BigDecimal skor;
	public short status = Pilihan.ANTRI;
	public Peserta peserta;

}
