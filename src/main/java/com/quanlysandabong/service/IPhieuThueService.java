package com.quanlysandabong.service;

import java.util.List;

import com.quanlysandabong.model.KhachHangModel;
import com.quanlysandabong.model.PhieuThueModel;
import com.quanlysandabong.model.SanModel;

public interface IPhieuThueService {
	List<PhieuThueModel> findAll();
	PhieuThueModel save(PhieuThueModel ptModel);
}
