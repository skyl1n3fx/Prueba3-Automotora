/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.clases;

/**
 *
 * @author Nico
 */
public class Auto {

    private int id, precio;
    private String anio, km;
    private boolean nuevo;
    private Modelo modelo;
    private Marca marca;
    private Color color;

    public Auto() {
    }

    public Auto(int id, int precio, String anio, String km, boolean nuevo, Modelo modelo, Marca marca, Color color) {
        setId(id);
        setPrecio(precio);
        setAnio(anio);
        setKm(km);
        setColor(color);
        setNuevo(nuevo);
        setModelo(modelo);
        setMarca(marca);
    }

    public Auto(int precio, String anio, String km, boolean nuevo, Modelo modelo, Marca marca, Color color) {
        setPrecio(precio);
        setAnio(anio);
        setKm(km);
        setColor(color);
        setNuevo(nuevo);
        setModelo(modelo);
        setMarca(marca);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public boolean isNuevo() {
        return nuevo;
    }

    public void setNuevo(boolean nuevo) {
        this.nuevo = nuevo;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Auto{" + "id=" + id + ", precio=" + precio + ", anio=" + anio + ", km=" + km + ", nuevo=" + nuevo + ", modelo=" + modelo + ", marca=" + marca + ", color=" + color + '}';
    }

}
