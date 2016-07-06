package com.peoplefy.dao;

import java.util.List;

import com.peoplefy.model.ModelExample;

public interface CrudDao {

	public List<ModelExample> retrieve();
	public String update(int id,String name);
	public String insert(ModelExample example);
}
