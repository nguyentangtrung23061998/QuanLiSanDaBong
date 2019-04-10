package com.quanlysandabong.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.quanlysandabong.model.KhachHangModel;

public class KhachHangMapper implements RowMapper<KhachHangModel> {

	@Override
	public KhachHangModel mapRow(ResultSet result) {
		try {
			KhachHangModel khModel = new KhachHangModel();
			khModel.setMaKH(result.getLong("MaKH"));
			khModel.setTenKH(result.getString("TenKH"));
			khModel.setSoDienThoai(result.getString("SoDienThoai"));
			khModel.setSoGioThue(result.getInt("SoGioThue"));
			khModel.setGioBatDau(result.getTimestamp("GioBatDau"));
			return khModel;
		}catch(SQLException e) {
			return null;
		}
	}
}
