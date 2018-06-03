package beans;

import dao.UsuariosDao;
import dao.UsuariosDaoImpl;
import java.awt.event.ActionEvent;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.Usuarios;
import org.primefaces.context.RequestContext;
import util.MyUtil;

@Named(value = "loginBean")
@SessionScoped
public class loginBean implements Serializable {

    private Usuarios usuario;
    private UsuariosDao usuariosdao;

    public loginBean() {
        
        this.usuariosdao = new UsuariosDaoImpl();
        if (this.usuario == null) {
            
            this.usuario = new Usuarios();
        }
    }

    
    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public void login(ActionEvent actionEvent) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg;
        boolean loggedIn;
        String ruta = "";

        this.usuario = this.usuariosdao.login(this.usuario);
        if (this.usuario != null) {
            loggedIn = true;

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getUsuario());
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getUsuario());

            ruta = MyUtil.basepathLogin() + "views/inicio.xhtml";
          
            
        } else {
            loggedIn = false;
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");
            if (this.usuario == null) {
                this.usuario = new Usuarios();
            }
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("loggedIn", loggedIn);
        //pasamos el parametro ruta
        context.addCallbackParam("ruta", ruta);
    }

    public void logout() {
        String ruta = MyUtil.basepathLogin() + "index.xhtml";
        RequestContext context = RequestContext.getCurrentInstance();
        FacesContext facesContext = FacesContext.getCurrentInstance();

        HttpSession sesion = (HttpSession) facesContext.getExternalContext().getSession(false);
        sesion.invalidate();

        context.addCallbackParam("loggedOut", true);
        context.addCallbackParam("ruta", ruta);
    }

}
