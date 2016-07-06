package com.peoplefy.controller;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.peoplefy.dao.CrudDaoImpl;
import com.peoplefy.model.ModelExample;
import com.peoplefy.model.Status;
import com.peoplefy.service.CrudServiceImpl;
import com.peoplefy.util.HibernateUtil;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@RequestMapping(value="/insert",method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public Status restEx()
	
	{
		CrudServiceImpl crudServiceImpl=new CrudServiceImpl();
		Status status=new Status();
		ModelExample modelExample=new ModelExample();
		modelExample.setId(1);
		modelExample.setName("Arpit");
		String retunValue=crudServiceImpl.insert(modelExample);
		if(retunValue.equals("success"))
		{
			status.setFlag("success");
		}
		else
		{
			status.setFlag("failed");
		}
		return status;
	}
	
	
	
	@RequestMapping(value="/retrieve",method=RequestMethod.GET)
	public List<ModelExample> retrieve()
	{
		CrudDaoImpl crudDao=new CrudDaoImpl();
		CrudServiceImpl crudServiceImpl=new CrudServiceImpl();
		List<ModelExample> list=crudServiceImpl.retrieve();

		
		return list;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public Status update(@RequestParam("id") int id,@RequestParam("name") String name)
	{
		Status status=new Status();
		//CrudDaoImpl crudDao=new CrudDaoImpl();
		CrudServiceImpl impl=new CrudServiceImpl();
		String returnValue=impl.update(id, name);
		if(returnValue.equals("success"))
		{
			status.setFlag("success");
		}
		else
		{
			status.setFlag("failed");
		}
		return status;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public Status delete(@RequestParam("id") int id)
	{
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Status status=new Status();
		Transaction transaction=null;
		try
		{
			transaction=session.beginTransaction();
			Query query=session.createSQLQuery("delete from ModelExample where id=:id");
			query.setInteger("id", id);
			query.executeUpdate();
			transaction.commit();
			status.setFlag("success");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
			status.setFlag("failed");
		}
		finally
		{
			session.close();
		}
		return status;
	}
}