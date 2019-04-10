package com.quanlysandabong.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.quanlysandabong.model.PhieuThueModel;

public class PhieuThueMapper implements RowMapper<PhieuThueModel>{

	@Override
	public PhieuThueModel mapRow(ResultSet resultSet) {
		try {
			PhieuThueModel ptModel = new PhieuThueModel();
			ptModel.setMaKH(resultSet.getLong("MaKH"));
			ptModel.setMaPT(resultSet.getLong("MaPhieuSan"));
			ptModel.setTenPT(resultSet.getString("TenPhieuSan"));
			return ptModel;
		}catch (SQLException e) {
			return null;
		}
	}

}
