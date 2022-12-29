package com.querylevelcache;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Std_Main {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		// Pass the class name & id for updating record

		System.out.println("First Query.................");

		Query query = session.createQuery("from Student");

		query.setCacheable(true);

		List<Student> students = query.list();

		for (Student student : students) {

			System.out.println("I'd > " + student.getId());
			System.out.println("City > " + student.getCity());
			System.out.println("Mobile > " + student.getMobile());
			System.out.println("Name > " + student.getName());

		}

		session.close();
		sessionFactory.close();

		System.out.println("Record Retrieved Successfully........");

	}

}
