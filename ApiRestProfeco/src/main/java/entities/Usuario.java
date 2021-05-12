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
public class Usuario {
    private String nomUsuario;
    private String contrasenia;
    private String areaUsuario;

    public Usuario() {
    }

    public Usuario(String nomUsuario, String contrasenia, String areaUsuario) {
        this.nomUsuario = nomUsuario;
        this.contrasenia = contrasenia;
        this.areaUsuario = areaUsuario;
    }
    
    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getAreaUsuario() {
        return areaUsuario;
    }

    public void setAreaUsuario(String areaUsuario) {
        this.areaUsuario = areaUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nomUsuario=" + nomUsuario + ", contrasenia=" + contrasenia + ", areaUsuario=" + areaUsuario + '}';
    }
    
    
}
