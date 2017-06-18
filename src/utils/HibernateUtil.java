package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by admin on 2017/6/17.
 */
public class HibernateUtil {

    private static SessionFactory sf;
    static {
        //加载主配文件,并创建session的工厂
        sf = new Configuration().configure().buildSessionFactory();
    }

    //创建session对象
    public static Session getSession() {
        return sf.openSession();
    }
}
