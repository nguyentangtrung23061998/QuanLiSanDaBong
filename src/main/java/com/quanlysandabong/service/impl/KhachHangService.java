package com.quanlysandabong.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.quanlysandabong.dao.impl.KhachHangDAO;
import com.quanlysandabong.model.KhachHangModel;
import com.quanlysandabong.service.IKhachHangService;

public class KhachHangService implements IKhachHangService{
	@Inject KhachHangDAO khDAO;
	@Override
	public List<KhachHangModel> findAll() {
		return khDAO.findAll();
	}
	@Override
	public KhachHangModel save(KhachHangModel khModel) {
		// TODO Auto-generated method stub
		//newModel.setCreatedDate(new java.sql.Timestamp(System.currentTimeMillis()));
		khModel.setGioBatDau(new Timestamp(System.currentTimeMillis()));
		Long khId = khDAO.save(khModel);
		return khDAO.findOne(khId);
	}

}
