/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import modelo.clases.Auto;
import modelo.clases.Color;
import modelo.clases.Marca;
import modelo.clases.Modelo;
import modelo.dao.AutoDAO;

/**
 *
 * @author Nico
 */
public class TestAutoDAO {

    public static void main(String[] args) {
        // TEST CRUD COMPLETO DE AUTO
        AutoDAO dao = new AutoDAO();
        
        Color color = new Color(1);
        Marca marca = new Marca(1);
        Modelo modelo = new Modelo(1);

        Auto auto = new Auto(2, 200, "2018", "0km", true, modelo, marca, color);
        
        // AGREGAR
//        if(dao.agregar(auto)){
//            System.out.println("Agregado");
//        }else{
//            System.out.println("No se pudo agregar");
//        }
        // MODIFICAR
//        if(dao.modificar(auto)){
//            System.out.println("Modificado");
//        }else{
//            System.out.println("No se pudo modificar");
//        }
        // BUSCAR
        Auto autito = dao.buscar(2);
        System.out.println("Datos " + autito.toString());
        
        // LISTAR
//        for (Auto x : dao.listar()) {
//            System.out.println("Auto : " + x.toString());
//        }

        // ELIMINAR
//        if(dao.eliminar(1)){
//            System.out.println("Eliminado");
//        }else{
//            System.out.println("No se pudo eliminar");
//        }
        
    }
}
