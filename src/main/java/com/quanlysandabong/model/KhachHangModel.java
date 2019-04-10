package com.quanlysandabong.model;

import java.sql.Timestamp;

public class KhachHangModel extends AbstractModel<KhachHangModel> {
	private Long maKH;
	private String tenKH;
	private String soDienThoai;
	private int soGioThue;
	private Timestamp gioBatDau;
	private Long maSan;
	public Long getMaKH() {
		return maKH;
	}
	public void setMaKH(Long maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public int getSoGioThue() {
		return soGioThue;
	}
	public void setSoGioThue(int soGioThue) {
		this.soGioThue = soGioThue;
	}
	public Timestamp getGioBatDau() {
		return gioBatDau;
	}
	public void setGioBatDau(Timestamp gioBatDau) {
		this.gioBatDau = gioBatDau;
	}
	public Long getMaSan() {
		return maSan;
	}
	public void setMaSan(Long maSan) {
		this.maSan = maSan;
	}
	
}
