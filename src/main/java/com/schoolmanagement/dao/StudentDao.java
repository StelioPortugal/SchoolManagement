package com.schoolmanagement.dao;

import java.util.List;

import javax.transaction.Transactional;

import com.schoolmanagement.model.Student;
import com.schoolmanagement.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component
public class StudentDao {
	@Autowired
	HibernateTemplate hibernateTemplate;

	@Transactional
	public void saveStudent(Student student)
	{
		hibernateTemplate.save(student);
	}

	public List<Student> getAllStudent()
	{
		return hibernateTemplate.loadAll(Student.class);
	}

	public Student getById(Integer id)
	{
		return hibernateTemplate.get(Student.class, id);
	}

	@Transactional
	public void updateStudent(Student student)
	{
		hibernateTemplate.update(student);
	}

	@Transactional
	public void deleteStudent(Integer id)

	{
		hibernateTemplate.delete(hibernateTemplate.get(Student.class, id));
	}

//	@Transactional
//	public List<Student> getStudentsByClass(Integer id){
//		Object[] params  = {id};
//		return (List<Student>) hibernateTemplate.find("select * from student as s where s.teacher.id=:id", params);
//	}
}



