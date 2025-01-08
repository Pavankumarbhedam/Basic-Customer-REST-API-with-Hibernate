package com.pavan.DemoRestApi;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
public class CustomerRepository {
	 Customer customer=null;
	 List<Customer> list=null;
	 Configuration con=new Configuration().configure().addAnnotatedClass(Customer.class);
	 SessionFactory sf=con.buildSessionFactory();
	public List<Customer> getCustomers() {
		Session ses=sf.openSession();
		Query q1=ses.createQuery("from Customer",Customer.class);
		Transaction tx=ses.beginTransaction();
		list=q1.list();
		tx.commit();
		ses.close();
		return list;
	}
	
	public Customer getCustomer(int id) {
		Session ses=sf.openSession();
		Transaction tx=ses.beginTransaction();
		customer=ses.get(Customer.class, id);
		tx.commit();
		ses.close();
		return customer;
	}
	
	public void post(Customer customer) {
		Session ses=sf.openSession();
		Transaction tx=ses.beginTransaction();
		ses.persist(customer);
		tx.commit();
		ses.close();
		
	}

	public void update(Customer customer) {
		Session ses=sf.openSession();
		Query q1=ses.createNativeQuery("update Customer set cid = :id , cName = :name ,salary = :sal , designation = :des where cid = :id",Customer.class);
		q1.setParameter("id", customer.getCid());
		q1.setParameter("name", customer.getcName());
		q1.setParameter("sal", customer.getSalary());
		q1.setParameter("des", customer.getDesignation());
		Transaction tx=ses.beginTransaction();
		q1.executeUpdate();
		tx.commit();
		ses.close();
		
	}

	public void delete(int id) {
		Session ses=sf.openSession();
		Query q1=ses.createNativeQuery("delete from Customer where cid = :id",Customer.class);
		q1.setParameter("id", id);
		Transaction tx=ses.beginTransaction();
		q1.executeUpdate();
		tx.commit();
		ses.close();
	}
    
}
