package com.quanlysandabong.model;

public class ThanhToanModel extends AbstractModel<ThanhToanModel> {
	private Long idHoaDon;
	private int thanhTien;
	private Long maPT;
	public Long getIdHoaDon() {
		return idHoaDon;
	}
	public void setIdHoaDon(Long idHoaDon) {
		this.idHoaDon = idHoaDon;
	}
	public int getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(int thanhTien) {
		this.thanhTien = thanhTien;
	}
	public Long getMaPT() {
		return maPT;
	}
	public void setMaPT(Long maPT) {
		this.maPT = maPT;
	}
	
	
}
