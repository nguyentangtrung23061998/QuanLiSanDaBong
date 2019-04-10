package com.quanlysandabong.service;

import java.util.List;

import com.quanlysandabong.model.ThanhToanModel;

public interface IThanhTienService {
	List<ThanhToanModel> findAll();
	ThanhToanModel save(ThanhToanModel ttModel);
}
