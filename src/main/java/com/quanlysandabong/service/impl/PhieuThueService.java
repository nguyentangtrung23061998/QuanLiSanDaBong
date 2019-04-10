package com.quanlysandabong.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.quanlysandabong.dao.IPhieuThueDAO;
import com.quanlysandabong.model.PhieuThueModel;
import com.quanlysandabong.model.SanModel;
import com.quanlysandabong.service.IPhieuThueService;

public class PhieuThueService implements IPhieuThueService {
	@Inject IPhieuThueDAO ptDAO;
	@Override
	public List<PhieuThueModel> findAll() {
		return ptDAO.findAll();
	}
	@Override
	public PhieuThueModel save(PhieuThueModel ptModel) {
		Long ptID = ptDAO.save(ptModel);
		return ptDAO.findOne(ptID);
	}

}
