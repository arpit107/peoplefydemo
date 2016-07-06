package com.peoplefy.service;

import java.util.List;

import com.peoplefy.model.ModelExample;

public interface CrudService {

	public List<ModelExample> retrieve();
	public String update(int id,String name);
	public String insert(ModelExample example);
}
