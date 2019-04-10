package com.quanlysandabong.dao.impl;

import java.util.List;

import com.quanlysandabong.dao.ISanDAO;
import com.quanlysandabong.dao.IThanhToanDAO;
import com.quanlysandabong.mapper.SanMapper;
import com.quanlysandabong.mapper.ThanhToanMapper;
import com.quanlysandabong.model.SanModel;
import com.quanlysandabong.model.ThanhToanModel;

public class ThanhToanDAO extends AbstractDAO<ThanhToanModel> implements IThanhToanDAO{

	@Override
	public ThanhToanModel findOne(Long id) {
		String sql = "select * from bill where IdHoaDon=?";
		List<ThanhToanModel> ttModel = query(sql, new ThanhToanMapper(), id);
		return ttModel.isEmpty() ? null : ttModel.get(0);
	}

	@Override
	public List<ThanhToanModel> findAll() {
		String sql = "SELECT * FROM BILL";
		return query(sql, new ThanhToanMapper());
	}

	@Override
	public Long save(ThanhToanModel ttModel) {
		StringBuilder sql = new StringBuilder("insert into BILL (ThanhTien,MaPhieuSan)");
		sql.append(" values(?,?)");
		return insert(sql.toString(),ttModel.getThanhTien(),ttModel.getMaPT());
	}

}
