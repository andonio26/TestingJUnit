package ejercicio02;

public class SaraThapaKc_Metodos {
	/**
	*	Clase con métodos para probar
	*	@author Sara Thapa Kc
	*	@version 1.0 29/01/2025
	*/
	
	/**
	*	Método para conseguir el mayor valor de dos números
	*	@param primerNumero: Introduce el valor del primer número
	*	@param segundoNumero: Introduce el valor del segundo número
	*	@return el número más grande
	*/
	public int mayorValor(int primerNumero, int segundoNumero) {
		int mayorNumero = 0;
		if (primerNumero>segundoNumero) {
			mayorNumero = primerNumero;
		} else {
			mayorNumero = segundoNumero;
		}
		return mayorNumero;
	}
	
	/**
	*	Método para contar las vocales de una cadena de letras
	*	@param palabra: Introduce una palabra
	*	@return la cantidad de vocales de la palabra
	*/
	public int contarVocales(String palabra) {
		int vocales = 0;
		for (int i = 0 ; i < palabra.length() ; i++) {
			char c = palabra.charAt(i);
			if (c =='a'|| c == 'e'|| c =='i'|| c == 'o'|| c == 'u' || c == 'A'|| c =='E'|| c == 'I'|| c == 'O' || c == 'U') {
				vocales++;
			}
		}
		return vocales;
	}
	
	/**
	*	Método para calcular el IMC de una persona
	*	@param peso: Introduce el peso
	*	@param edad: Introduce la altura
	*	@return el IMC en base al peso y la altura
	*/
	public double getIMC(double peso, double altura) {
		double imc = peso / (altura * altura);
		if (altura == 0) {
			imc = 0;
		}
		return imc;
	}
	
	/**
	*	Método para calcular si una persona es mayor de edad
	*	@param edad: Introduce una edad
	*	@return un booleano indicando si esa persona es mayor de edad o no
	*/
	public boolean esMayorEdad(int edad) {
		boolean mayor = true;
		if (edad >=18){
			mayor = true;
		} else if (edad < 18){
			mayor = false;
		}
		return mayor;
	}
	
	
}
