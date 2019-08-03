package com.proxy;
import com.Dao.delDao;
import com.Dao.addDao;
import com.entity.menu;
import com.Dao.listDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;


public class menuProxy {
    private menu menu;
    private addDao add;
    private delDao del;
    private listDao list;
    private static SessionFactory factory;



    public void addmenu(){

        add.add(menu);
    }

    public void delmenu(){
        del.del();
    }

    public void listmenu(){
        list.list();
    }

    public void setAdd(addDao add) {
        this.add = add;
    }

    public addDao getAdd() {
        return add;
    }

    public void setDel(delDao del) {
        this.del = del;
    }

    public delDao getDel() {
        return del;
    }

    public void setMenu(com.entity.menu menu) {
        this.menu = menu;
    }

    public com.entity.menu getMenu() {
        return menu;
    }

    public void setList(listDao list) {
        this.list = list;
    }

    public listDao getList() {
        return list;
    }
}
