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
import modelo.clases.Marca;
import modelo.crud.IModeloCrud;

/**
 *
 * @author Nico
 */
public class MarcaDAO implements IModeloCrud<Marca> {

    private static Connection conexion;
    private Statement st;
    private ResultSet rs;

    @Override
    public boolean agregar(Marca e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Marca e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Marca> listar() {
        List<Marca> listaMarcas = new ArrayList<Marca>();
        try {
            // Nos conectamos a la bdd
            conexion = new Mysql().getConexion();
            String consulta = "SELECT * FROM MARCA";
            st = conexion.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                Marca marca = new Marca();
                marca.setId(rs.getInt(1));
                marca.setDescripcion(rs.getString(2));
                listaMarcas.add(marca);
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        } finally {
            try {
                // Cerramos la conexión
                conexion.close();
            } catch (Exception e) {
            }
            return listaMarcas;
        }
    }

    @Override
    public Marca buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
