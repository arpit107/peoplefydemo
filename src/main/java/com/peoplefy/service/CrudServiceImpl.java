package com.peoplefy.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.peoplefy.dao.CrudDaoImpl;
import com.peoplefy.model.ModelExample;
import com.peoplefy.model.Status;
import com.peoplefy.util.HibernateUtil;

public class CrudServiceImpl implements CrudService {

	@Override
	public List<ModelExample> retrieve() {
		CrudDaoImpl crudDaoImpl=new CrudDaoImpl();
		List<ModelExample> list=crudDaoImpl.retrieve();
		
		return list;
	}

	@Override
	public String update(int id, String name) {
		CrudDaoImpl crudDaoImpl=new CrudDaoImpl();
		String returnValue=crudDaoImpl.update(id, name);
		return returnValue;
	}

	@Override
	public String insert(ModelExample example) {

		CrudDaoImpl crudDaoImpl=new CrudDaoImpl();
		String returnValue=crudDaoImpl.insert(example);
		return returnValue;
	}

	
	
}
