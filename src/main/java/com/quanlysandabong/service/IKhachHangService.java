package com.quanlysandabong.service;

import java.util.List;

import com.quanlysandabong.model.KhachHangModel;


public interface IKhachHangService {
	List<KhachHangModel> findAll();
	KhachHangModel save(KhachHangModel khModel);
}
