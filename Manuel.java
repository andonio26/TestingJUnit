package MetodosEntornos;

public class Manuel {

	    //Calcular el promedio de un array de números
	    public double calcularPromedio(int[] numeros) {
	        if (numeros == null || numeros.length == 0) {
	            throw new IllegalArgumentException("El array no puede estar vacío");
	        }
	        int suma = 0;
	        for (int numero : numeros) {
	            suma += numero;
	        }
	        return (double) suma / numeros.length;
	    }

	    //Contar las vocales en una cadena
	    public int contarVocales(String texto) {
	        if (texto == null) {
	            return 0;
	        }
	        int contador = 0;
	        texto = texto.toLowerCase();
	        for (char c : texto.toCharArray()) {
	            if ("aeiou".indexOf(c) != -1) {
	                contador++;
	            }
	        }
	        return contador;
	    }

	    //Revertir una cadena
	    public String revertirCadena(String cadena) {
	        if (cadena == null) {
	            return null;
	        }
	        return new StringBuilder(cadena).reverse().toString();
	    }

	    //Determinar si un número es primo
	    public boolean esPrimo(int numero) {
	        if (numero <= 1) {
	            return false;
	        }
	        for (int i = 2; i <= Math.sqrt(numero); i++) {
	            if (numero % i == 0) {
	                return false;
	            }
	        }
	        return true;
	    }
}
