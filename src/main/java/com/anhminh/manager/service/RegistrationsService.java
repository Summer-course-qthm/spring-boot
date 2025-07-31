package com.anhminh.manager.service;

import com.anhminh.manager.entity.RegistrationEntity;
import com.anhminh.manager.repository.RegistrationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationsService {
    @Autowired
    private RegistrationsRepository registrationsRepository;

    //get all dang ki
    public List<RegistrationEntity> getAllRe() {
        return registrationsRepository.findAll();
    }

    //POST: tạo đăng ký mới
    public RegistrationEntity createRegistration(RegistrationEntity registration) {
        return registrationsRepository.save(registration);
    }

    //PUT: cập nhật thông tin đăng ký
    public RegistrationEntity updateRegistration(int id, RegistrationEntity registrationDetails) {
        //Tìm kiếm đăng ký theo ID, nếu không tìm thấy thì ném ra ngoại lệ.
        RegistrationEntity existingRegistration = registrationsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy đăng ký với ID: " + id));


        existingRegistration.setStudent(registrationDetails.getStudent());
        existingRegistration.setCourse(registrationDetails.getCourse());

        return registrationsRepository.save(existingRegistration);
    }

    //DELETE: Xoá đăng ký
    public void deleteRegistration(int id) {
        // Kiểm tra xem đăng ký có tồn tại không trước khi xoá để tránh lỗi.
        if (!registrationsRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy đăng ký với ID: " + id);
        }
        registrationsRepository.deleteById(id);
    }
}
