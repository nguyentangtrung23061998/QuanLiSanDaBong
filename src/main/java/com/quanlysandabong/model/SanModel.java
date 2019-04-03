package com.quanlysandabong.model;

public class SanModel extends AbstractModel<SanModel> {
	private Long MaSan;
	private String tenSan;
	private int trangThai;
	private String ghiChu;
	public String getTenSan() {
		return tenSan;
	}
	public void setTenSan(String tenSan) {
		this.tenSan = tenSan;
	}
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public Long getMaSan() {
		return MaSan;
	}
	public void setMaSan(Long maSan) {
		MaSan = maSan;
	}
	
}
