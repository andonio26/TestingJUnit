package paraProbar;

import java.util.Random;
public class AgustinNahuelBernalSita {
	
	/**
	 * Método que hace como F. e aprueba o desaprueba a alumnos
	 * @return Devuelve la nota adquirida
	 */
	
	public String aprobado_suspenso_aleatorio() {
		Random aleatorio=new Random();
		String resultado = null;
		int numero=aleatorio.nextInt(1,10);
		if(numero>1 && numero<3) {
			resultado="Suspenso";
		}
		else if(numero>=3 && numero<5) {
			resultado="Casi aprobamos";
		}
		else if(numero>=5 && numero<6) {
			resultado="Aprobado";
		}
		else if(numero>=6 && numero<8) {
			resultado="Buena nota";
		}
		else if(numero>=8 && numero<9) {
			resultado="Notable";
		}
		else if(numero>=9 && numero<=10) {
			resultado="Sobresaliente";
		}
		return resultado + " " + numero;
	}
	
	/**
	 * Ingresar un nombre completo, para generar un apodo
	 * @param nombre El nombre del que se requiera un apodo
	 * @return Devuelve el apodo del nombre
	 */ 
	public String apodoAutomatico(String nombreCompleto) {
		 
		String[]partes=nombreCompleto.split(" ");
		String resultado = partes[0];
	    for (int i = 1; i < partes.length; i++) {
	    	resultado = resultado + " " + partes[i].charAt(0) + ".";
	        }
	        return resultado;
	    }
		
		/**
		 * Esta clase indica si los números ingresados están desordenados ascendentemente, descendentemente o desordenados
		 * @param valor1 Un valor numérico entero 
		 * @param valor2 Un valor numérico entero
		 * @param valor3 Un valor numérico entero
		 * @param valor4 Un valor numérico entero
		 * @param valor5 Un valor numérico entero
		 * @return Devuelve lo indicado en el título de la clase
		 */
		public String ordenValores(int valor1, int valor2, int valor3, int valor4, int valor5) {
			String resultado="";
			if((valor1<valor2)&&(valor2<valor3)&&(valor3<valor4)&&(valor4<valor5)) {
				resultado="Valores ordenados ascendentemente";
			}
			else if((valor5<valor4)&&(valor4<valor3)&&(valor3<valor2)&&(valor2<valor1)) {
				resultado="Valores ordenados descendentemente";
			}
			else {
				resultado="Valores desordenados";
			}
			return resultado;
		}
}
