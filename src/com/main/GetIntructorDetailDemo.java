package com.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Instructor;
import com.entity.InstructorDetail;
import com.entity.Student;

public class GetIntructorDetailDemo {

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
			
			// get the instructor detail object
			int instDetKey = 123;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, instDetKey);
						
			
			// print the instructor detail
			System.out.println("instructor detail:");
			System.out.println(instructorDetail);
			
			
			// print the associated instructor
			System.out.println("\nassociated instructor:");
		
			System.out.println(instructorDetail.getInstructor());
			
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
