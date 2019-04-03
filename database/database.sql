create database quanlisanbong;
use quanlisanbong;

create table user(
	MaKH bigint not null Primary key auto_increment,
	TenKH nvarchar(100) not null,
    SoDienThoai varchar(10) not null,
    SoGioThue int null,
    GioBatDau timestamp not null
);
ALTER TABLE user ADD MaSan bigint;
create table san(
	MaSan bigint not null Primary key auto_increment,
    TenSan nvarchar(100) not null,
    TrangThai int not null,
    GhiChu nvarchar(100) not null

);
ALTER TABLE phieuthuesan ADD MaSan bigint;
ALTER TABLE phieuthuesan ADD MaKH bigint;
create table phieuthuesan(
	MaPhieuSan bigint not null Primary key auto_increment,	
    TenPhieuSan nvarchar(100) not null
);

create table bill(
	IdHoaDon bigint not null Primary key auto_increment,
    ThanhTien bigint null
);
ALTER TABLE bill ADD MaPhieuSan bigint;
alter table user ADD Constraint fk_user_san foreign key (MaSan) references san(MaSan);
alter table phieuthuesan ADD Constraint fk_phieuthuesan_san foreign key (MaSan) references san(MaSan);
alter table phieuthuesan ADD Constraint fk_phieuthuesan_user foreign key (MaKH) references user(MaKH);
alter table bill ADD Constraint fk_bill_phieuthuesan foreign key (MaPhieuSan) references phieuthuesan(MaPhieuSan);