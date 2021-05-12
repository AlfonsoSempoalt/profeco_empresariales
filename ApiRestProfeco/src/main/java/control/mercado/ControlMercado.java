/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.mercado;

import dao.SancionDAO;
import entities.Sancion;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class ControlMercado {
    private SancionDAO daoSancion;
    
    public ControlMercado(SancionDAO daoSancion){
        this.daoSancion = daoSancion;
    }
    
    public List<Sancion> leerSanciones(){
        return this.daoSancion.obtener("todas");
    }
}
