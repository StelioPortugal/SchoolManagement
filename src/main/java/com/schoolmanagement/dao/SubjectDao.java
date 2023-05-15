package com.schoolmanagement.dao;

import com.schoolmanagement.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class SubjectDao {
	@Autowired
	HibernateTemplate hibernateTemplate;

	@Transactional
	public void saveSubject(Subject subject)
	{
		hibernateTemplate.save(subject);
	}

	public List<Subject> getAllSubject()
	{
		return hibernateTemplate.loadAll(Subject.class);
	}

	public Subject getById(Integer id)
	{
		return hibernateTemplate.get(Subject.class, id);
	}

	@Transactional
	public void updateSubject(Subject subject)
	{
		hibernateTemplate.update(subject);
	}

	@Transactional
	public void deleteSubject(Integer id)

	{
		hibernateTemplate.delete(hibernateTemplate.get(Subject.class, id));
	}

//	@Transactional
//	public List<Subject> getSubjectsByClass(Integer id){
//		Object[] params  = {id};
//		return (List<Subject>) hibernateTemplate.find("select s.name from subject s where s.teacher.id=:id", params);
//	}
}



