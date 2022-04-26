package com.qlkhachhang.Models;

public class KhachHang {
    private int id;
    private String tenkhachhang;
    private String ngaysinh;
    private String cmnd;
    private String quequan;
    private String email;
    private String sdt;

    public KhachHang(String tenkhachhang, String ngaysinh, String cmnd, String quequan, String email, String sdt) {
        this.tenkhachhang = tenkhachhang;
        this.ngaysinh = ngaysinh;
        this.cmnd = cmnd;
        this.quequan = quequan;
        this.email = email;
        this.sdt = sdt;
    }

    public KhachHang(int id, String tenkhachhang, String ngaysinh, String cmnd, String quequan, String email, String sdt) {
        this.id = id;
        this.tenkhachhang = tenkhachhang;
        this.ngaysinh = ngaysinh;
        this.cmnd = cmnd;
        this.quequan = quequan;
        this.email = email;
        this.sdt = sdt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenkhachhang() {
        return tenkhachhang;
    }

    public void setTenkhachhang(String tenkhachhang) {
        this.tenkhachhang = tenkhachhang;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
