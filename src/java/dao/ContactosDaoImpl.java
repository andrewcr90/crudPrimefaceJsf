package dao;

import dao.ContactosDao;
import java.util.List;
import model.Contactos;
import org.hibernate.Session;
import util.HibernateUtil;

public class ContactosDaoImpl implements ContactosDao {

    @Override
    public List<Contactos> findByUsuario(int usuario) {

        Contactos model = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql = "from Contactos where idUsuario='" + usuario + "'";
        try {
            sesion.beginTransaction();
            model = (Contactos) sesion.createQuery(sql).uniqueResult();
            sesion.beginTransaction().commit();
        } catch (Exception e) {
            sesion.beginTransaction().rollback();
        }

        return (List<Contactos>) model;
    }

    @Override
    public List<Contactos> findAll(int id) {
        List<Contactos> listado = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql = "from Contactos where idUsuario = " +id;
        try {
            System.out.print("sql+++" + sql);
            sesion.beginTransaction();
            listado = sesion.createQuery(sql).list();
            sesion.beginTransaction().commit();
        } catch (Exception e) {
            sesion.beginTransaction().rollback();
        }
        return listado;
    }

    @Override
    public List<Contactos> findAll2() {
       List<Contactos> listado = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql = "from Contactos";
        try {
            sesion.beginTransaction();
            listado = sesion.createQuery(sql).list();
            sesion.beginTransaction().commit();
        } catch (Exception e) {
            sesion.beginTransaction().rollback();
        }
        return listado;
    }

}
