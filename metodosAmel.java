package Tests;

public class metodosAmel {
	
	//Clase producto
	public class Producto {
	    private String nombre;
	    private double precio;

	    public Producto(String nombre, double precio) {
	        this.nombre = nombre;
	        this.precio = precio;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public double getPrecio() {
	        return precio;
	    }
	}
	
	//Clase supermercado
    private Producto[] productos;

    public void Supermercado(Producto[] productos) {
        this.productos = productos;
    }

    // Precio total de todos los productos
    public double calcularPrecioTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

    // Producto mas caro
    public Producto productoMasCaro() {
        Producto masCaro = productos[0];
        for (Producto producto : productos) {
            if (producto.getPrecio() > masCaro.getPrecio()) {
                masCaro = producto;
            }
        }
        return masCaro;
    }

    //Descuento
    public void aplicarDescuento(double porcentaje) {
        for (Producto producto : productos) {
            double nuevoPrecio = producto.getPrecio() * (1 - porcentaje / 100);
            producto = new Producto(producto.getNombre(), nuevoPrecio); 
        }
    }
}
