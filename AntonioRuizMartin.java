package ;

import java.util.Scanner;

public class AntonioRuizMartin {

	 public static int exponente(int base, int exponente) {

	        if (base == 0 && exponente == 0) {
	            System.out.println("Indeterminado");
	            return -1;  
	        } 
	        
	        int resultado = 1;

	        for (int i = 0; i < exponente; i++) {
	            resultado *= base;
	        }

	        return resultado;
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Introduce la base: ");
	        int base = scanner.nextInt();

	        System.out.print("Introduce el exponente: ");
	        int exponente = scanner.nextInt();

	        int resultado = exponente(base, exponente);
	        
	        if (resultado != -1) {
	            System.out.println(base + " elevado a " + exponente + " da como resultado: " + resultado);
	        }

	        scanner.close();
	    }
}
