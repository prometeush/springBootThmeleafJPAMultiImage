package com.project.control;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.entity.Student;
import com.project.service.StudentService;



@Controller
public class StudentController {
	
	@Autowired
	private StudentService service5;
	
	
	@RequestMapping("/")
	public String indexPage() {
		return "home";
	}
	
	@RequestMapping("/studentinfo")
	public String studentList(Model model) {
		List<Student> list=this.service5.studentList();
		model.addAttribute("studentlist", list);
		return "student-info";
	}
	
	@RequestMapping("/studentform")
	public String studentForm(Model model) {		
		model.addAttribute("studentmodel", new Student());
		 List<String> list1=Arrays.asList("Java","Spring Boot","Spring MVC","JSP","JSF","Thymeleaf",
				  "Angular","Javascript","jQuery","Bootstrap 4","HTML5","CSS3");
		  Collections.sort(list1);
		  model.addAttribute("proglist", list1);
		return "student-form";
	}
	
	@RequestMapping("/studentSave")
	public String studentSave(@Valid @ModelAttribute("studentmodel") Student student,Model model,
			@RequestParam("primaryImage")MultipartFile mainMultipartFile,
			@RequestParam("extraImage")MultipartFile[] extraMultipartFiles,RedirectAttributes ra) throws Exception {
		
		 String mainImageName=StringUtils.cleanPath(mainMultipartFile.getOriginalFilename());
		 student.setMainImage(mainImageName);
		 
		 int count=0;
		 
		 for (MultipartFile extraMultipart : extraMultipartFiles) {
			 
		      String extraImageName=StringUtils.cleanPath(extraMultipart.getOriginalFilename());
		 
				if(count==0) student.setExtraImage1(extraImageName);
				if(count==1) student.setExtraImage2(extraImageName);
				if(count==2) student.setExtraImage3(extraImageName);
			    
			    count++;
		}
		 
		
		 Student studentHinzu=this.service5.studentSave(student);
		 
		 String uploadDir="./student-picture/"+studentHinzu.getId();
		 
		 FileUploadUtill.saveFile(uploadDir, mainMultipartFile, mainImageName);
		 
		 for (MultipartFile extraMultipart : extraMultipartFiles) {
			 String fileName=StringUtils.cleanPath(extraMultipart.getOriginalFilename());
			 
		     FileUploadUtill.saveFile(uploadDir, extraMultipart, fileName);
		}
		
		
			return "redirect:/studentinfo";
		}
		
	
	
	@RequestMapping("/delete/{id}")
	public String studentDelete(@PathVariable("id") Integer id) {
		this.service5.studentDelete(id);
		return "redirect:/studentinfo";
	}
	@RequestMapping("/update/{id}")
	public String studentUpdate(@PathVariable("id") Integer id,Model model) {
	      Student student=this.service5.studentFindById(id);
	      model.addAttribute("studentmodel", student);
	      List<String> list1=Arrays.asList("Java","Spring Boot","Spring MVC","JSP","JSF","Thymeleaf",
				  "Angular","Javascript","jQuery","Bootstrap 4","HTML5","CSS3");
		  Collections.sort(list1);
		  model.addAttribute("proglist", list1);
		return "student-form";
	}
	@RequestMapping("/imageform")
	public String imagePage(Model model) {
		List<Student> list=this.service5.studentList();
		model.addAttribute("imagelist", list);
		return "image-form";
	}

}
