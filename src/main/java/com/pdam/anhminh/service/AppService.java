package com.pdam.anhminh.service;

import org.springframework.stereotype.Service;

@Service // 1. Thêm annotation @Service
public class AppService {

    // 2. Sửa lại thành một phương thức hợp lệ
    public int getAge() {
        return 6;
    }
}