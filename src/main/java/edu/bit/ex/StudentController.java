package edu.bit.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class StudentController {

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@RequestMapping("/studentForm")
	public String studentForm() {
		return "createPage";
	}

	@RequestMapping("/student/create")
	public String studentCreate(@ModelAttribute("student") Student student, BindingResult result) {

		String page = "createDonePage";

		StudentValidator validator = new StudentValidator();
		validator.validate(student, result);
		//errors가 부모

		if (result.hasErrors()) {
			page = "createPage";
			//에러가 있으면 createPage로(다시 회원가입 페이지로)
		}

		return page;
		//에러가 없으면 회원가입 완료 페이지로
	}
}
