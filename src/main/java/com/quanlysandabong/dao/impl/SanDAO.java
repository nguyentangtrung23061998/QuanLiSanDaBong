package com.quanlysandabong.dao.impl;

import java.util.List;


import com.quanlysandabong.dao.ISanDAO;
import com.quanlysandabong.mapper.SanMapper;
import com.quanlysandabong.model.SanModel;


public class SanDAO extends AbstractDAO<SanModel> implements ISanDAO{

	@Override
	public List<SanModel> findAll() {
	//	StringBuilder sb = new StringBuilder("select * from san");
		String sql = "SELECT * FROM san";
		return query(sql, new SanMapper());
	}

	@Override
	public Long save(SanModel sanModel) {
		StringBuilder sql = new StringBuilder("insert into san (TenSan,TrangThai,GhiChu)");
		sql.append(" values(?,?,?)");
		System.out.println(sanModel.getTenSan() + ' ' + sanModel.getTrangThai() + ' '+sanModel.getGhiChu());
		return insert(sql.toString(), sanModel.getTenSan(),sanModel.getTrangThai(),sanModel.getGhiChu());
	}

	@Override
	public SanModel findOne(Long id) {
		String sql = "select * from san where MaSan=?";
		List<SanModel> san = query(sql, new SanMapper(), id);
		return san.isEmpty() ? null : san.get(0);
	}

	@Override
	public void update(SanModel sanModel) {
		StringBuilder sql = new StringBuilder("update san set TenSan=?,TrangThai=?,GhiChu=?");
		sql.append(" where MaSan=?");
		System.out.println(sql);
		update(sql.toString(),sanModel.getTenSan(),sanModel.getTrangThai(),sanModel.getGhiChu(),sanModel.getMaSan());
		
	}

	@Override
	public void delete(SanModel sanModel) {
		// TODO Auto-generated method stub
		String sql = "delete from san where MaSan=?";
		delete(sql,sanModel.getMaSan());
	}

}
