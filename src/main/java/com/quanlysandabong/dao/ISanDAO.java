package com.quanlysandabong.dao;

import java.util.List;

import com.quanlysandabong.model.SanModel;

public interface ISanDAO extends GenericDAO<SanModel>{
	SanModel findOne(Long id);
	List<SanModel> findAll(); 
	Long save(SanModel sanModel);
	void update(SanModel sanModel);
	void delete(SanModel sanModel);
}
