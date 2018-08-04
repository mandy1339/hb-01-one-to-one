package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Instructor;
import com.entity.InstructorDetail;
import com.entity.Student;

public class DeleteInstructorDetailCascade {

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
			
			// get instructor detail by primary key / id
			int theId = 2;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			System.out.println("Found instructorDetail: " + tempInstructorDetail);
			
			// delete the instructor detail
			if (tempInstructorDetail != null) {
				System.out.println("Deleting: " + tempInstructorDetail);

				// Note: will ALSO delete associated "instructor" object because of CascadeType.ALL 
				session.delete(tempInstructorDetail);
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
