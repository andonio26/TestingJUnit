import java.util.Scanner;

public class JuanAndres {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcion = -1;

		// Este el bucle principal del menú de los tres métodos
		while (opcion != 0) {
			System.out.println("Menú de tres métodos para realizar pruebas:");
			System.out.println("0 – Salir");
			System.out.println("1 – Media de valores hasta introducir un cero");
			System.out.println("2 – División de múltiples valores con un divisor común");
			System.out.println("3 – Cálculo del factorial de un número");
			System.out.print("Introduce una opción: ");

			try {
				opcion = Integer.parseInt(scanner.nextLine()); // Cogemos la opción del usuario

				switch (opcion) {
					case 1:
						calcularMedia(scanner);
						break;
					case 2:
						calcularDivisiones(scanner);
						break;
					case 3:
						calcularFactorial(scanner);
						break;
					case 0:
						System.out.println("Saliendo del programa...");
						break;
					default:
						System.out.println("Opción no válida. Saliendo.");
						opcion = 0;
				}

			} catch (NumberFormatException e) {
				System.out.println("ERROR: El dato introducido no es un número entero válido.");
			}
		}

		scanner.close(); // Cerramos el scanner para liberar recursos
	}

	/**
	 * En este método calculamos la media de los valores introducidos por el usuario.
	 * El usuario introduce números hasta que ingresa un 0, momento en el cual
	 * se calcula y muestra la media de los valores introducidos.
	 */
	public static void calcularMedia(Scanner scanner) {
		int suma = 0, contador = 0, num;

		try {
			do {
				System.out.print("Introduce un número (0 para finalizar): ");
				num = Integer.parseInt(scanner.nextLine());
				if (num != 0) {
					suma += num;
					contador++;
				}
			} while (num != 0);

			if (contador > 0) {
				double media = (double) suma / contador;
				System.out.println("La media de los valores introducidos es: " + media);
			} else {
				System.out.println("No se introdujeron valores válidos.");
			}
		} catch (NumberFormatException e) {
			System.out.println("ERROR: El valor introducido no es un número entero válido.");
		}
	}

	/**
	 * En este método realizamos divisiones de múltiples números con un divisor común.
	 * Se solicita al usuario un conjunto de dividendos y un divisor común,
	 * y se muestran los resultados de cada división.
	 */
	public static void calcularDivisiones(Scanner scanner) {
		try {
			//  Pedimos cuantos dividendos quiere dividir el usuario
			System.out.print("Introduce la cantidad de números a dividir: ");
			int cantidad = Integer.parseInt(scanner.nextLine());

			if (cantidad <= 0) {
				System.out.println("ERROR: La cantidad debe ser mayor que 0.");
				return;
			}

			// Creo este array para almacenar los dividendos
			int[] dividendos = new int[cantidad];
			for (int i = 0; i < cantidad; i++) {
				System.out.print("Introduce el dividendo " + (i + 1) + ": ");
				dividendos[i] = Integer.parseInt(scanner.nextLine());
			}

			// Solicitamos el divisor común para todas las divisiones
			System.out.print("Introduce el divisor común: ");
			int divisor = Integer.parseInt(scanner.nextLine());

			// Verificamos que el divisor no sea 0
			if (divisor == 0) {
				System.out.println("ERROR: No se puede dividir por 0.");
				return;
			}

			// Creamos otro array para almacenar los resultados de las divisiones
			double[] resultados = new double[cantidad];
			for (int i = 0; i < cantidad; i++) {
				resultados[i] = (double) dividendos[i] / divisor;
			}

			// Terminamos mostrando los resultados de las divisiones
			System.out.println("Resultados de la división:");
			for (int i = 0; i < cantidad; i++) {
				System.out.println(dividendos[i] + " / " + divisor + " = " + resultados[i]);
			}

		} catch (NumberFormatException e) {
			System.out.println("ERROR: El valor introducido no es un número entero válido.");
		}
	}

	/**
	 * En este método calculamos el factorial de un número entero positivo.
	 * El usuario introduce un número y se calcula su factorial.
	 */
	public static void calcularFactorial(Scanner scanner) {
		try {
			// Pedimos un número entero positivo
			System.out.print("Introduce un número entero positivo: ");
			int numero = Integer.parseInt(scanner.nextLine());

			// Comprobamos que el número es positivo
			if (numero < 0) {
				System.out.println("ERROR: No se puede calcular el factorial de un número negativo.");
				return;
			}

			// Cálculamos el factorial
			long factorial = 1;
			for (int i = 1; i <= numero; i++) {
				factorial *= i;
			}

			// Para finalizar mostramos el resultado
			System.out.println("El factorial de " + numero + " es: " + factorial);
		} catch (NumberFormatException e) {
			System.out.println("ERROR: El valor introducido no es un número entero válido.");
		}
	}
}

