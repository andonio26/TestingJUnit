package JUnit;

import java.util.ArrayList;

public class JUnit_Daniel {
	
	// Clase interna para representar un libro
    public static class Libro {
        private String titulo;
        private String autor;

        public Libro(String titulo, String autor) {
            this.titulo = titulo;
            this.autor = autor;
        }

        public String getTitulo() {
            return titulo;
        }

        public String getAutor() {
            return autor;
        }

        @Override
        public String toString() {
            return "Título: " + titulo + ", Autor: " + autor;
        }
    }

    // Lista de libros
    private ArrayList<Libro> libros;

    public void GestionLibros() {
        libros = new ArrayList<>();
    }

    // Agregar un libro a la lista
    public void agregarLibro(String titulo, String autor) {
        libros.add(new Libro(titulo, autor));
    }

    // Eliminar un libro por título
    public boolean eliminarLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo)) {
                libros.remove(libro);
                return true;
            }
        }
        return false;
    }

    // Listar todos los libros
    public void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la lista.");
        } else {
            for (Libro libro : libros) {
                System.out.println(libro);
            }
        }
    }
}