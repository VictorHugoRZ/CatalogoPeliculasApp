package servicio;

import dominio.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ServicioPeliculasLista implements IServicioPeliculas{

    private final List<Pelicula> peliculas;

    public ServicioPeliculasLista() {
        this.peliculas = new ArrayList<>();
    }

    @Override
    public void listarPeliculas() {
        System.out.println("Listado de peliculas...");
        peliculas.forEach(System.out::println);
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Se agrego la pelicula " + pelicula);
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        //Regresa el indice de la pelicula encontrada en la lista
        var indice = peliculas.indexOf(pelicula);

        if (indice == -1) System.out.println("Pelicula no encontrada.");


        System.out.println("Pelicula encontrada en la posicion " + ++indice);
    }

    public static void main(String[] args) {
        //Creamos algunos objetos de tipo Pelicula
        var pelicula1 = new Pelicula("Batman");
        var pelicula2 = new Pelicula("Superman");

        //Creamos el servicio (Patron de diseno Service)
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();

        //Agregamos Peliculas a la lista
        servicioPeliculas.agregarPelicula(pelicula1);
        servicioPeliculas.agregarPelicula(pelicula2);

        //Listamos las Peliculas
        servicioPeliculas.listarPeliculas();

        //Buscamos una pelicula
        servicioPeliculas.buscarPelicula(pelicula1);
        servicioPeliculas.buscarPelicula(pelicula2);
    }
}
