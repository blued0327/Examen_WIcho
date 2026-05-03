package dao;

import conection.CreateConnection;
import model.PeliculaModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jdmm0
 */
public class PeliculaDao {

    private final CreateConnection connf = new CreateConnection();

    //buscar todos
    public List<PeliculaModel> obtenerPelicula() {
        List<PeliculaModel> lista = new ArrayList<>();
        //query
        String query = "SELECT *FROM pelicula";
        //try
        try (Connection conn = connf.getConnection();//obtener coneccion
                 PreparedStatement ps = conn.prepareStatement(query);//preparar la consulta
                 ResultSet rs = ps.executeQuery()) {//sirve para moverse en la db -- es para select
            while (rs.next()) {
                PeliculaModel pel = new PeliculaModel(//instanciar un objeto
                        //el resulset consigue el dato que esta en " " 
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("director"),
                        rs.getInt("lanzamiento"),
                        rs.getInt("duracion"),
                        rs.getString("genero"),
                        rs.getString("idioma"),
                        rs.getString("descripcion"),
                        rs.getInt("recaudacion"),
                        rs.getString("estudiante"),
                        rs.getInt("stock"));

                lista.add(pel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    //Insertar
    public boolean guardar(PeliculaModel pel) {
        //query
        String query = "INSERT INTO pelicula(titulo,director,lanzamiento,,duracion,genero,idioma,descripcion,recaudacion,estudiante,stock) VALUES(?,?,?,?,?,?,?,?,?,?)";

        //try
        try (Connection conn = connf.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, pel.getTitulo());
            ps.setString(2, pel.getDirector());
            ps.setInt(3, pel.getLanzamiento());
            ps.setInt(4, pel.getDuracion());
            ps.setString(5, pel.getGenero());
            ps.setString(6, pel.getIdioma());
            ps.setString(7, pel.getDescripcion());
            ps.setDouble(8, pel.getRecaudacion());
            ps.setString(9, pel.getEstudiante());
            ps.setInt(10, pel.getStock());

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    //actualizar
    public boolean actualizar(PeliculaModel pel) {

        //query
        String query = "UPDATE pelicua set titulo=?,director=?,lanzamiento=?,duracion=?,genero=?,idioma=?,descripcion=?,recaudacion=?,estudiante=?,stock=? where id=?";

        //try
        try (Connection conn = connf.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, pel.getTitulo());
            ps.setString(2, pel.getDirector());
            ps.setInt(3, pel.getLanzamiento());
            ps.setInt(4, pel.getDuracion());
            ps.setString(5, pel.getGenero());
            ps.setString(6, pel.getIdioma());
            ps.setString(7, pel.getDescripcion());
            ps.setDouble(8, pel.getRecaudacion());
            ps.setString(9, pel.getEstudiante());
            ps.setInt(10, pel.getStock());
            ps.setInt(11, pel.getId());

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    //eliminar
    public boolean eliminar(int id) {

        //query
        String query = "DELELTE pelicula where id= ?";

        //try
        try (Connection conn = connf.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
