package com.Imp;
import com.Dao.listDao;
import com.entity.menu;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class listImp  implements listDao{
    private static SessionFactory factory;

    @Override
    public void list() {
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
            List menus = session.createQuery("FROM menu ").list();
            for (Iterator iterator =
                 menus.iterator(); iterator.hasNext();){
                menu menu = (menu) iterator.next();
                System.out.print("id: " + menu.getId());
                System.out.print("  name: " + menu.getName());
                System.out.println("  price: " + menu.getPrice());
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
