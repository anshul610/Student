package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ConnectionFactroy.ConnectionFactory;
import com.bean.Student;

public class StudentServiceImpl implements StudentService {

	@Override
	public void addStudent(Student std) {
		try {
			Connection con =ConnectionFactory.getConnection();
			PreparedStatement pst= con.prepareStatement("insert into studentinc values(?,?,?)");
			pst.setString(1, std.getSid());
			pst.setString(2, std.getSname());
			pst.setString(3, std.getSaddress());
			pst.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student>std_list= null;
		try {
			Connection con =ConnectionFactory.getConnection();
			PreparedStatement pst= con.prepareStatement("select * from studentinc ");
			ResultSet rs= pst.executeQuery();
		std_list = new ArrayList<Student>();
		while(rs.next()) {
			Student std= new Student();
			std.setSid(rs.getString("SID"));
			std.setSname(rs.getString("SNAME"));
			std.setSaddress(rs.getString("SADDRESS"));
			std_list.add(std);
		}
		}catch(Exception e) {}
		return std_list;
	}

}
