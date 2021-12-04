/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.crud;

import java.util.List;



/**
 *
 * @author Nico
 */
public interface IModeloCrud <Entidad> {
    
    // Creamos los métodos CRUD para acceder a la Base de datos
    
    // Método para agregar una entidad
    boolean agregar(Entidad e);
    
    // Método para modificar una entidad
    boolean modificar(Entidad e);
    
    // Método para eliminar una entidad
    boolean eliminar(int id);
    
    // Método para listar una entidad
    List<Entidad> listar();
    
    // Método para buscar una entidad
    Entidad buscar(int id);
    
}
