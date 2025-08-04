package com.anhminh.manager.service;

import com.anhminh.manager.DTO.response.CourseStudentsResponse;
import com.anhminh.manager.DTO.response.ScheduleResponse;
import com.anhminh.manager.DTO.response.ScheduleStudentResponse;
import com.anhminh.manager.entity.CourseEntity;
import com.anhminh.manager.entity.RegistrationEntity;
import com.anhminh.manager.entity.ScheduleEntity;
import com.anhminh.manager.entity.StudentEntity;
import com.anhminh.manager.repository.RegistrationsRepository;
import com.anhminh.manager.repository.SchedulesRepository;
import com.anhminh.manager.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService {
    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    private SchedulesRepository schedulesRepository;

    @Autowired
    private RegistrationsRepository registrationsRepository;

    @Autowired
    private SchedulesService schedulesService;

    //get all sinh vien
    public List<StudentEntity> getAllStudents() {
        return studentsRepository.findAll();
    }

    // Thêm sinh viên mới
    public StudentEntity createStudent(StudentEntity student) {
        return studentsRepository.save(student);
    }

    // Cập nhật sinh viên
    public StudentEntity updateStudent(int id, StudentEntity studentDetails) {
        StudentEntity student = studentsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student không tồn tại: " + id));

        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());

        return studentsRepository.save(student);
    }

    public ScheduleStudentResponse getCourseByStudent(Integer studentId){
        //get student
        StudentEntity student = studentsRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Khong tim thay sinh vien voi ID: " + studentId));

        //get all registration
        List<RegistrationEntity> registrationDetails = registrationsRepository.findAllWithDetailsByStudentId(studentId);

        //get courses
        List<CourseEntity> courses = registrationDetails.stream().map( course -> { return course.getCourse();}).toList();

        //get schedule by course
        return ScheduleStudentResponse.builder()
                .studentName(student.getName())
                .studentEmail(student.getEmail())
                .studentId(student.getId())
                .schedules(courses.stream().map(course -> {
                    return schedulesService.getScheduleByCourse(course.getId());
                }).toList())
                .build();

//        List<ScheduleEntity> scheduleDetails = schedulesRepository.findSchedulesByStudentId(studentId);
//
//        List<ScheduleStudentResponse> studentDetails = scheduleDetails.stream()
//                .map(scheduleDetail ->
//                                ScheduleStudentResponse.builder()
//                        .studentId(scheduleDetail.getId()))
//                        )


    }

    // Xoá sinh viên
    public void deleteStudent(int id) {
        studentsRepository.deleteById(id);
    }

}
