package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Instructor;
import com.entity.InstructorDetail;
import com.entity.Student;

public class SaveInstructorDetailCascade {

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
			// create the objects
			Instructor instructor1 = new Instructor("Benjamin", "Toledo", "benji1339@gmail.com");
			InstructorDetail instructorDetail1 = new InstructorDetail("benji@youtube.com", "exploring");
			
			// associate the objects
			// Note: this will ALSO save the details object because of CascadeType.ALL
			instructorDetail1.setInstructor(instructor1);
			instructor1.setInstructorDetail(instructorDetail1);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			System.out.println("Saving instructor: " + instructorDetail1);
			session.save(instructorDetail1);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
