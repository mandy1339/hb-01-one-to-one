package com.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Instructor;
import com.entity.InstructorDetail;
import com.entity.Student;

public class Test {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {			
			
			
			
			// start a transaction
			session.beginTransaction();
			
			// load nagini
			Instructor nagini = session.get(Instructor.class, 4);
			System.out.println("got instructor: " + nagini);
			
			List<Instructor> teachers = session.createQuery("from Instructor").getResultList();
			for (Instructor i : teachers) {
				System.out.println(i);
			}
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
