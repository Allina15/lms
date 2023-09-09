package LMS.ServiceImpl;

import LMS.Models.Group;
import LMS.Models.Student;
import LMS.Services.StudentService;

import java.util.LinkedList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private LinkedList<Student>students;
    private LinkedList<Group>groups;

    public StudentServiceImpl(LinkedList<Student> students,LinkedList<Group>groups) {
        this.students = students;
        this.groups = groups;
    }

    public LinkedList<Student> getStudents() {
        return students;
    }

    public void setStudents(LinkedList<Student> students) {
        this.students = students;
    }

    public LinkedList<Group> getGroups() {
        return groups;
    }

    public void setGroups(LinkedList<Group> groups) {
        this.groups = groups;
    }

    @Override
    public void UpdateStudent(String studentName, Student newStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getFirstName().equalsIgnoreCase(studentName)){
                students.get(i).setFirstName(newStudent.getFirstName());
                students.get(i).setLastName(newStudent.getLastName());
                students.get(i).setEmail(newStudent.getEmail());
                students.get(i).setAge(newStudent.getAge());
                students.get(i).setGender(newStudent.getGender());
                students.set(i,newStudent);
                System.out.println("Студент озгорду");
            }
        }
    }

    @Override
    public String FindStudentByFirstName(String firstName) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getFirstName().equalsIgnoreCase(firstName)){
               return  "Сиз издеген студент --> " + students.get(i);
            }
        }
        return null;
    }

    @Override
    public void GetAllStudentsLesson(String groupName) {
        for (Group g:groups) {
            if (g.getGroupName().equalsIgnoreCase(groupName)){
                System.out.println(g.getLessons());
            }
        }
    }

    @Override
    public String DeleteStudent(String student) {
        for (Student st:students) {
            if (st.getFirstName().equalsIgnoreCase(student)){
                students.remove(st);
            }
        }
        return "Студент очурулду";
    }
}
