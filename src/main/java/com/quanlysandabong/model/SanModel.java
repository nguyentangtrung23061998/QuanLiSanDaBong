package com.quanlysandabong.model;

public class SanModel extends AbstractModel<SanModel> {
	private Long maSan;
	private String tenSan;
	private int trangThai;
	private String ghiChu;
	
	public Long getMaSan() {
		return maSan;
	}
	public void setMaSan(Long maSan) {
		this.maSan = maSan;
	}
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
	
	
	
}
