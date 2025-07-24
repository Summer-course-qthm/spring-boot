package com.pdam.anhminh.controller;

import com.pdam.anhminh.entity.KhachHang;
import com.pdam.anhminh.entity.SanPham;
import com.pdam.anhminh.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {

    @Autowired
    private AppService appService;

    // Endpoint để lấy danh sách khách hàng
    @GetMapping("/api/khachhang")
    public ResponseEntity<List<KhachHang>> getAllKhachHang() {
        List<KhachHang> khachHangList = appService.getAllKhachHang();
        return ResponseEntity.ok(khachHangList);
    }

    // Endpoint để lấy danh sách sản phẩm
    @GetMapping("/api/sanpham")
    public ResponseEntity<List<SanPham>> getAllSanPham() {
        List<SanPham> sanPhamList = appService.getAllSanPham();
        return ResponseEntity.ok(sanPhamList);
    }
}
