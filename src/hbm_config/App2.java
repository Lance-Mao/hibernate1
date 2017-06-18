package hbm_config;

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
                .addClass(Employee.class)   //会自动加载映射文件：User.hbm.xml
                .buildSessionFactory();
    }
    @Test
    public void save() {
        //对象
        Employee emp = new Employee();
        emp.setEmpName("mao");
        emp.setWorkDate(new Date());
        //3.根据session的工厂，创建session对象
        Session session = sessionFactory.openSession();

        //开启事物
        Transaction tx = session.beginTransaction();

        session.saveOrUpdate(emp);
        tx.commit();
        //关闭
        session.close();
        sessionFactory.close();
    }

    @Test
    public void update() {
        //对象
        Employee emp = new Employee();
        emp.setEmpName("张三2");
        emp.setWorkDate(new Date());
        //3.根据session的工厂，创建session对象
        Session session = sessionFactory.openSession();

        //开启事物
        Transaction tx = session.beginTransaction();
        //执行更新的时候必须要设置主键
        //session.update(emp);

        //主键查询
        //Object o = session.get(Employee.class, 1);
        //System.out.println(o);

        //没有设置主键，执行保存，设置了主键，执行更新操作， 如果设置主键不存在，就会报错
        session.saveOrUpdate(emp);
        tx.commit();

        session.close();
        sessionFactory.close();

    }
}
