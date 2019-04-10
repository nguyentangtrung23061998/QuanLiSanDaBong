package com.quanlysandabong.dao.impl;

import java.util.List;

import com.quanlysandabong.dao.IKhachHangDAO;
import com.quanlysandabong.mapper.KhachHangMapper;
import com.quanlysandabong.mapper.SanMapper;
import com.quanlysandabong.model.KhachHangModel;
import com.quanlysandabong.model.SanModel;

public class KhachHangDAO extends AbstractDAO<KhachHangModel> implements IKhachHangDAO{

	@Override
	public KhachHangModel findOne(Long id) {
		String sql = "select * from user where MaKH=?";
		List<KhachHangModel> khModel = query(sql, new KhachHangMapper(), id);
		return khModel.isEmpty() ? null : khModel.get(0);
	}

	@Override
	public List<KhachHangModel> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from user";
		return query(sql, new KhachHangMapper());
	}

	@Override
	public Long save(KhachHangModel user) {
		StringBuilder sql = new StringBuilder("insert into user (TenKH,SoDienThoai,SoGioThue");
		sql.append(",GioBatDau,MaSan)");
		sql.append(" values(?,?,?,?,?)");
		return insert(sql.toString(), user.getTenKH(),user.getSoDienThoai(),
				user.getSoGioThue(),user.getGioBatDau(),user.getMaSan());
	}

	@Override
	public void update(KhachHangModel user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(KhachHangModel user) {
		// TODO Auto-generated method stub
		
	}

}
