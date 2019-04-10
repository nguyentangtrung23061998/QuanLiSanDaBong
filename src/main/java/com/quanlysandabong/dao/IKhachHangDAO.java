package com.quanlysandabong.dao;

import java.util.List;

import com.quanlysandabong.model.KhachHangModel;

public interface IKhachHangDAO extends GenericDAO<KhachHangModel> {
	KhachHangModel findOne(Long id);
	List<KhachHangModel> findAll(); 
	Long save(KhachHangModel user);
	void update(KhachHangModel user);
	void delete(KhachHangModel user);
}
