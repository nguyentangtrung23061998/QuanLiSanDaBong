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

}
