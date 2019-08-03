package com.Imp;
import com.entity.menu;
import com.Dao.delDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class delImp implements delDao{
    private static SessionFactory factory;
    private Integer id = 6;

    @Override
    public void del() {
        System.out.println("it delete menu");
        try{
            factory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        Session session = factory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            menu menu = (com.entity.menu)session.get(com.entity.menu.class,6);
            session.delete(menu);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
