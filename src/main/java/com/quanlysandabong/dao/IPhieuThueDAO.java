package com.quanlysandabong.dao;

import java.util.List;

import com.quanlysandabong.model.PhieuThueModel;

public interface IPhieuThueDAO {
	PhieuThueModel findOne(Long id);
	List<PhieuThueModel> findAll(); 
	Long save(PhieuThueModel pt);
}
