package com.quanlysandabong.mapper;

import java.sql.ResultSet;

import com.quanlysandabong.model.ThanhToanModel;

public class ThanhToanMapper implements RowMapper<ThanhToanModel> {

	@Override
	public ThanhToanModel mapRow(ResultSet resultSet) {
		try {
			ThanhToanModel ttModel= new ThanhToanModel();
			ttModel.setIdHoaDon(resultSet.getLong("IdHoaDon"));
			ttModel.setThanhTien(resultSet.getInt("ThanhTien"));
			ttModel.setMaPT(resultSet.getLong("IdHoaDon"));
			return ttModel;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
