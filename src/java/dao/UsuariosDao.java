package dao;

import java.util.List;
import model.Usuarios;

public interface UsuariosDao {

    

    public Usuarios findByUsuario(Usuarios usuario);

    
    public Usuarios login(Usuarios usuario);

    public List<Usuarios> findAll();
    
    public boolean create(Usuarios usuario);

    public boolean delete(Integer id);

    public boolean update(Usuarios usuario);
}
