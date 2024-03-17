package com.github.hvalmer.converters;

public class NumberConverter {
	

	public static Double convertToDouble(String strNumber) {
		
		//verificando se esta nulo
		if(strNumber == null) return 0D;
		//BR 10,25 US 10.25
		String number = strNumber.replaceFirst(",", ".");
		//fazendo a conversao para Double
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	//verificando se é numerico...
	public static boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		//BR 10,25 US 10.25
		String number = strNumber.replaceFirst(",", ".");
		//usando uma regex para vê se bate com o valor numerico ou não...
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
}
