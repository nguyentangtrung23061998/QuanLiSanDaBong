package com.quanlysandabong.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.quanlysandabong.model.SanModel;

public class SanMapper implements RowMapper<SanModel> {

	@Override
	public SanModel mapRow(ResultSet resultSet) {
		try {
			SanModel san = new SanModel();
			san.setMaSan(resultSet.getLong("MaSan"));
			san.setTenSan(resultSet.getString("TenSan"));
			san.setTrangThai(resultSet.getInt("TrangThai"));
			san.setGhiChu(resultSet.getString("GhiChu"));
//			news.setId(resultSet.getLong("id"));
//			news.setTitle(resultSet.getString("title"));
//			news.setContent(resultSet.getString("content"));
//			news.setCategoryId(resultSet.getLong("categoryid"));
//			news.setThumbnail(resultSet.getString("thumbnail"));
//			news.setShortDescription(resultSet.getString("shortdescription"));
			san.setCreatedDate(resultSet.getTimestamp("createddate"));
			san.setCreatedBy(resultSet.getString("createdby"));
//			if(resultSet.getTimestamp("modifieddate") != null) {
//				san.setModifiedDate(resultSet.getTimestamp("modifieddate"));
//			}if(resultSet.getString("modifiedby") != null) {
//				san.setModifiedBy(resultSet.getString("modifiedby"));
//			}
			return san;
		} catch (SQLException e) {
			return null;
		}
	}

	

}
