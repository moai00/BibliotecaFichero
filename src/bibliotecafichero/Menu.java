/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecafichero;

import utilidades.EntradaDatos;
import utilidades.Fichero;

/**
 *
 * @author usu21
 */
public class Menu {

    private ListaLibros misLibros;
    private Fichero miFichero;

    public Menu() {
        miFichero = new Fichero("biblioteca.xml");

        misLibros = (ListaLibros) miFichero.leer();
        if (misLibros == null) {
            misLibros = new ListaLibros();
        }

        int opcion;
        do {

            mostrarMenu();
            opcion = EntradaDatos.pedirEntero("Escoge una opcion");
            switch (opcion) {
                case 1:
                    altaLibro();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    libroGordo();
                    break;
                case 5:
                    break;
                case 6:
                    listadoLibros();
                    break;
                case 7:
                    System.out.println("Hasta la próxima!");
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
            }

        } while (opcion != 7);

    }
    
    private void libroGordo(){
       Libro gordo = misLibros.gordo();
       if (gordo == null){
           System.out.println("No hay libros");
       }else{
           System.out.println("El libro con más páginas es: ");
           System.out.println(gordo);
       }
    }

    private void listadoLibros() {
        int cantidad = misLibros.cantidad();
        if (cantidad == 0) {
            System.out.println("No hay libros");

        } else {
            System.out.println("******LISTADO DE LIBROS******");
            for (int i = 0; i < cantidad; i++) {
                Libro actual = misLibros.obtenerLibro(i);
                System.out.println(actual);
            }
        }
    }

    private void altaLibro() {
        boolean existe = false;
        String id;
        do {
            id = EntradaDatos.pedirCadena("Código del libro");
            Libro auxiliar = new Libro();
            auxiliar.setId(id);
            existe = misLibros.existe(auxiliar);
            if (existe) {
                System.out.println("Ya existe un libro con ese código");
            }

        } while (existe);

        String titulo = EntradaDatos.pedirCadena("Introduce el titulo");
        String autor = EntradaDatos.pedirCadena("Introduce el autor");
        int nPaginas;
        do {
            nPaginas = EntradaDatos.pedirEntero("Introduce el nº de páginas");
            if (nPaginas <= 0) {
                System.out.println("El número de páginas no puede ser inferior a 1");
            }

        } while (nPaginas <= 0);

        String genero = EntradaDatos.pedirCadena("Introduce el género");
        double precio;
        do {
            precio = EntradaDatos.pedirDouble("Introduce el precio");
            if (precio < 0) {
                System.out.println("El precio no puede ser negativo");
            }

        } while (precio < 0);

        boolean enPrestamo = false;
        String respuesta = " ";
        do {
            respuesta = EntradaDatos.pedirCadena("El libro está en préstamo (S/N)?");
            if (respuesta.equalsIgnoreCase("S")) {
                enPrestamo = true;
            } else if (respuesta.equalsIgnoreCase("N")) {
                enPrestamo = false;
            } else {
                System.out.println("Introduce S o N");
            }

        } while (!respuesta.equalsIgnoreCase("s") && !respuesta.equalsIgnoreCase("n"));

        Libro l = new Libro(id, titulo, autor, nPaginas, genero, precio, enPrestamo);

        misLibros.altaLibro(l);
        miFichero.grabar(misLibros);

    }

    private void mostrarMenu() {
        System.out.println("1. Nuevo Libro");
        System.out.println("2. Consultar Libros por ID");
        System.out.println("3. Consultar Libros por genero");
        System.out.println("4. Libro con mayor numero de paginas");
        System.out.println("5. Totales (Libros en prestamo, Total Libros, Valor Total)");
        System.out.println("6. Listado de libros");
        System.out.println("7. Salir");

    }

}
