package com.schoolmanagement.dao;

import com.schoolmanagement.model.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class ClassesDao {

	@Autowired
	HibernateTemplate hibernateTemplate;

	@Transactional
	public void saveClasses(Classes classes) {hibernateTemplate.save(classes);}

	public List<Classes> getAllClasses()
	{
		return hibernateTemplate.loadAll(Classes.class);
	}

	public Classes getById(Integer id) {return hibernateTemplate.get(Classes.class, id);}
	
	@Transactional
	public void updateClasses(Classes classes)
	{
		hibernateTemplate.update(classes);
	}
	
	@Transactional
	public void deleteClasses(Integer id)
	
	{
		hibernateTemplate.delete(hibernateTemplate.get(Classes.class, id));
	}

}



