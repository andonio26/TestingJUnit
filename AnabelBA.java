package metodos;

import java.util.ArrayList;
import java.util.List;

public class AnabelBA {

	public static void main(String[] args) {
	}

			//Calcula el area de un circulo ----------------------------------------------------------------
		    public static double calcularAreaCirculo(double radio) {
		        return Math.PI * radio * radio; 
		    }
		    
		    //Calcular precio con IVA ----------------------------------------------------------------------
		    public static double calcularPrecioFinal(double precioOriginal, double descuento, double iva) {
		        double precioConDescuento = precioOriginal - (precioOriginal * descuento / 100); 
		        double precioConIVA = precioConDescuento + (precioConDescuento * iva / 100); 
		        return precioConIVA;
		    }
		    
		    //Filtras numeros ------------------------------------------------------------------------------
		    public static List<Integer> filtrarNumerosMayoresQue(List<Integer> lista, int limite) {
		        List<Integer> resultado = new ArrayList<>(); 

		        for (int numero : lista) {
		            if (numero > limite) {
		                resultado.add(numero); 
		            }
		        }

		        return resultado; 
		    }
		    
		    //Recibe un array y devuelve un nuevo array con los valores duplicados -------------------------
		    public static int[] duplicarValores(int[] arrayOriginal) {
		        int[] arrayDuplicado = new int[arrayOriginal.length]; 

		        for (int i = 0; i < arrayOriginal.length; i++) {
		            arrayDuplicado[i] = arrayOriginal[i] * 2; 
		        }

		        return arrayDuplicado;
		    }
		    
}
