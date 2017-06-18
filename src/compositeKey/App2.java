package compositeKey;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import java.util.Date;

/**
 * Created by admin on 2017/6/17.
 */
public class App2 {

    private static SessionFactory sessionFactory;
    static {
        sessionFactory = new Configuration()
                .configure()
                .addClass(User.class)   //会自动加载映射文件：User.hbm.xml
                .buildSessionFactory();
    }
    @Test
    public void save() {
        //对象

        //3.根据session的工厂，创建session对象
        Session session = sessionFactory.openSession();

        //开启事物
        Transaction tx = session.beginTransaction();

        CompositeKey compositeKey = new CompositeKey();
        compositeKey.setAddress("广州");
        compositeKey.setUserName("Jack");
        User user = new User();
        user.setAge(23);
        user.setKeys(compositeKey);

        session.saveOrUpdate(user);

        tx.commit();
        //关闭
        session.close();
        sessionFactory.close();
    }
}
