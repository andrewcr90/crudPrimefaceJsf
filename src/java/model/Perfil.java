package model;



import java.util.HashSet;
import java.util.Set;


public class Perfil  implements java.io.Serializable {


     private Integer id;
     private String descripcion;
     private Boolean createPerfil;
     private Boolean updatePerfil;
     private Boolean readPerfil;
     private Boolean deletePerfil;
     private Set usuarioses = new HashSet(0);

    public Perfil() {
    }

    public Perfil(String descripcion, Boolean createPerfil, Boolean updatePerfil, Boolean readPerfil, Boolean deletePerfil, Set usuarioses) {
       this.descripcion = descripcion;
       this.createPerfil = createPerfil;
       this.updatePerfil = updatePerfil;
       this.readPerfil = readPerfil;
       this.deletePerfil = deletePerfil;
       this.usuarioses = usuarioses;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Boolean getCreatePerfil() {
        return this.createPerfil;
    }
    
    public void setCreatePerfil(Boolean createPerfil) {
        this.createPerfil = createPerfil;
    }
    public Boolean getUpdatePerfil() {
        return this.updatePerfil;
    }
    
    public void setUpdatePerfil(Boolean updatePerfil) {
        this.updatePerfil = updatePerfil;
    }
    public Boolean getReadPerfil() {
        return this.readPerfil;
    }
    
    public void setReadPerfil(Boolean readPerfil) {
        this.readPerfil = readPerfil;
    }
    public Boolean getDeletePerfil() {
        return this.deletePerfil;
    }
    
    public void setDeletePerfil(Boolean deletePerfil) {
        this.deletePerfil = deletePerfil;
    }
    public Set getUsuarioses() {
        return this.usuarioses;
    }
    
    public void setUsuarioses(Set usuarioses) {
        this.usuarioses = usuarioses;
    }




}


