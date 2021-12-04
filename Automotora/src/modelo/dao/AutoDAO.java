/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import conexion.Mysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.clases.Auto;
import modelo.clases.Color;
import modelo.clases.Marca;
import modelo.clases.Modelo;
import modelo.crud.IModeloCrud;

/**
 *
 * @author Nico
 */
public class AutoDAO implements IModeloCrud<Auto> {

    private static Connection conexion;
    private PreparedStatement ps = null;
    private Statement st;
    private ResultSet rs;

    @Override
    public boolean agregar(Auto e) {
        boolean valida = false;
        try {
            conexion = new Mysql().getConexion();
            int nuevo = 2;
            String sql = "INSERT INTO AUTO (anio, km, precio, id_modelo, id_marca, id_color, id_nuevo) VALUES (?, ?, ? , ? , ?, ?, ?)";
            ps = conexion.prepareStatement(sql);
            if (e.isNuevo()) {
                nuevo = 1;
            }
            ps.setString(1, e.getAnio());
            ps.setString(2, e.getKm());
            ps.setInt(3, e.getPrecio());
            ps.setInt(4, e.getModelo().getId());
            ps.setInt(5, e.getMarca().getId());
            ps.setInt(6, e.getColor().getId());
            ps.setInt(7, nuevo);

            if (ps.executeUpdate() == 1) {
                valida = true;
            }

        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(AutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valida;
    }

    @Override
    public boolean modificar(Auto e) {
        boolean valida = false;
        try {
            conexion = new Mysql().getConexion();
            int nuevo = 2;
            String sql = "UPDATE AUTO  SET anio = ?, km = ? , precio = ?, id_modelo = ?, id_marca = ?, id_color = ? , id_nuevo = ? WHERE id = ?";
            ps = conexion.prepareStatement(sql);
            if (e.isNuevo()) {
                nuevo = 1;
            }
            ps.setString(1, e.getAnio());
            ps.setString(2, e.getKm());
            ps.setInt(3, e.getPrecio());
            ps.setInt(4, e.getModelo().getId());
            ps.setInt(5, e.getMarca().getId());
            ps.setInt(6, e.getColor().getId());
            ps.setInt(7, nuevo);
            ps.setInt(8, e.getId());

            if (ps.executeUpdate() == 1) {
                valida = true;
            }

        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(AutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valida;
    }

    @Override
    public boolean eliminar(int id) {
        boolean valida = false;
        try {
            conexion = new Mysql().getConexion();
            String sql = "DELETE FROM AUTO WHERE id = ?";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() == 1) {
                valida = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(AutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valida;
    }

    @Override
    public List<Auto> listar() {
        List<Auto> listarAutos = new ArrayList<Auto>();
        try {
            conexion = new Mysql().getConexion();
            String consulta = "SELECT a.id, a.anio, a.km, a.precio, m.id, m.descripcion, ma.id , ma.descripcion, c.id,\n"
                    + "c.descripcion, n.id, n.descripcion FROM AUTO a INNER JOIN MODELO m ON a.id_modelo = m.id INNER JOIN MARCA ma ON a.id_marca = ma.id INNER JOIN COLOR c ON a.id_color = c.id INNER JOIN nuevo n ON a.id_nuevo = n.id";
            st = conexion.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                Modelo modelo = new Modelo(rs.getInt(5), rs.getString(6));
                Marca marca = new Marca(rs.getInt(7), rs.getString(8));
                Color color = new Color(rs.getInt(9), rs.getString(10));

                // Validamos si el auto es nuevo o usado
                boolean nuevo = false;
                if (rs.getInt(rs.getInt(11)) == 1) {
                    nuevo = true;
                }

                // Creamos la instancia de AUTO
                Auto auto = new Auto();
                auto.setId(rs.getInt(1));
                auto.setAnio(rs.getString(2));
                auto.setKm(rs.getString(3));
                auto.setPrecio(rs.getInt(4));
                auto.setModelo(modelo);
                auto.setMarca(marca);
                auto.setColor(color);
                auto.setNuevo(nuevo);

                listarAutos.add(auto);
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        } finally {
            try {
                // Cerramos la conexión
                conexion.close();
            } catch (Exception e) {
            }
            return listarAutos;
        }
    }

    @Override
    public Auto buscar(int id) {
        // Creamos la instancia de AUTO
        Auto auto = new Auto();
        try {
            conexion = new Mysql().getConexion();
            String consulta = "SELECT a.id, a.anio, a.km, a.precio, m.id, m.descripcion, ma.id , ma.descripcion, c.id,\n"
                    + "c.descripcion, n.id, n.descripcion FROM AUTO a INNER JOIN MODELO m ON a.id_modelo = m.id INNER JOIN MARCA ma ON a.id_marca = ma.id INNER JOIN COLOR c ON a.id_color = c.id INNER JOIN nuevo n ON a.id_nuevo = n.id WHERE a.id = " + id;
            st = conexion.createStatement();
            rs = st.executeQuery(consulta);

            while (rs.next()) {
                Modelo modelo = new Modelo(rs.getInt(5), rs.getString(6));
                Marca marca = new Marca(rs.getInt(7), rs.getString(8));
                Color color = new Color(rs.getInt(9), rs.getString(10));
                // Validamos si el auto es nuevo o usado
                boolean esNuevo = false;
                int valor = rs.getInt(11);
                if (valor == 1) {
                    esNuevo = true;
                }

                auto.setId(rs.getInt(1));
                auto.setAnio(rs.getString(2));
                auto.setKm(rs.getString(3));
                auto.setPrecio(rs.getInt(4));
                auto.setModelo(modelo);
                auto.setMarca(marca);
                auto.setColor(color);
                auto.setNuevo(esNuevo);

            }

        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(AutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return auto;
    }
}
