/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import modelo.clases.Marca;
import modelo.dao.MarcaDAO;

/**
 *
 * @author Nico
 */
public class TestMarcaDAO {
    public static void main(String[] args) {
        MarcaDAO dao = new MarcaDAO();
        for(Marca x : dao.listar()){
            System.out.println("DESCRIPCIÓN : " + x.getDescripcion());
        }
    }
}
