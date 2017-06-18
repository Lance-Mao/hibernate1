package dao.impl;


import dao.EmployeeDao;
import dedmo.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 2017/6/16.
 */
public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void save(Employee employee) {
        Session session = null;
        Transaction tx = null;
        try {
            //创建session
            session = HibernateUtil.getSession();
            //开启事务
            tx = session.beginTransaction();
            //执行保存操作
            session.save(employee);

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public void update(Employee employee) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            session.update(employee);
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public Employee findById(Serializable id) {
        Session session = null;
        Transaction tx = null;
        try {
            //获取session
            session = HibernateUtil.getSession();
            //开启事物
            tx = session.beginTransaction();
            //主键查询
            return (Employee) session.get(Employee.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            tx.commit();
            session.close();
        }

        return null;
    }

    @Override
    public List<Employee> getAll() {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            //HQL查询
            Query query = session.createQuery("from Employee ");
            return query.list();
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public List<Employee> getAll(String employeeName) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();

            Query query = session.createQuery("from Employee where empName = ?");
            query.setParameter(0, employeeName);
            //执行查询
            return query.list();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public List<Employee> getAll(int index, int count) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            Query query = session.createQuery("from Employee ");
            //设置分页参数
            query.setFirstResult(index);   //查询的起始行
             query.setMaxResults(count);  //查询返回的行数
            List<Employee> list = query.list();
            return list;
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public void delete(Serializable id) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            //先根据id查询对象，在判断删除
            Object o = session.get(Employee.class, id);
            if (o != null) {
                session.delete(o);
            }
            //执行查询

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            tx.commit();
            session.close();
        }
    }


}
