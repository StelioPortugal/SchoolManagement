package com.schoolmanagement.controller;

import com.schoolmanagement.dao.ClassesDao;
import com.schoolmanagement.dao.StudentDao;
import com.schoolmanagement.dao.SubjectDao;
import com.schoolmanagement.dao.TeacherDao;
import com.schoolmanagement.model.Classes;
import com.schoolmanagement.model.Student;
import com.schoolmanagement.model.Subject;
import com.schoolmanagement.model.Teacher;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping
public class HomeController {

	@Autowired
	private ClassesDao classesDao;

	@Autowired
	private SubjectDao subjectDao;

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private TeacherDao teacherDao;


	@GetMapping("/")
	public String home(Model m) {
		m.addAttribute("classesList", classesDao.getAllClasses());
		m.addAttribute("teachers", teacherDao.getAllTeacher());
		return "Home";
	}

	@GetMapping("manageStudent")
	public String  manageStudent(Model m) {
		m.addAttribute("students", studentDao.getAllStudent());
		return "ManageStudent";
	}

	@GetMapping("manageSubject")
	public String  manageSubject(Model m) {
		m.addAttribute("subjects", subjectDao.getAllSubject());
		return "ManageSubject";
	}

	@GetMapping("addSubject")
	public String  addSubject() {
		return "AddSubject";
	}

	@PostMapping("/insertSubject")
	public String insertSubject(@ModelAttribute("insertSubject") Subject subject) {
		subjectDao.saveSubject(subject);
		return "redirect:/";
	}

	@GetMapping("addClasses")
	public String  addClasses() {
		return "AddClasses";
	}

	@PostMapping("/insertClasses")
	public String insertClasses(@ModelAttribute("insertClasses") Classes classes) {
		classesDao.saveClasses(classes);
		return "redirect:/";
	}

	@GetMapping("addTeacher")
	public String  addTeacher() {
		return "AddTeacher";
	}

	@PostMapping("/insertTeacher")
	public String insertTeacher(@ModelAttribute("insertTeacher") Teacher teacher) {
		teacherDao.saveTeacher(teacher);
		return "redirect:/";
	}

	@GetMapping("addStudent")
	public String  addStudent(Model m) {
		m.addAttribute("classesList", classesDao.getAllClasses());
		return "AddStudent";
	}

	@PostMapping("/insertStudent")
	public String insertStudent(@RequestParam("name") String name, @RequestParam("email") String email) {
		Student student = new Student();
		student.setName(name);
		student.setEmail(email);
		studentDao.saveStudent(student);
		return "redirect:/";
	}

	@GetMapping("/viewClasses/{id}")
	public String  viewClasses(Model m, @PathVariable("id") Integer id) {
		Classes classes = classesDao.getById(id);
		m.addAttribute("subjects", classes.getSubjects());
		m.addAttribute("students", classes.getStudents());
		return "ViewClasses";
	}

	@GetMapping("viewClasses/assignTeacher/{id}")
	public String  assignTeacher(Model m, @PathVariable Integer id) {
		m.addAttribute("subjects", subjectDao.getAllSubject());
		m.addAttribute("teachers", teacherDao.getAllTeacher());
		m.addAttribute("id", id);
		return "AssignTeacher";
	}

	@PostMapping("viewClasses/assignTeacher/{id}")
	public String assignTeacher(@PathVariable("id") Integer id,@RequestParam("teacherId") Integer teacherId, @RequestParam("subjectId") Integer subjectId) {
		Classes classes = classesDao.getById(id);
		Teacher teacher = teacherDao.getById(teacherId);
		Subject subject = subjectDao.getById(subjectId);
		subject.getTeachers().add(teacher);
		subjectDao.updateSubject(subject);
		classes.getSubjects().add(subject);
		classesDao.updateClasses(classes);
		return "redirect:/viewClasses/"+id;
	}

	@GetMapping("assignClasses/{id}")
	public String  assignClasses(Model m, @PathVariable Integer id) {
		m.addAttribute("student",studentDao.getById(id));
		m.addAttribute("classesList", classesDao.getAllClasses());
		return "AssignClasses";
	}

	@PostMapping("assignClasses/{id}")
	public String assignClasses(@PathVariable("id") Integer id,
								@RequestParam("classesId") Integer classesId){
		Classes classes = classesDao.getById(classesId);
		Student student = studentDao.getById(id);
		student.setClasses(classes);
		studentDao.updateStudent(student);
		return "redirect:/manageStudent";
	}

	@GetMapping("viewTeacher/{id}")
	public String  viewTeacher(Model m, @PathVariable Integer id) {
		Teacher teacher = teacherDao.getById(id);
		m.addAttribute("teacher", teacher);
		List<Subject> subjects = teacher.getSubjects();
		m.addAttribute("subjects", subjects);
		return "ViewTeacher";
	}

	@GetMapping("deleteStudent/{id}")
	public String  deleteStudent(Model m, @PathVariable Integer id) {
		studentDao.deleteStudent(id);
		return "redirect:/manageStudent";
	}

	@GetMapping("deleteSubject/{id}")
	public String  deleteSubject(Model m, @PathVariable Integer id) {
		subjectDao.deleteSubject(id);
		return "redirect:/manageSubject";
	}

	@GetMapping("deleteTeacher/{id}")
	public String  deleteTeacher(Model m, @PathVariable Integer id) {
		teacherDao.deleteTeacher(id);
		return "redirect:/";
	}

//	@GetMapping("updateSubjectTeacher/{subjectId}/{classId}")
//	public String  updateSubjectTeacherForm(Model m, @PathVariable Integer subjectId, @PathVariable Integer classId) {
//		m.addAttribute("teachers", teacherDao.getAllTeacher());
//		m.addAttribute("subjects", subjectDao.getAllSubject());
//		m.addAttribute("subjectId", subjectId);
//		m.addAttribute("classId", classId);
//		return "UpdateTeacher";
//	}
//	}

	@GetMapping("deleteSubjectTeacher/{subjectId}/{classId}/{teacherId}")
	public String  deleteSubjectTeacher(Model m, @PathVariable Integer subjectId, @PathVariable Integer classId, @PathVariable Integer teacherId) {
		Classes classes = classesDao.getById(classId);
		List<Subject> subjects = classes.getSubjects().stream().filter(s -> s.getId()!=subjectId).collect(Collectors.toList());
		classes.setSubjects(subjects);
		Teacher teacher = teacherDao.getById(teacherId);
		List<Subject> subjectList = teacher.getSubjects().stream().filter(s -> s.getId()!=subjectId).collect(Collectors.toList());
		teacher.setSubjects(subjectList);
		classesDao.updateClasses(classes);
		teacherDao.updateTeacher(teacher);
		return "redirect:/viewClasses/"+classId;
	}

	@PostMapping("viewTeacher/{id}")
	public String viewTeacher(@PathVariable("id") Integer id,@RequestParam("teacherId") Integer teacherId, @RequestParam("subjectId") Integer subjectId) {
		Classes classes = classesDao.getById(id);
		Teacher teacher = teacherDao.getById(teacherId);
		Subject subject = subjectDao.getById(subjectId);
		subject.getTeachers().add(teacher);
		classes.getSubjects().add(subject);
		classesDao.updateClasses(classes);
		return "redirect:/viewTeacher/"+id;
	}

//	@GetMapping("/editEmployee/{id}")
//	public String lodeEditForm(@PathVariable(value="id") Long id, Model m)
//	{
//		Employee emp=employeeServices.getById(id);
//
//		System.out.println(emp);
//		m.addAttribute("employee", emp);
//		m.addAttribute("title", "Edit Employee");
//
//		return "EditEmployee";
//
//	}
//
//
//
//	@PostMapping("/editEmployee/updateEmployee")
//	public String updateEmp(@ModelAttribute("updateEmployee") Employee emp)
//	{
//		employeeServices.updateEmp(emp);
//
//		return "redirect:/employeeReport";
//
//	}
//
//
//
//
//	@GetMapping("/deleteEmployee/{id}")
//	public String deleteEmployee(@PathVariable Long id)
//	{
//		employeeServices.deleteEmployee(id);
//
//
//		return "redirect:/employeeReport";
//	}






}
