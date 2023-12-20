package presentacion;

import dominio.Pelicula;
import servicio.IServicioPeliculas;
import servicio.ServicioPeliculasArchivo;
//import servicio.ServicioPeliculasLista;

import java.util.Scanner;

public class CatalogoPeliculasApp {
    public static void main(String[] args) {

        var salir = false;
        var scanner = new Scanner(System.in);

        //Agregamos la implementacion del servicio
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasArchivo();

        while (!salir) {
            try{
                mostrarMenu();
                salir = ejecutarOpciones(scanner, servicioPeliculas);
            } catch (Exception e) {
                System.out.println("Ocurrio un error: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static void mostrarMenu() {
        System.out.print("""
                *** Catalogo de Peliculas ***
                1. Agregar Pelicula
                2. Listar Peliculas
                3. Buscar Peliculas
                4. Salir
                Ingrese la opcion deseada:
                """);
    }

    private static boolean ejecutarOpciones(Scanner scanner, IServicioPeliculas servicioPeliculas) {

        var opcion = Integer.parseInt(scanner.nextLine());
        var salir = false;

        switch (opcion) {
            case 1 -> {
                System.out.println("Ingrese el nombre de la pelicula: ");
                var nombre = scanner.nextLine();
                servicioPeliculas.agregarPelicula(new Pelicula(nombre));
            }
            case 2 -> servicioPeliculas.listarPeliculas();
            case 3 -> {
                System.out.println("¿Que pelicula desea buscar? ");
                var buscar = scanner.nextLine();
                servicioPeliculas.buscarPelicula(new Pelicula(buscar));
            }
            case 4 -> {
                System.out.println("Vuelva pronto! ");
                salir = true;
            }
            default -> System.out.println("Opcion invalida: " + opcion);
        }
        return salir;
    }
}