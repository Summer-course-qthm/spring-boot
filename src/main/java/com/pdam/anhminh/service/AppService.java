package com.pdam.anhminh.service;

import com.pdam.anhminh.entity.KhachHang;
import com.pdam.anhminh.entity.SanPham;
import com.pdam.anhminh.repository.KhachHangRepository;
import com.pdam.anhminh.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService {

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Autowired
    private SanPhamRepository sanPhamRepository;

    // Lấy tất cả khách hàng
    public List<KhachHang> getAllKhachHang() {
        return khachHangRepository.findAll();
    }

    // Lấy tất cả sản phẩm
    public List<SanPham> getAllSanPham() {
        return sanPhamRepository.findAll();
    }
}