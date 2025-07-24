package com.pdam.anhminh.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "SanPham")
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_san_pham")
    private String tenSanPham;

    @Column(name = "mo_ta")
    private String moTa;

    private BigDecimal gia;

    @Column(name = "so_luong_ton_kho")
    private Integer soLuongTonKho;

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getTenSanPham() { return tenSanPham; }
    public void setTenSanPham(String tenSanPham) { this.tenSanPham = tenSanPham; }
    public String getMoTa() { return moTa; }
    public void setMoTa(String moTa) { this.moTa = moTa; }
    public BigDecimal getGia() { return gia; }
    public void setGia(BigDecimal gia) { this.gia = gia; }
    public Integer getSoLuongTonKho() { return soLuongTonKho; }
    public void setSoLuongTonKho(Integer soLuongTonKho) { this.soLuongTonKho = soLuongTonKho; }
}
