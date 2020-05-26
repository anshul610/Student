package com.factory;

import com.service.StudentService;
import com.service.StudentServiceImpl;

public class StudentSerivceFactory {
     static StudentService stdService;
     static {
    	 stdService = new StudentServiceImpl();
     }
     public static StudentService getStudentService() {
    	 return stdService;
     }
}
