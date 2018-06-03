package model;

public class Contactos  implements java.io.Serializable {


     private Integer idContacto;
     private Usuarios usuarios;
     private String nombre;
     private int telefono;
     private String direccion;

    public Contactos() {
    }

    public Contactos(Usuarios usuarios, String nombre, int telefono, String direccion) {
       this.usuarios = usuarios;
       this.nombre = nombre;
       this.telefono = telefono;
       this.direccion = direccion;
    }
   
    public Integer getIdContacto() {
        return this.idContacto;
    }
    
    public void setIdContacto(Integer idContacto) {
        this.idContacto = idContacto;
    }
    public Usuarios getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }




}


