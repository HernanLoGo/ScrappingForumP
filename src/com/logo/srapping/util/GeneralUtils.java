package com.logo.srapping.util;

public class GeneralUtils {

	public void calculateTimeExecute(long startTime, long endTime) {
		long difference = endTime - startTime;
		int hora = (int) difference / 3600000;
		long restohora = difference % 3600000;
		int minuto = (int) restohora / 60000;
		long restominuto = restohora % 60000;
		int segundo = (int) restominuto / 1000;
		long restosegundo = segundo % 3600;
		System.out.println("Duración: " + hora + ":" + minuto + ":" + segundo + "." + restosegundo);
	}

}
