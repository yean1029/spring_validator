package edu.bit.ex;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return false;
	}

	@Override
	public void validate(Object obj, Errors errors) {
		System.out.println("validate()");
		Student student = (Student)obj;
		
		 String studentName = student.getName();  //studentName을 검증하는것!
		if(studentName == null || studentName.trim().isEmpty()) {
			 System.out.println("studentName is null or empty");
	         
	         errors.rejectValue("name", "trouble");
	      } 
		
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "trouble");
	      
	    int studentId = student.getId();
	    if(studentId == 0) {
	       System.out.println("studentId is 0");
	         
	       errors.rejectValue("id", "trouble");
	       //("id", "trouble"); 여기는 개발자가 작성하면 되는 부분!
	    }
	}
}