package com.chen.service;

import com.chen.pojo.Student;
import com.chen.pojo.User;

public interface LoginService {

	User login(String idNumber, String password);

	boolean studentlogin(String name,String password);
	
	public Student queryStudentById(String loginUser);
	
	public int updateStudentPad(String id,String newPad);

}