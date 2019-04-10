package com.quanlysandabong.model;

public class PhieuThueModel extends AbstractModel<PhieuThueModel>{
	private Long maPT;
	private String tenPT;
	private Long maKH;
	public Long getMaPT() {
		return maPT;
	}
	public void setMaPT(Long maPT) {
		this.maPT = maPT;
	}
	public String getTenPT() {
		return tenPT;
	}
	public void setTenPT(String tenPT) {
		this.tenPT = tenPT;
	}
	public Long getMaKH() {
		return maKH;
	}
	public void setMaKH(Long maKH) {
		this.maKH = maKH;
	}
	
}
