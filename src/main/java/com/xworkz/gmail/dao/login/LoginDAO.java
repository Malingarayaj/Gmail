package com.xworkz.gmail.dao.login;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.gmail.dto.login.LoginDTO;

@Repository
public class LoginDAO {
	@Autowired
	private SessionFactory factory;

	public LoginDTO validate(LoginDTO dtoFromservice) {
		System.out.println("Entering the validate method of DAO");

		Session session = factory.openSession();
		try {
			Query query = session.getNamedQuery("read");
			query.setParameter("uname", dtoFromservice.getUserName());
			query.setParameter("password", dtoFromservice.getPassword());

			LoginDTO dtoFromDB = (LoginDTO) query.uniqueResult();
			System.out.println(dtoFromDB);
			return dtoFromDB;
		} catch (HibernateException e) {
			System.err.println("Exception occured" + e.getMessage());
			//return null;
		} finally {
			session.close();
		}
		return null;
	}

}
