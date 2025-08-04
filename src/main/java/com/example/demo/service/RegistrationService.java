package com.example.demo.service;

import com.example.demo.DTO.Request.RegistrationsRequest;
import com.example.demo.DTO.Response.RegistrationResponse;
import com.example.demo.DTO.Response.ScheduleResponse;
import com.example.demo.DTO.Response.StudentScheduleListResponse;
import com.example.demo.DTO.Response.StudentResponse;
import com.example.demo.entity.CoursesEntity;
import com.example.demo.entity.RegistrationsEntity;
import com.example.demo.entity.ScheduleSEntity;
import com.example.demo.entity.StudentsEntity;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.RegistrationRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegistrationService {
    final String[] DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ScheduleService scheduleService;

    public RegistrationsEntity addRegistration(RegistrationsRequest registrationsRequest) {
        // Chuyển đổi RegistrationsRequest thành RegistrationsEntity
        RegistrationsEntity registrationEntity = new RegistrationsEntity();
        // lấy ra khóa hc và học sinh đó từ hai bảng khóa học và học sinh để thêm vào bảng đăng ký
        StudentsEntity studentsEntity = studentRepository.findById(registrationsRequest.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + registrationsRequest.getStudentId()));
        CoursesEntity coursesEntity = courseRepository.findById(registrationsRequest.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + registrationsRequest.getCourseId()));
        // Thiết lập thông tin cho đăng ký
        registrationEntity.setStudent(studentsEntity);
        registrationEntity.setCourse(coursesEntity);
        registrationEntity.setCreatedAt(registrationsRequest.getCreatedAt());



        return registrationRepository.save(registrationEntity);
    }

    public RegistrationResponse getStudentByCourseId(Long id) {
        CoursesEntity course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));

        // Lấy danh sách đăng ký của khóa học
        RegistrationResponse response = new RegistrationResponse();
        response.setCourseId(course.getId());
        response.setCourseName(course.getCourseName());
        response.setCourseDescription(course.getCourseDesc());

        // Lấy danh sách sinh viên đã đăng ký khóa học này
        List<StudentResponse> students = registrationRepository.findStudentsByCourseId(id).stream()
                .map(studen -> new StudentResponse (studen.getId(), studen.getStudentName())
        ).toList();
        response.setStudents(students);
        return response;

    }

    public StudentScheduleListResponse getScheduleByStudentId(Long id) {
        // kiểm tra sinh viên có tồn tại không
        StudentsEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        // Lấy danh sách lịch học đăng ký của sinh viên
        List<ScheduleSEntity> registrations = registrationRepository.findSchedulesByStudentId(id);

        // Lấy danh sách khóa học từ danh sách đăng ký
        List<CoursesEntity> courses = registrations.stream()
                .map(ScheduleSEntity::getCourse)
                .distinct()
                .toList();

        // Chuyển đổi danh sách đăng ký thành response để trả cho client
        List<ScheduleResponse> ar =new ArrayList<>();
        for (CoursesEntity course : courses) {
        ar.add(scheduleService.getAllCourseById(course.getId()));
        }
        StudentScheduleListResponse response = new StudentScheduleListResponse();
        response.setStudentId(id);
        response.setStudentName(student.getStudentName());
        response.setSchedules(ar);
        return response;
    }
}
