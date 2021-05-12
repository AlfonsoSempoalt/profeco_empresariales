/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Alfon
 */
public class Profeco extends Usuario {

    private int id;

    public Profeco() {
    }

    public Profeco(String nomUsuario, String contrasenia, String areaUsuario) {
        super(nomUsuario, contrasenia, areaUsuario);
    }
    
    public Profeco(int id, String nomUsuario, String contrasenia, String areaUsuario) {
        super(nomUsuario, contrasenia, areaUsuario);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Profeco{" + "id=" + id + '}';
    }
    
    
}
