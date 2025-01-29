package metodos;

public class MetodosAlejandroLopezSalvatierra{

	/**
	 * Calcula la distancia recorrida en base al tiempo y la velocidad.
	 *
	 * @param tiempo El tiempo transcurrido en horas.
	 * @param velocidad La velocidad en kilómetros por hora.
	 * @return La distancia recorrida en kilómetros.
	 */

	public static double calcularDistancia(double tiempo, double velocidad) {
		return tiempo * velocidad;
	}

	/**
	 * Calcula la raíz cuadrada de un número.
	 *
	 * @param numero El número del cual se calculará la raíz cuadrada.
	 * @return La raíz cuadrada del número, o NaN si el número es negativo.
	 */

	public static double calcularRaizCuadrada(double numero) {
		if (numero < 0) {
			return Double.NaN; // Devuelve NaN  si el número es negativo
		} else {
			return Math.sqrt(numero);

		}
	}

		/**
		 * Método para calcular si un vehículo cabe en una plaza de aparcamiento
		 * @param anchoVehiculo
		 * @param largoVehiculo
		 * @return
		 */
	public static boolean cabeVehiculo(double anchoVehiculo, double largoVehiculo) {
		/**
		 * Dimensiones de la plaza de aparcamiento
		 */
		double anchoPlaza = 4.5;
		double largoPlaza = 3.5;

		/**
		 * Verificamos si las dimensiones del vehículo son menores o iguales a las de la plaza
		 */
		return anchoVehiculo <= anchoPlaza && largoVehiculo <= largoPlaza;
	}

	public static void main(String[] args) {
		
		/**
		 *  Ejemplo de uso:
		 */
		double anchoCoche = 2.0;
		double largoCoche = 4.2;

		if (cabeVehiculo(anchoCoche, largoCoche)) {
			System.out.println("El vehículo cabe en la plaza de aparcamiento.");
		} else {
			System.out.println("El vehículo NO cabe en la plaza de aparcamiento.");
		}
	}


}