package com.quanlysandabong.dao.impl;

import java.util.List;

import com.quanlysandabong.dao.IPhieuThueDAO;
import com.quanlysandabong.mapper.KhachHangMapper;
import com.quanlysandabong.mapper.PhieuThueMapper;
import com.quanlysandabong.model.KhachHangModel;
import com.quanlysandabong.model.PhieuThueModel;

public class PhieuThueDAO extends AbstractDAO<PhieuThueModel> implements IPhieuThueDAO{

	@Override
	public PhieuThueModel findOne(Long id) {
		String sql = "select * from phieuthuesan where MaPhieuSan=?";
		List<PhieuThueModel> phModel = query(sql, new PhieuThueMapper(), id);
		return phModel.isEmpty() ? null : phModel.get(0);
	}

	@Override
	public List<PhieuThueModel> findAll() {
		String sql = "select * from phieuthuesan";
		return query(sql,new PhieuThueMapper());
	}

	@Override
	public Long save(PhieuThueModel pt) {
		StringBuilder sql =new StringBuilder("insert into phieuthuesan (TenPhieuSan,MaKH)");
		sql.append(" values(?,?)");
		return insert(sql.toString(), pt.getTenPT(),pt.getMaKH());
	}

}
