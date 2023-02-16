package com.chen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.dao.LoginMapper;
import com.chen.dao.StudentMapper;
import com.chen.pojo.Student;
import com.chen.pojo.User;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private StudentMapper studentMapper;

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public void setUserMapper(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    @Override
    public User login(String idNumber, String password) {



        return  loginMapper.findUserById(idNumber);
    }

    @Override
    public boolean studentlogin(String name, String password) {
        return false;
    }


    @Override
    public Student queryStudentById(String loginUser) {
        return studentMapper.queryStudentById(loginUser);
    }

    @Override
    public int updateStudentPad(String id, String newPad) {
        return studentMapper.changePwd(id, newPad);
    }


}
