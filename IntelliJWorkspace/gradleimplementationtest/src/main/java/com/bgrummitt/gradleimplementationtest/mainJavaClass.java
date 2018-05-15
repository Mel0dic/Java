package com.bgrummitt.gradleimplementationtest;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;

public class mainJavaClass {

	public static void main(String[] args){
		try {
			CSVPrinter printer = new CSVPrinter(System.out, CSVFormat.EXCEL);
			printer.printRecord("Anon", 3, "Never Again");
			printer.printRecord("Anon", 1, "Was sick, would not visit");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
