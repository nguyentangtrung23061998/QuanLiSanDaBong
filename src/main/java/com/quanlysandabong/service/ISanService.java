package com.quanlysandabong.service;

import java.util.List;

import com.quanlysandabong.model.SanModel;

public interface ISanService {
	List<SanModel> findAll();
	SanModel save(SanModel sanModel);
	SanModel update(SanModel sanModel);
	void delete(SanModel sanModel);
}
