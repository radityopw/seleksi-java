package com.radityopw.seleksi;
import java.io.File;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.math.BigDecimal;

public class App {
    public static void main( String[] args ) throws Exception{
        if(args.length != 2){
		System.out.println("Argument Keliru, App <lokasi csv Tempat> <lokasi csv Peserta>");
		System.exit(1);
	}


	// variables 
	
	String csvTempat = args[0];
	String csvPeserta = args[1];
	Scanner sc = null;
	String lineSc;
	String[] splittedLineSc;

	// baca Tempat
	
	sc = new Scanner(new File(csvTempat));
	while(sc.hasNextLine()){
		lineSc = sc.nextLine();
		splittedLineSc = lineSc.split(",");
	}
	sc.close();
	sc = null;


	// baca PesertaPilihan
	sc = new Scanner(new File(csvPeserta));
	while(sc.hasNextLine()){
		lineSc = sc.nextLine();
		splittedLineSc = lineSc.split(",");
	}
	sc.close();
	sc = null;
    }
}
