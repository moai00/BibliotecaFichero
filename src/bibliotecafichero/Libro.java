/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecafichero;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author usu21
 */
public class Libro implements Serializable {
    
    private String id;
    private String titulo;
    private String autor;
    private int nPaginas;
    private String genero;
    private double precio;
    private boolean enPrestamo;
    
    public Libro(){
        
    }

    public Libro(String id, String titulo, String autor, int nPaginas, String genero, double precio, boolean enPrestamo) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.nPaginas = nPaginas;
        this.genero = genero;
        this.precio = precio;
        this.enPrestamo = enPrestamo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Libro other = (Libro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String prestamo;
        if(enPrestamo){
            prestamo = "SI";
        }else{
            prestamo = "NO";
        }
        
        return "id: " + id + ", titulo: " + titulo + ", autor: " + autor + ", nPaginas: " + nPaginas + ", genero: " + genero + ", precio: " + precio + ", enPrestamo: " + prestamo ;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNPaginas() {
        return nPaginas;
    }

    public void setNPaginas(int nPaginas) {
        this.nPaginas = nPaginas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEnPrestamo() {
        return enPrestamo;
    }

    public void setEnPrestamo(boolean enPrestamo) {
        this.enPrestamo = enPrestamo;
    }
    
    
    
    
    
}
