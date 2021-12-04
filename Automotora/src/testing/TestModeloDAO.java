/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import modelo.clases.Modelo;
import modelo.dao.ModeloDAO;

/**
 *
 * @author Nico
 */
public class TestModeloDAO {
    public static void main(String[] args) {
        ModeloDAO dao = new ModeloDAO();
        for (Modelo x : dao.listar()) {
            System.out.println("DESCRIPCIÓN : " + x.getDescripcion());
        }

    }
}
