package com.quanlysandabong.dao;

import java.util.List;

import com.quanlysandabong.model.ThanhToanModel;

public interface IThanhToanDAO {
	ThanhToanModel findOne(Long id);
	List<ThanhToanModel> findAll(); 
	Long save(ThanhToanModel sanModel);
}
