/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;

/**
 *
 * @author Alfon
 */
public class Consumidor extends Usuario {

    private int idConsumidor;
    private String nombre;
    private List<Producto> wishlist;
    private List<Producto> preferenciasPersonales;

    public Consumidor() {
    }

    public Consumidor(String nombre, List<Producto> wishlist, List<Producto> preferenciasPersonales, String nomUsuario, String contrasenia, String areaUsuario) {
        super(nomUsuario, contrasenia, areaUsuario);
        this.nombre = nombre;
        this.wishlist = wishlist;
        this.preferenciasPersonales = preferenciasPersonales;
    }

    public Consumidor(int idConsumidor, String nombre, List<Producto> wishlist, List<Producto> preferenciasPersonales, String nomUsuario, String contrasenia, String areaUsuario) {
        super(nomUsuario, contrasenia, areaUsuario);
        this.idConsumidor = idConsumidor;
        this.nombre = nombre;
        this.wishlist = wishlist;
        this.preferenciasPersonales = preferenciasPersonales;
    }

    public int getIdConsumidor() {
        return idConsumidor;
    }

    public void setIdConsumidor(int idConsumidor) {
        this.idConsumidor = idConsumidor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getWishlist() {
        return wishlist;
    }

    public void setWishlist(List<Producto> wishlist) {
        this.wishlist = wishlist;
    }

    public List<Producto> getPreferenciasPersonales() {
        return preferenciasPersonales;
    }

    public void setPreferenciasPersonales(List<Producto> preferenciasPersonales) {
        this.preferenciasPersonales = preferenciasPersonales;
    }

    public void verificarOferta(Producto producto) {

    }

    public Producto buscarProducto(String nombre) {
        return null;
    }

    public float compararPrecios(Producto p1, Producto p2) {
        return 0.0f;
    }

    public boolean comprarProducto(Producto producto) {
        return false;
    }

    public boolean generarReporteIncosistencia(Mercado mercado) {
        return false;
    }

    public boolean agregarProductoWishList(Producto producto) {
        return false;
    }

    public boolean quitarProductoWishList(Producto producto) {
        return false;
    }

    public boolean agregarProductoPreferencias(Producto producto) {
        return false;
    }

    public boolean quitarProductoPreferencias(Producto producto) {
        return false;
    }

    public void comentarSupermercado(String comentario) {

    }

    public void calificarSupermercado(float calificacion) {
    }
}
