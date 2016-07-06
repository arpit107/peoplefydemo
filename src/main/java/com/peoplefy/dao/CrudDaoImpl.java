package com.peoplefy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.peoplefy.model.ModelExample;
import com.peoplefy.model.Status;
import com.peoplefy.util.HibernateUtil;

public class CrudDaoImpl implements CrudDao{

	@Override
	public List<ModelExample> retrieve() {

		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		List<ModelExample> list=null;
		Transaction transaction=null;
		try
		{
			transaction=session.beginTransaction();
			list=session.createQuery("from ModelExample").list();
			transaction.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			transaction.rollback();
		}
		finally
		{
			session.close();
		}
		return list;
	}

	@Override
	public String update(int id, String name) {
		
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=null;
		Status status=new Status();
		int flag=0;
		try
		{
			transaction=session.beginTransaction();
			Query query=session.createSQLQuery("update ModelExample set name=:name where id=:id");
			query.setInteger("id", id);
			query.setString("name", name);
			query.executeUpdate();
			transaction.commit();
			flag=1;
			
		}
		catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
			flag=0;
		}
		finally
		{
			session.close();
		}
		if(flag==1)
		{
			return "success";
		}
		else
		{
			return "failed";
		}
	
	}

	@Override
	public String insert(ModelExample example) {

		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=null;
		try
		{
			transaction=session.beginTransaction();
			session.save(example);
			transaction.commit();
			session.close();
			return "success";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			transaction.rollback();
			return "failed";
		}
		finally
		{
			session.close();
		}
	}

	
	

	
}
