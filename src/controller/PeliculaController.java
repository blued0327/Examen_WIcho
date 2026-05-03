package controller;

import model.PeliculaModel;
import dao.PeliculaDao;

import java.util.List;

public class PeliculaController {

    private final PeliculaDao dao = new PeliculaDao();

    //buscar todos
    public List<PeliculaModel> obtenerPelicula() {
        return dao.obtenerPelicula();

    }

    //insertar
    public void insertarPelicula(String titulo, String director, String lanzamiento, int duracion, String genero, String idioma,
            String descripcion, double recaudacion, String estudiante, int stock) {
        PeliculaModel pel = new PeliculaModel(stock, titulo, director, duracion, duracion, genero, idioma, descripcion, recaudacion, estudiante, stock);
        dao.guardar(pel);
    }

    //actualizar
    public void insertarPelicula(int id, String titulo, String director, String lanzamiento, int duracion, String genero, String idioma,
            String descripcion, double recaudacion, String estudiante, int stock) {
        PeliculaModel pel = new PeliculaModel(id, titulo, director, duracion, duracion, genero, idioma, descripcion, recaudacion, estudiante, stock);
        dao.guardar(pel);

    }

    //eliminar
    public void eliminarPelicula(int id) {
        dao.eliminar(id);
    }

}
