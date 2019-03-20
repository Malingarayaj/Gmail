package com.xworkz.gmail.service.register;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.xworkz.gmail.dao.register.RegisterDAO;
import com.xworkz.gmail.dto.register.RegisterDTO;

@Service
public class RegisterService {
	@Autowired
	private RegisterDAO dao;
	
	@Autowired
	private JavaMailSender mailSender;

	public RegisterDTO saveToDAO(RegisterDTO dto) {

		System.out.println("Entering saveToDAO in service class");
		try {
			if (!StringUtils.isEmpty(dto.getCname()) && !StringUtils.isEmpty(dto.getEmail())
					&& !StringUtils.isEmpty(dto.getPassword())) {
				System.out.println("First step validation completed");
				if (Objects.nonNull(dto.getCmobileNo()) && Objects.nonNull(dto.getDob())) {
					System.out.println("Second step validation completed");
					RegisterDTO dtoFromDB = dao.saveToDb(dto);
					
					SimpleMailMessage msg=new SimpleMailMessage();
					System.out.println(dto.getEmail());
					msg.setTo(dto.getEmail());
					msg.setSubject("registratin confirmation male");
					msg.setText("hi"+dto.getCname()+",\n"+"registration successful");
					mailSender.send(msg);
					return dtoFromDB;
				}
			}
		} catch (Exception e) {
			System.err.println("Object cannot be saved due to some Exception:" + e.getMessage());
		}
		return null;
	}
}
