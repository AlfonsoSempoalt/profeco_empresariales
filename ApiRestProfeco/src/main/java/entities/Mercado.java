/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alfon
 */
public class Mercado extends Usuario{

    private int idMercado;
    private String nombre;
    private List<Producto> productos;
    private List<Sancion> sanciones;
    private double calificacion;
    private StringBuilder comentarios;
    private int cantidadReportes;

    public Mercado() {
    }

    public Mercado(String nombre, ArrayList<Producto> productos, ArrayList<Sancion> sanciones, double calificacion, StringBuilder comentarios, int cantidadReportes) {
        this.nombre = nombre;
        this.productos = productos;
        this.sanciones = sanciones;
        this.calificacion = calificacion;
        this.comentarios = comentarios;
        this.cantidadReportes = cantidadReportes;
    }
    
    public Mercado(int idMercado, String nombre, ArrayList<Producto> productos, ArrayList<Sancion> sanciones, double calificacion, StringBuilder comentarios, int cantidadReportes) {
        this.idMercado = idMercado;
        this.nombre = nombre;
        this.productos = productos;
        this.sanciones = sanciones;
        this.calificacion = calificacion;
        this.comentarios = comentarios;
        this.cantidadReportes = cantidadReportes;
    }

    public int getIdMercado() {
        return idMercado;
    }

    public void setIdMercado(int idMercado) {
        this.idMercado = idMercado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public List<Sancion> getSanciones() {
        return sanciones;
    }

    public void setSanciones(ArrayList<Sancion> sanciones) {
        this.sanciones = sanciones;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public StringBuilder getComentarios() {
        return comentarios;
    }

    public void setComentarios(StringBuilder comentarios) {
        this.comentarios = comentarios;
    }

    public int getCantidadReportes() {
        return cantidadReportes;
    }

    public void setCantidadReportes(int cantidadReportes) {
        this.cantidadReportes = cantidadReportes;
    }

    @Override
    public String toString() {
        return "Mercado{" + "idMercado=" + idMercado + ", nombre=" + nombre + ", productos=" + productos + ", sanciones=" + sanciones + ", calificacion=" + calificacion + ", comentarios=" + comentarios + ", cantidadReportes=" + cantidadReportes + '}';
    }
    
    
}
