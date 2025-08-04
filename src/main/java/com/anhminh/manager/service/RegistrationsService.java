package com.anhminh.manager.service;

import com.anhminh.manager.DTO.request.RegistrationRequest;
import com.anhminh.manager.DTO.response.CourseWithStudentsResponse; // Thêm import
import com.anhminh.manager.DTO.response.RegistrationResponse;
import com.anhminh.manager.DTO.response.StudentDetailResponse; // Thêm import
import com.anhminh.manager.entity.CourseEntity;
import com.anhminh.manager.entity.RegistrationEntity;
import com.anhminh.manager.entity.StudentEntity;
import com.anhminh.manager.repository.CoursesRepository;
import com.anhminh.manager.repository.RegistrationsRepository;
import com.anhminh.manager.repository.StudentsRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Builder
public class RegistrationsService {

    @Autowired
    private RegistrationsRepository registrationsRepository;

    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    private CoursesRepository coursesRepository;

    // GET ALL - ✅ ĐÃ TỐI ƯU
    @Transactional(readOnly = true)
    public List<RegistrationResponse> getAllRegistrations() {
        // Gọi phương thức mới để tránh lỗi N+1
        return registrationsRepository.findAllWithDetails().stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    // GET COURSE WITH STUDENTS - ✅ ĐÃ SỬA LẠI HOÀN CHỈNH
    @Transactional(readOnly = true)
    public CourseWithStudentsResponse getCourseWithRegisteredStudents(Integer courseId) {
        CourseEntity course = coursesRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khóa học với ID: " + courseId));

        List<RegistrationEntity> registrations = registrationsRepository.findAllByCourseIdWithDetails(courseId);

        List<StudentDetailResponse> studentDetails = registrations.stream()
                .map(registration -> StudentDetailResponse.builder()
                        .studentId(registration.getStudent().getId())
                        .studentName(registration.getStudent().getName())
                        .studentEmail(registration.getStudent().getEmail())
                        .registeredAt(registration.getRegisteredAt())
                        .build())
                .collect(Collectors.toList());

        return CourseWithStudentsResponse.builder()
                .courseId(course.getId())
                .courseName(course.getName())
                .courseDescription(course.getDescription())
                .registeredStudents(studentDetails)
                .build();
    }

    // POST
    @Transactional
    public RegistrationResponse createRegistration(RegistrationRequest request) {
        StudentEntity student = studentsRepository.findById(request.getStudentId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Student với ID: " + request.getStudentId()));

        CourseEntity course = coursesRepository.findById(request.getCourseId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Course với ID: " + request.getCourseId()));

        if (registrationsRepository.existsByStudentAndCourse(student, course)) {
            throw new IllegalStateException("Sinh viên đã đăng ký khóa học này rồi.");
        }

        RegistrationEntity newRegistration = new RegistrationEntity();
        newRegistration.setStudent(student);
        newRegistration.setCourse(course);

        return convertToResponse(registrationsRepository.save(newRegistration));
    }

    // PUT
    @Transactional
    public RegistrationResponse updateRegistration(int id, RegistrationRequest request) {
        RegistrationEntity existingRegistration = registrationsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy đăng ký với ID: " + id));

        StudentEntity student = studentsRepository.findById(request.getStudentId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Student với ID: " + request.getStudentId()));

        CourseEntity course = coursesRepository.findById(request.getCourseId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Course với ID: " + request.getCourseId()));

        existingRegistration.setStudent(student);
        existingRegistration.setCourse(course);

        return convertToResponse(registrationsRepository.save(existingRegistration));
    }

    // DELETE
    @Transactional
    public void deleteRegistration(int id) {
        if (!registrationsRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy đăng ký với ID: " + id);
        }
        registrationsRepository.deleteById(id);
    }

    // HELPER METHOD - ✅ CẢI THIỆN VỚI BUILDER
    private RegistrationResponse convertToResponse(RegistrationEntity entity) {
        RegistrationResponse.StudentInfo studentInfo = new RegistrationResponse.StudentInfo();
        studentInfo.setId(entity.getStudent().getId());
        studentInfo.setName(entity.getStudent().getName());

        RegistrationResponse.CourseInfo courseInfo = new RegistrationResponse.CourseInfo();
        courseInfo.setId(entity.getCourse().getId());
        courseInfo.setName(entity.getCourse().getName());

        return RegistrationResponse.builder()
                .id(entity.getId())
                .registeredAt(entity.getRegisteredAt())
                .student(studentInfo)
                .course(courseInfo)
                .build();
    }
}