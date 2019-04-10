package com.quanlysandabong.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.quanlysandabong.dao.IThanhToanDAO;
import com.quanlysandabong.model.ThanhToanModel;
import com.quanlysandabong.service.IThanhTienService;

public class ThanhToanService implements IThanhTienService{
	@Inject IThanhToanDAO ttDAO;
	@Override
	public List<ThanhToanModel> findAll() {
		// TODO Auto-generated method stub
		return ttDAO.findAll();
	}

	@Override
	public ThanhToanModel save(ThanhToanModel ttModel) {
		Long ttID = ttDAO.save(ttModel);
		return ttDAO.findOne(ttID);
	}

}
