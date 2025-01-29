package paraProbar;

import java.util.Random;
public class AgustinNahuelBernalSita {
	
	/**
	 * Método que hace como Francis e aprueba o desaprueba a alumnos
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
}
