package com.sd.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sd.app.constraint.Status;
import com.sd.app.model.Employee;


@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addEmployee(Employee employee) {
		employee.setStatus(Status.ADD.toString());
		sessionFactory.getCurrentSession().saveOrUpdate(employee);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> listEmployeess() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		List<Employee> listEmp = (List<Employee>)currentSession.createCriteria(Employee.class).add(Restrictions.ne("status", Status.DELETE.toString())).list();
		return listEmp;
		//return (List<Employee>) currentSession.createQuery("FROM Employee WHERE status!='"+Status.DELETE+"'").list();
		
	}

	public Employee getEmployee(int empid) {
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, empid);
	}

	public void deleteEmployee(Employee employee) {
		

		Employee employeeDb = getEmployee(employee.getId());
		employeeDb.setStatus(Status.DELETE.toString());
		 sessionFactory.getCurrentSession().flush();
		
		//sessionFactory.getCurrentSession().createQuery("DELETE FROM Employee WHERE empid = "+employee.getId()).executeUpdate();
	}

}
