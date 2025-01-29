package calculadora;

public class IsidroMartinPruebaCalculadoraBases {

	
	/**
	 * Numero de decimales a sacar
	 */
	private static final int decimales = 4;
	
	/**
	 * Metodo que devuelve la parte entera de un numero almacenado en string separado por punto
	 * @param input String del que queremos coger la parte entera
	 * @return String con la parte entera del numero, si no existe, devuelve 0
	 */
	private static String numeroEntero(String input) {
		String result	= "";
		int punto		= (input.lastIndexOf('.') == -1) ? input.length() : input.lastIndexOf('.');
		
			for(int i = 0; i < punto; i++) {
				result += input.charAt(i);
			}
			
		return result;
	}
	
	/**
	 * Metodo que devuelve la parte decimal de un numero almacenado en string separado por punto
	 * @param input String del que queremos coger la parte entera
	 * @return String con la parte decimal del numero, si no existe, devuelve 0
	 */
	private static String numeroDecimal(String input) {
		String result	= "";
		int punto		= input.lastIndexOf('.');
		
		if(punto != -1) {
			for(int i = punto+1; i < input.length(); i++) {
				result += input.charAt(i);
			}
		} else {
			result = "0";
		}
			
			
		return result;
	}
	
	/**
	 * Metodo que convierte un numero positivo dentro de un string en la base indicada a una base nueva
	 * @param numero String que contiene el numero positivo
	 * @param baseActual Base en la que se encuentra el número
	 * @param baseNueva Base a la que queremos pasar el numero
	 * @return String con el numero en la nueva base o "null" si no es posible realizarlo o hay algún error
	 */
	public static String numberConversion(String numero, int baseActual, int baseNueva) {
		String parteEntera 		= "null";
		String parteDecimal		= "null";
		String result			= numero;
		
		if(isCorrect(numero, baseActual)) {
			//Utilizo la base decimal como intermediario
			if (baseNueva != 10 && baseActual != 10)
				result = numberConversion(numero, baseActual, 10);
			
			parteEntera 	= numeroEntero(result);
			parteDecimal	= numeroDecimal(result);
			
			if(baseNueva == 10){
				//pasar de baseActual a base 10
				parteEntera 	= intConversionEnteroBase10(parteEntera, baseActual);
				if (parteDecimal.equals("0") == false)
					parteDecimal 	= intConversionDecimalBase10(parteDecimal, baseActual, decimales);
			} else {
				//pasar de base 10 a baseNueva
				parteEntera 	= intConversionEnteroBaseX(parteEntera, baseNueva);
				if (parteDecimal.equals("0") == false)
					parteDecimal 	= intConversionDecimalBaseX(parteDecimal, baseNueva, decimales);
			}
			
			if(parteDecimal.equals("0") == false)
				result = parteEntera + '.' + parteDecimal;
			else
				result = parteEntera;
		} else
			result = "null";
		
		return result;
	}
	
	/**
	 * Funcion que convierte un string con un numero positivo en base 10 a int
	 * @param input String a convertir
	 * @return int con el valor del String. Si es un numero no valido devuelve -1
	 */
	private static int stringConversionBase10(String input) {
		int result 		= 0;
		
		if(isCorrect(input, 10) == true) {
			for(int i = 0; i < input.length(); i++) {
				//Si hay un numero mas lo pasamos una cifra
				result *= 10;
				
				result += intConversion(input.charAt(i));
			}
		} else
			result = -1;
		
		
		
		return result;
	}
	
	/**
	 * Funcion que invierte los caracteres de un string
	 * @param input String a invertir
	 * @return String con los caracteres invertidos
	 */
	private static String inverseString(String input) {
		String result 	= "";
		
		for(int i = input.length()-1; i >= 0; i--) {
			result += input.charAt(i);
		}
		
		return result;
	}
	
	/**
	 * Función que devuelve la parte entera de un String con un numero en base 10 a la base especificada
	 * @param input String con un numero en base 10
	 * @param base Base a la que deseamos convertir
	 * @return String con el numero en la nueva base
	 */
	private static String intConversionEnteroBaseX(String input, int base) {
		String resultado	= "";
		int cociente 		= stringConversionBase10(input);
		
		do {
			resultado += stringConversion(cociente % base);
			cociente = cociente / base;
		} while (cociente >= base);
		
		//Le añadimos el ultimo resultado
		resultado += stringConversion(cociente);

		
		return inverseString(resultado);
	}
	
	/**
	 * Función que devuelve la parte decimal de un String con un numero en base 10 a la base especificada
	 * @param input String con un numero en base 10
	 * @param base Base a la que deseamos convertir
	 * @return String con el numero en la nueva base
	 */
	private static String intConversionDecimalBaseX(String input, int base, int decimal) {
		String resultado	= "";
		boolean exact 		= false;
		boolean hasDecimal	= false;
		double resultDouble = stringConversionBase10(input);
		
		resultDouble = resultDouble / exponent(10, input.length());
		
		for(int i = 0; i < decimal && exact == false; i++) {
			hasDecimal 		= numeroDecimal(Double.toString(resultDouble)).equals("0") == false;
			resultDouble 	= resultDouble * base;
			resultado 		+= stringConversion(stringConversionBase10(numeroEntero(Double.toString(resultDouble))));
			
			if(resultDouble >= 1) {
				resultDouble -= stringConversionBase10(numeroEntero(Double.toString(resultDouble)));
			}
			if (hasDecimal == false)
				exact = true;
		}
		
		
		return resultado;
	}
	
	/**
	 * Conversion del numero entero en un string a base 10. Esta clase asume que le introduces un string y base correctas
	 * @param input string con el número a transformar
	 * @param base base del numero a pasar a decimal
	 * @return numero entero en un String en decimal
	 */
	private static String intConversionEnteroBase10(String input, int base) {
		String resultado	= "";
		int result 			= 0;
		int j				= 0;
		
		while(j < input.length()) {
			for(int i = input.length()-1; i >= 0; i--) {
				result += intConversion(input.charAt(j)) * exponent(base, i);
				j++;
			}
		}
	
		resultado = Integer.toString(result);
		
		return resultado;
	}
	
	/**
	 * Conversion del numero decimal en un string a base 10. Esta clase asume que le introduces un string y base correctas
	 * @param input string con el número a transformar
	 * @param base base del numero a pasar a decimal
	 * @param decimal numeros decimales a sacar
	 * @return numero decimal en un String en decimal
	 */
	public static String intConversionDecimalBase10(String input, int base, int decimal) {
		String resultado	= "";
		double inter 		= 0;
		int j				= 0;
		
		while(j < input.length()) {
			for(int i = -1; i >= -input.length(); i--) {
				inter += intConversion(input.charAt(j)) * exponent(base, i);
				j++;
			}
		}
		
		resultado = Double.toString(inter);
		
		//Quitamos el 0.
		return resultado.substring(2,(2+decimal > resultado.length()) ? resultado.length() : (2+decimal));
	}
	
	/**
	 * Check de base para que este entre binario y hexadecimal
	 * @param input base a comprobar
	 * @return true si esta entre 2 o 16 falso si no
	 */
	private static boolean isCorrectBase(int input) {
		if (input >= 2 && input <= 16)
			return true;
		else
			return false;
	}
	
	/**
	 * Check de numero para que pertenezca a la base introducida. Tambien sirve de control de numeros. Perimite digitos representados en intConversion separados por un . (parte entera y parte decimal)
	 * @param input numero a comprobar
	 * @param base base que queremos comparar
	 * @return true si input pertenece a la base false en lo contrario
	 */
	public static boolean isCorrect(String input, int base) {
		String patron 	= "0123456789ABCDEF";
		boolean point	= false; //Variable para encontrar un punto al menos
		boolean correct = true;
		
		//Cambiamos el patron dependiendo de la base
		patron = patron.substring(0, base);
		
		
		for(int i = 0; i < input.length() && correct == true; i++) {
			if(input.charAt(i) == '.' && point == false)
				point = true;
			else if(input.charAt(i) == '.' && point == true)
				correct = false;
			else if(patron.lastIndexOf(Character.toUpperCase(input.charAt(i))) == -1 && '.' != input.charAt(i))
				correct = false;
		}
		
		return correct;
	}
	
	/**
	 * Conversion del caracter introducido a entero basado en los digitos hexadecimales
	 * @param input caracter a convertir 
	 * @return numero entero con el valor adecuado, en caso erroneo devuelve -1
	 */
	private static int intConversion(char input) {
		int result = -1;
		char target = Character.toUpperCase(input);
		
		switch(target) {
			case '0':
				result = 0;
				break;
			case '1':
				result = 1;
				break;
			case '2':
				result = 2;
				break;
			case '3':
				result = 3;
				break;
			case '4':
				result = 4;
				break;
			case '5':
				result = 5;
				break;
			case '6':
				result = 6;
				break;
			case '7':
				result = 7;
				break;
			case '8':
				result = 8;
				break;
			case '9':
				result = 9;
				break;
			case 'A':
				result = 10;
				break;
			case 'B':
				result = 11;
				break;
			case 'C':
				result = 12;
				break;
			case 'D':
				result = 13;
				break;
			case 'E':
				result = 14;
				break;
			case 'F':
				result = 15;
				break;
			default:
				result = -1;
				break;
		}
		
		return result;
	}
	
	/**
	 * Conversion del entero introducido a String basado en los digitos hexadecimales
	 * @param input entero a convertir 
	 * @return String con un numero entero con el valor adecuado, en caso erroneo devuelve -1
	 */
	private static String stringConversion(int input) {
		String result = "-1";
	
		switch(input) {
			case 0:
				result = "0";
				break;
			case 1:
				result = "1";
				break;
			case 2:
				result = "2";
				break;
			case 3:
				result = "3";
				break;
			case 4:
				result = "4";
				break;
			case 5:
				result = "5";
				break;
			case 6:
				result = "6";
				break;
			case 7:
				result = "7";
				break;
			case 8:
				result = "8";
				break;
			case 9:
				result = "9";
				break;
			case 10:
				result = "A";
				break;
			case 11:
				result = "B";
				break;
			case 12:
				result = "C";
				break;
			case 13:
				result = "D";
				break;
			case 14:
				result = "E";
				break;
			case 15:
				result = "F";
				break;
			default:
				result = "-1";
				break;
		}
		
		
		
		return result;
	}
	
	/**
	 * Funcion que devuelve el exponente del valor introducido
	 * @param valorNumero base del numero
	 * @param valorExponente exponente del numero
	 * @return resultado la operacion o -1 si no se puede realizar
	 */
	public static double exponent(int valorNumero, int valorExponente) {
		double resultado		= -1;
		
		resultado = valorNumero;
		
		if (valorExponente == 0)
			resultado = 1;
		else if (valorExponente > 1){
			while (valorExponente != 1) {
				resultado *= valorNumero; 
				valorExponente--;
			}
		} else if (valorExponente < 0) {
			if(exponent(valorNumero, -valorExponente) != 0)
				resultado = 1/exponent(valorNumero, -valorExponente);
			else
				resultado = -1;
		}
		return resultado;
	}
}
