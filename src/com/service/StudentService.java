package com.service;

import java.util.List;

import com.bean.Student;

public interface StudentService {
   void addStudent(Student std);
   List<Student>getAllStudents();
}
