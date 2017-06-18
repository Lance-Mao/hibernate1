package dao;

import dao.impl.EmployeeDaoImpl;
import dedmo.Employee;

import java.util.Date;

/**
 * Created by admin on 2017/6/17.
 */
public class Test {
    private Employee emp = new Employee();
    private EmployeeDao employeeDao = new EmployeeDaoImpl();
    @org.junit.Test
    public void test() {

        emp.setEmpName("Jack");
        emp.setWorkDate(new Date());
        employeeDao.save(emp);
    }

    @org.junit.Test
    public void test1() {

        emp.setEmpId(2);
        emp.setEmpName("Jack");
        emp.setWorkDate(new Date());
        employeeDao.update(emp);
    }

    @org.junit.Test
    public void test2() {

        emp.setEmpId(2);
        emp.setEmpName("Jack");
        emp.setWorkDate(new Date());
        System.out.println(employeeDao.getAll(0,2));
    }

    @org.junit.Test
    public void test3() {

        emp.setEmpId(2);
        emp.setEmpName("Jack");
        emp.setWorkDate(new Date());
        employeeDao.findById(3);
    }
}
