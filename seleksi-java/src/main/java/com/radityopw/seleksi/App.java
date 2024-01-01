package com.radityopw.seleksi;

public class App {
    public static void main( String[] args ){
        if(args.length != 2){
		System.out.println("Argument Keliru, App <lokasi csv Tempat> <lokasi csv Peserta>");
		System.exit(1);
	}

	String csvTempat = args[0];
	String csvPeserta = args[1];
    }
}
