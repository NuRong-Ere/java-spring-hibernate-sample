package Test;
import com.proxy.menuProxy;
import com.entity.menu;
import java.util.List;
import java.util.Iterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;


public class test {
    private static SessionFactory factory;
    public static void main(String[] args) {

        ApplicationContext cd = new ClassPathXmlApplicationContext("Application.xml");
        menuProxy c1 = (menuProxy) cd.getBean("proxy");
        c1.addmenu();
        c1.listmenu();
    }









}
