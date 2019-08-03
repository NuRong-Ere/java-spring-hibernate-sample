package Test;

import org.springframework.test.context.TestExecutionListeners;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class test2 {

    public void  test(){
        Configuration config = new Configuration();
        config.configure();
        //获取数据库的连接池
        SessionFactory factory = config.buildSessionFactory();
        System.out.println(factory);

    }
}
