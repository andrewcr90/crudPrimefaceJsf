
package dao;

import beans.loginBean;
import java.util.List;
import model.Contactos;



public interface ContactosDao {
    
    public List<Contactos> findByUsuario(int usuario);

    public List<Contactos> findAll(int id);
    
    public List<Contactos> findAll2();
}
