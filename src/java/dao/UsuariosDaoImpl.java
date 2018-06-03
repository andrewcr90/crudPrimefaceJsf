package dao;

import java.util.List;
import model.Usuarios;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import util.HibernateUtil;

public class UsuariosDaoImpl implements UsuariosDao {

    @Override
    public Usuarios findByUsuario(Usuarios usuario) {
        Usuarios model = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql = "from Usuarios where usuario='" + usuario.getUsuario() + "'";
        try {
            sesion.beginTransaction();
            model = (Usuarios) sesion.createQuery(sql).uniqueResult();
            sesion.beginTransaction().commit();
        } catch (Exception e) {
            sesion.beginTransaction().rollback();
        }
        return model;

    }

    @Override
    public Usuarios login(Usuarios usuario) {
        Usuarios model = this.findByUsuario(usuario);
        if (model != null && !usuario.getClave().equals(model.getClave())) {
            model = null;
        }
        return model;
    }

    @Override
    public List<Usuarios> findAll() {
        List<Usuarios> listado = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql = "from Usuarios";
        try {
            sesion.beginTransaction();
            listado = sesion.createQuery(sql).list();
            sesion.beginTransaction().commit();
        } catch (Exception e) {
            sesion.beginTransaction().rollback();
        }
        return listado;
    }

    @Override
    public boolean create(Usuarios usuario) {
        Boolean flag;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            sesion.beginTransaction();
            sesion.save(usuario);
            sesion.beginTransaction().commit();
            flag = true;
        } catch (Exception e) {
            flag = false;
            sesion.beginTransaction().rollback();
        }
        return flag;
    }

    @Override
    public boolean delete(Integer id) {
        Boolean flag;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            sesion.beginTransaction();
            Usuarios usuario = (Usuarios) sesion.load(Usuarios.class, id);
            sesion.delete(usuario);
            sesion.beginTransaction().commit();
            flag = true;
        } catch (Exception e) {
            flag = false;
            sesion.beginTransaction().rollback();
        }
        return flag;
    }

    @Override
    public boolean update(Usuarios usuario) {
        Boolean flag;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            sesion.beginTransaction();
            sesion.update(usuario);
            sesion.beginTransaction().commit();
            flag = true;
        } catch (Exception e) {
            flag = false;
            sesion.beginTransaction().rollback();
        }
        return flag;
    }
}
