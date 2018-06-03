package model;

import java.util.HashSet;
import java.util.Set;

public class Usuarios implements java.io.Serializable {

    private Integer id;
    private Perfil perfil;
    private String usuario;
    private String clave;
    private String rol;
    private Set contactoses = new HashSet(0);

    public Usuarios() {
    }

    public Usuarios(Perfil perfil, String usuario, String clave, String rol, Set contactoses) {
        this.perfil = perfil;
        this.usuario = usuario;
        this.clave = clave;
        this.rol = rol;
        this.contactoses = contactoses;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Perfil getPerfil() {
        return this.perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return this.clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRol() {
        return this.rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Set getContactoses() {
        return this.contactoses;
    }

    public void setContactoses(Set contactoses) {
        this.contactoses = contactoses;
    }

}
