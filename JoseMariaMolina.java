package metodo_JoseMariaMolina;

public class JoseMariaMolina {
    public static void main(String[] args) {
    }

    public static double horasLuz(double distancia) {
        final double c = 300000;
        double horas = (distancia / c) / 3600;
        return horas;
    }

    public static int[] ordenarArray(int[] array) {
        if (array == null || array.length == 0) {
        	 System.err.println("El array no puede estar vacío");
        }
        int[] arrayOrdenado = array.clone();
        int n = arrayOrdenado.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {

                if (arrayOrdenado[j] > arrayOrdenado[j + 1]) {
                    int temp = arrayOrdenado[j];
                    arrayOrdenado[j] = arrayOrdenado[j + 1];
                    arrayOrdenado[j + 1] = temp;
                }
            }
        }
        return arrayOrdenado;
    }

    public static String arrayStringMayusculas(char[] caract) {
        return new String(caract).toUpperCase();
    }

    public static String encontrarMayorYMenor(int[] array) {
        if (array == null || array.length == 0) {
        	 System.err.println("El array no puede estar vacío");
        }

        int mayor = array[0];
        int menor = array[0];

        for (int num : array) {
            if (num > mayor) {
                mayor = num;
            }
            if (num < menor) {
                menor = num;
            }
        }

        return "Mayor número: " + mayor + ", Menor número: " + menor;
    }
}
