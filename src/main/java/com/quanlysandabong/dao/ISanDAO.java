package com.quanlysandabong.dao;

import java.util.List;

import com.quanlysandabong.model.SanModel;

public interface ISanDAO extends GenericDAO<SanModel>{
	List<SanModel> findAll(); 
}
