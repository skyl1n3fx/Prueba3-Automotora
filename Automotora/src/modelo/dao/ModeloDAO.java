package modelo.dao;

import conexion.Mysql;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.clases.Marca;
import modelo.clases.Modelo;
import modelo.crud.IModeloCrud;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nico
 */
public class ModeloDAO implements IModeloCrud<Modelo> {

    private static Connection conexion;
    private Statement st;
    private ResultSet rs;

    @Override
    public boolean agregar(Modelo e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Modelo e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Modelo> listar() {
        List<Modelo> listarModelos = new ArrayList<Modelo>();
        try {
            // Nos conectamos a la bdd
            conexion = new Mysql().getConexion();
            String consulta = "SELECT * FROM MODELO";
            st = conexion.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                Modelo modelo = new Modelo();
                modelo.setId(rs.getInt(1));
                modelo.setDescripcion(rs.getString(2));
                listarModelos.add(modelo);
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        } finally {
            try {
                // Cerramos la conexión
                conexion.close();
            } catch (Exception e) {
            }
            return listarModelos;
        }
    }

    @Override
    public Modelo buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
