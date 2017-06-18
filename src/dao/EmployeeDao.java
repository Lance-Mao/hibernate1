package dao;



import dedmo.Employee;

import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 2017/6/16.
 */
public interface EmployeeDao {

    void save(Employee employee);

    void update(Employee employee);

    Employee findById(Serializable id);

    List<Employee> getAll();

    List<Employee> getAll(String employeeName);

    List<Employee> getAll(int index, int count);

    void delete(Serializable id);
}
