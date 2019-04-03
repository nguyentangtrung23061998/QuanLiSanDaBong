package com.quanlysandabong.dao.impl;

import java.util.List;

import com.quanlysandabong.dao.ISanDAO;
import com.quanlysandabong.mapper.SanMapper;
import com.quanlysandabong.model.SanModel;


public class SanDAO extends AbstractDAO<SanModel> implements ISanDAO{

	@Override
	public List<SanModel> findAll() {
	//	StringBuilder sb = new StringBuilder("select * from san");
		String sql = "SELECT * FROM SAN";
		return query(sql, new SanMapper());
	}

}
