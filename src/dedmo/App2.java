package dedmo;

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
//        //1,创建配置管理类对象
//        Configuration config = new Configuration();
//        //加载配置文件（默认加载src/hibernate.cfg.xml这个配置文件）
//        config.configure();
//
//        //2,根据加载的配置管理类对象，创建SessionFactory对象
//        sessionFactory = config.buildSessionFactory();

        //创建sessionFactory对象
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    @Test
    public void save() {
        //对象
        Employee emp = new Employee();
        emp.setEmpName("lisi");
        emp.setWorkDate(new Date());
        //3.根据session的工厂，创建session对象
        Session session = sessionFactory.openSession();
        session.save(emp);

        //开启事物
        Transaction tx = session.beginTransaction();
        tx.commit();
        //关闭
        session.close();
        sessionFactory.close();
    }

    @Test
    public void update() {
        //对象
        Employee emp = new Employee();
        emp.setEmpId(3);
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
