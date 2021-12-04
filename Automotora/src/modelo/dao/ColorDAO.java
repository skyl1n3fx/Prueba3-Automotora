/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import conexion.Mysql;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.clases.Color;
import modelo.clases.Marca;
import modelo.crud.IModeloCrud;

/**
 *
 * @author Nico
 */
public class ColorDAO implements IModeloCrud<Color> {

    private static Connection conexion;
    private Statement st;
    private ResultSet rs;

    @Override
    public boolean agregar(Color e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Color e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Color> listar() {
        List<Color> listaColores = new ArrayList<Color>();
        try {
            // Nos conectamos a la bdd
            conexion = new Mysql().getConexion();
            String consulta = "SELECT * FROM COLOR";
            st = conexion.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                Color color = new Color();
                color.setId(rs.getInt(1));
                color.setDescripcion(rs.getString(2));
                listaColores.add(color);
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        } finally {
            try {
                // Cerramos la conexión
                conexion.close();
            } catch (Exception e) {
            }
            return listaColores;
        }
    }

    @Override
    public Color buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
