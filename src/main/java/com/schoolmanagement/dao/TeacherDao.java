package com.schoolmanagement.dao;

import com.schoolmanagement.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class TeacherDao {
	@Autowired
	HibernateTemplate hibernateTemplate;

	@Transactional
	public void saveTeacher(Teacher teacher)
	{
		hibernateTemplate.save(teacher);
	}

	public List<Teacher> getAllTeacher()
	{
		return hibernateTemplate.loadAll(Teacher.class);
	}

	public Teacher getById(Integer id)
	{
		return hibernateTemplate.get(Teacher.class, id);
	}

	@Transactional
	public void updateTeacher(Teacher teacher)
	{
		hibernateTemplate.update(teacher);
	}

	@Transactional
	public void deleteTeacher(Integer id)

	{
		hibernateTemplate.delete(hibernateTemplate.get(Teacher.class, id));
	}

}



