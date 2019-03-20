package com.xworkz.gmail.dao.register;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.gmail.dto.register.RegisterDTO;

@Repository
public class RegisterDAO {
	@Autowired
	private SessionFactory factory;

	public RegisterDTO saveToDb(RegisterDTO dtoTosave) throws Exception {
		System.out.println("calling savetodb in dao");
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(dtoTosave);
			tx.commit();
			System.out.println("data succfully saved in db" + dtoTosave);
			return dtoTosave;
		} catch (HibernateException e) {
			System.out.println("unsuccfully saved in db due to some exception" + e.getMessage());
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}

		return null;
	}

}
