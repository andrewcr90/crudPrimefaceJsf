package beans;

import dao.UsuariosDao;
import dao.UsuariosDaoImpl;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.Usuarios;

@Named(value = "UsuariosBean")
@RequestScoped
public class UsuarioBean {

    private List<Usuarios> usuarios;
    private Usuarios selectedUsuario;

    public UsuarioBean() {
        this.usuarios = new ArrayList<Usuarios>();
        if (this.selectedUsuario == null) {
            this.selectedUsuario = new Usuarios();
        }
    }

    public List<Usuarios> getUsuarios() {
        UsuariosDao usuarioDao = new UsuariosDaoImpl();
        this.usuarios = usuarioDao.findAll();
        return usuarios;
    }

    public Usuarios getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(Usuarios selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }

    public void btnCreateUsuario(ActionEvent actionEvent) {
        UsuariosDao usuarioDao = new UsuariosDaoImpl();
        String msg;
            if (usuarioDao.create(this.selectedUsuario)) {
            msg = "Se creo correctamente el registro";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al crear el registro";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void btnDeleteUsuario(ActionEvent actionEvent) {
        System.out.println("ENBORRARUSUARIO");
        UsuariosDao usuarioDao = new UsuariosDaoImpl();
        String msg;
        System.out.println("Usuario Seleccionado " + this.selectedUsuario.getId());
        if (usuarioDao.delete(this.selectedUsuario.getId())) {
            msg = "Se elimino correctamente el registro";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al eliminar el registro";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void btnUpdateUsuario(ActionEvent actionEvent) {
        UsuariosDao usuarioDao = new UsuariosDaoImpl();
        String msg;
        if (usuarioDao.update(this.selectedUsuario)) {
            msg = "Se modificó correctamente el registro";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al modificar el registro";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}
