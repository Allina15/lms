package LMS.Services;

import LMS.Models.Student;

import java.util.List;

public interface StudentService {
    void UpdateStudent(String studentName, Student newStudent);
    String FindStudentByFirstName(String firstName);
    void GetAllStudentsLesson(String groupName);
    String DeleteStudent(String student);
}
