/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.ContactosDao;
import dao.ContactosDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import model.Contactos;
import beans.loginBean;
import  beans.UsuarioBean;

@Named(value = "contactosBean")
@RequestScoped
public class ContactosBean {


    private List<Contactos> contactos;
    private List<Contactos> contactosUsuario;
    private Contactos selectedContactos;
    
    loginBean login;
    UsuarioBean usuario;
    
    public ContactosBean() {
        this.contactos = new ArrayList<Contactos>();
        if (this.selectedContactos == null) {
            this.selectedContactos = new Contactos();
        }
    }


    
    public List<Contactos> getContactos() {        
        ContactosDao contactosDao = new ContactosDaoImpl();
        this.contactos = contactosDao.findAll2();
        return contactos;
    }
    
    public List<Contactos> obtenerContactos(int id) {        
        ContactosDao contactosDao = new ContactosDaoImpl();
        this.contactosUsuario = contactosDao.findAll(id);
        return contactosUsuario;
    }
    

    public Contactos getSelectedContactos() {
        return selectedContactos;
    }

    public void setSelectedContactos(Contactos selectedContactos) {
        this.selectedContactos = selectedContactos;
    }
}