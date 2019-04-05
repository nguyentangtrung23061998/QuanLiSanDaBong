package com.quanlysandabong.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.quanlysandabong.dao.ISanDAO;
import com.quanlysandabong.model.SanModel;
import com.quanlysandabong.service.ISanService;

public class SanService implements ISanService{
	@Inject ISanDAO sanDAO;
	@Override
	public List<SanModel> findAll() {
		return sanDAO.findAll();
	}
	@Override
	public SanModel save(SanModel sanModel) {
		// TODO Auto-generated method stub
		Long newId = sanDAO.save(sanModel);
		return sanDAO.findOne(newId);
	}
	@Override
	public SanModel update(SanModel sanModel) {
		sanDAO.update(sanModel);
		return sanDAO.findOne(sanModel.getMaSan());
	}
	@Override
	public void delete(SanModel sanModel) {
		sanDAO.delete(sanModel);
	}

}
