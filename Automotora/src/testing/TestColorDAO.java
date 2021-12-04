/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import modelo.clases.Color;
import modelo.dao.ColorDAO;

/**
 *
 * @author Nico
 */
public class TestColorDAO {
    public static void main(String[] args) {
        ColorDAO dao = new ColorDAO();
        for (Color x : dao.listar()) {
            System.out.println("DESCRIPCIÓN : " + x.getDescripcion());
        }

    }
}
