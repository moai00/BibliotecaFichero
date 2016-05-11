/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecafichero;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author usu21
 */
public class ListaLibros implements Serializable {
    
 private ArrayList<Libro> lista;
 
 public ListaLibros(){
     lista = new ArrayList<>();
     
 }
 
 public void altaLibro(Libro l){
     lista.add(l);
 }
 
 
 //devuelve libros por id
// public Libro libroXId(String id){
//     for (Libro l : lista){
//         if (l.getId().equalsIgnoreCase(id)){
//             return l;
//         }
//     }
//     
// 
//    return null;
//}

 //devuelve libros por genero
//public Libro libroXGenero(String genero){
//     for (Libro l : lista){
//         if (l.getId().equalsIgnoreCase(genero)){
//             return l;
//         }
//     }
//     
// 
//    return null;
//} 

//devuelve libro más gordo

public Libro gordo(){
    if (lista.isEmpty()){
        return null;
    }else{
        Libro extenso = lista.get(0);
        for (Libro l : lista){
            if (l.getNPaginas() > extenso.getNPaginas()){
                extenso = l;
            }
        } 
        return extenso;
    }
}

public boolean existe (Libro l){
    return lista.contains(l);
}

public double preciototal(){
    double total = 0;
    
    for (Libro l : lista){
        total = total + l.getPrecio();
    }
    
    return total;
}

public int prestados(){
    int total= 0;
    
    for (Libro l : lista){
        if (l.isEnPrestamo()){
            total = total +1;
        }
    }
    
    return total;
}

public int cantidad(){
    return lista.size();
}

public Libro obtenerLibro (int posicion){
    return lista.get(posicion);
}

public ArrayList getLista(){
    return lista;
}

public void setLista(ArrayList lista){
    this.lista = lista;
}



}