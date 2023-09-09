package LMS;
import LMS.Enums.Gender;
import LMS.Models.Group;
import LMS.Models.Lesson;
import LMS.Models.Person;
import LMS.Models.Student;
import LMS.ServiceImpl.GroupServiceImpl;
import LMS.ServiceImpl.LessonServiceImpl;
import LMS.ServiceImpl.PersonServiceImpl;
import LMS.ServiceImpl.StudentServiceImpl;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Alina","Akhunova", 20, Gender.FEMALE, "Alina@gmail.com");
        Student student2 = new Student("Adeliia","Zhyldyzbekova", 22, Gender.FEMALE, "Adel@gmail.com");
        Student student3 = new Student("Zalkar","Mamanov", 17, Gender.MALE, "Zalkar@gmail.com");

        LinkedList<Student> studentList1 = new LinkedList<>(Arrays.asList(student1, student2, student3));

        Lesson lesson1 = new Lesson("Programming");
        Lesson lesson2 = new Lesson("SoftSkill");
        Lesson lesson3 = new Lesson("English");
        LinkedList<Lesson> lessons = new LinkedList<>(Arrays.asList(lesson1, lesson2, lesson3));

        Group group1 = new Group("JAVA", lessons, studentList1);
        LinkedList<Group>groups = new LinkedList<>(Arrays.asList(group1));

        Person person1 = new Person("Admin", "admin@gmail.com", "adminn1234");
        GroupServiceImpl groupService = new GroupServiceImpl(groups);
        StudentServiceImpl studentService = new StudentServiceImpl(studentList1,groups);
        LessonServiceImpl lessonService = new LessonServiceImpl(lessons,groups);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(LocalDateTime.now());
            System.out.println("Саламатсызбы! Катталган болсонуз 1 басыныз, парольду унутуп калдынызбы, озгортуу учун 2 басыныз: ");
            int number = scanner.nextInt();
            if (number == 1) {
                System.out.println("email жазыныз: ");
                String email = scanner.next();
                if (email.equals(person1.getEmail())) {
                    System.out.println("Пароль жазыныз: ");
                    String password = scanner.next();
                    if (password.equals(person1.getPassword())) {
                        while (true) {
                            System.out.println("*** Бир команда танданыз! ***\n 1  -> Add new group\n 2  -> Get group by name\n 3  -> Update group name\n 4  -> Get all groups\n 5  -> Add new student to group" + "\n" +
                                    " 6  -> Update student\n 7  -> Find student by first name\n 8  -> Get all students by group name\n 9  -> Get all student's lesson\n 10 -> Delete student\n 11 -> Add new lesson to group" + "\n" +
                                    " 12 -> Get lesson by name\n 13 -> Get all lesson by group name\n 14 -> Delete lesson\n 15 -> Delete group");
                            int choice = scanner.nextInt();
                            switch (choice) {
                                case 1:
                                    System.out.println("Группанын атын жазыныз: ");
                                    String groupName = scanner.next();
                                    groupService.AddNewGroup(new Group(groupName,new LinkedList<>(),new LinkedList<>()));
                                    System.out.println(groups);
                                    break;
                                case 2:
                                    System.out.println("Группанын атын жазыныз: ");
                                    String groupName1 = scanner.next();
                                    groupService.GetGroupByName(groupName1);
                                    break;
                                case 3:
                                    System.out.println("Группанын атын жазыныз");
                                    String gN = scanner.next();
                                    System.out.println("Группанын атын кантип озгортсоуз?");
                                    String Gn = scanner.next();
                                    System.out.println(groupService.UpdateGroupName(gN,Gn));
                                    break;
                                case 4:
                                    System.out.println("---------------Группалар---------------");
                                    groupService.GetAllGroups();
                                    break;
                                case 5:
                                    System.out.println("Группанын атын жазыныз ");
                                    String groupName2 = scanner.next();
                                    System.out.println("Студенттин aты");
                                    String studentName = scanner.next();
                                    System.out.println("Студенттин фамилиясы ");
                                    String studentLastName = scanner.next();
                                    System.out.println("Жашы ");
                                    int studentAge = scanner.nextInt();
                                    System.out.println("Gender ");
                                    String gender = scanner.next();
                                    System.out.println("email жазыныз ");
                                    String email1 = scanner.next();
                                    System.out.println(groupService.AddNewStudentToGroup(groupName2, new Student(studentName, studentLastName, studentAge, Gender.valueOf(gender.toUpperCase()), email1)));
                                    break;
                                case 6:
                                    Scanner scanner1 = new Scanner(System.in);
                                    System.out.println("Студенттин атын жазыныз ");
                                    String stName3 = scanner.next();
                                    System.out.println("Студенттин аты");
                                    String studentName2 = scanner.next();
                                    System.out.println("Фамилиясы ");
                                    String student = scanner.next();
                                    System.out.println("Жашы ");
                                    int studentAge2 = scanner1.nextInt();
                                    System.out.println("Gender ");
                                    String gender2 = scanner.next();
                                    System.out.println("email жазыныз ");
                                    String email2 = scanner.next();
                                    studentService.UpdateStudent(stName3,new Student(studentName2,student,studentAge2,Gender.valueOf(gender2.toUpperCase()),email2));
                                    break;
                                case 7:
                                    System.out.println("Студенттин атын жазыныз");
                                    String n = scanner.next();
                                    System.out.println(studentService.FindStudentByFirstName(n));
                                    break;
                                case 8:
                                    System.out.println("Группанын атын жазыныз ");
                                    String string = scanner.next();
                                    groupService.GetAllStudentsByGroupName(string);
                                    break;
                                case 9:
                                    System.out.println("Группанын атын жазыныз");
                                    String gr = scanner.next();
                                    studentService.GetAllStudentsLesson(gr);
                                    break;
                                case 10:
                                    System.out.println("Студенттин атын жазыныз");
                                    String name = scanner.nextLine();
                                    System.out.println(studentService.DeleteStudent(name));
                                    break;
                                case  11:
                                    System.out.println("Группанын атын жазыныз ");
                                    String name5 = scanner.next();
                                    System.out.println("Сабактын атын жазыныз");
                                    String stringg = scanner.next();
                                    groupService.AddNewLessonToGroup(name5, new Lesson(stringg));
                                    break;
                                case 12:
                                    System.out.println("Сабактын атын жазыныз");
                                    String s = scanner.next();
                                    lessonService.GetLessonByName(s);
                                    break;
                                case 13:
                                    System.out.println("Группанын атын жазыныз");
                                    String st = scanner.next();
                                    System.out.println(groupService.GetAllLessonByGroupName(st));
                                    break;
                                case 14:
                                    System.out.println("Сабактын атын жазыныз ");
                                    String sabakName = scanner.next();
                                    System.out.println(lessonService.DeleteLesson(sabakName));
                                    break;
                                case 15:
                                    System.out.println("Группанын атын жазыныз");
                                    String str = scanner.next();
                                    System.out.println(groupService.DeleteGroup(str));
                                    break;
                            }
                        }
                    }else {
                        System.out.println("пароль туура эмес!");
                    }
                    break;
                }else {
                    System.err.println("email туура эмес");

                }
            }else if (number==2){
                PersonServiceImpl personService = new PersonServiceImpl(person1);
                System.out.println("email жазыныз: ");
                String email = scanner.next();
                if (email.equals(person1.getEmail())){
                    System.out.println("Жаны пароль жазыныз");
                    String password = scanner.next();
                    System.out.println(personService.updatePassword(email, password));
                    while (true) {
                        System.out.println("*** Бир команда танданыз! ***\n 1  -> Add new group\n 2  -> Get group by name\n 3  -> Update group name\n 4  -> Get all groups\n 5  -> Add new student to group" + "\n" +
                                " 6  -> Update student\n 7  -> Find student by first name\n 8  -> Get all students by group name\n 9  -> Get all student's lesson\n 10 -> Delete student\n 11 -> Add new lesson to group" + "\n" +
                                " 12 -> Get lesson by name\n 13 -> Get all lesson by group name\n 14 -> Delete lesson\n 15 -> Delete group");
                        int choice = scanner.nextInt();
                        switch (choice) {
                            case 1:
                                System.out.println("Группанын атын жазыныз: ");
                                String groupName = scanner.next();
                                groupService.AddNewGroup(new Group(groupName, new LinkedList<>(), new LinkedList<>()));
                                System.out.println(groups);
                                break;
                            case 2:
                                System.out.println("Группанын атын жазыныз: ");
                                String groupName1 = scanner.next();
                                groupService.GetGroupByName(groupName1);
                                break;
                            case 3:
                                System.out.println("Группанын атын жазыныз");
                                String gN = scanner.next();
                                System.out.println("Группанын атын кантип озгортсоуз?");
                                String Gn = scanner.next();
                                System.out.println(groupService.UpdateGroupName(gN, Gn));
                                break;
                            case 4:
                                System.out.println("---------------Группалар---------------");
                                groupService.GetAllGroups();
                                break;
                            case 5:
                                System.out.println("Группанын атын жазыныз ");
                                String groupName2 = scanner.next();
                                System.out.println("Студенттин aты");
                                String studentName = scanner.next();
                                System.out.println("Студенттин фамилиясы ");
                                String studentLastName = scanner.next();
                                System.out.println("Жашы ");
                                int studentAge = scanner.nextInt();
                                System.out.println("Gender ");
                                String gender = scanner.next();
                                System.out.println("email жазыныз ");
                                String email1 = scanner.next();
                                System.out.println(groupService.AddNewStudentToGroup(groupName2, new Student(studentName, studentLastName, studentAge, Gender.valueOf(gender.toUpperCase()), email1)));
                                break;
                            case 6:
                                Scanner scanner1 = new Scanner(System.in);
                                System.out.println("Студенттин атын жазыныз ");
                                String stName3 = scanner.next();
                                System.out.println("Студенттин аты");
                                String studentName2 = scanner.next();
                                System.out.println("Фамилиясы ");
                                String student = scanner.next();
                                System.out.println("Жашы ");
                                int studentAge2 = scanner1.nextInt();
                                System.out.println("Gender ");
                                String gender2 = scanner.next();
                                System.out.println("email жазыныз ");
                                String email2 = scanner.next();
                                studentService.UpdateStudent(stName3, new Student(studentName2, student, studentAge2, Gender.valueOf(gender2.toUpperCase()), email2));
                                break;
                            case 7:
                                System.out.println("Студенттин атын жазыныз");
                                String n = scanner.next();
                                studentService.FindStudentByFirstName(n);
                                break;
                            case 8:
                                System.out.println("Группанын атын жазыныз ");
                                String string = scanner.next();
                                groupService.GetAllStudentsByGroupName(string);
                                break;
                            case 9:
                                System.out.println("Группанын атын жазыныз");
                                String gr = scanner.next();
                                studentService.GetAllStudentsLesson(gr);
                                break;
                            case 10:
                                System.out.println("Студенттин атын жазыныз");
                                String name = scanner.next();
                                System.out.println(studentService.DeleteStudent(name));
                                break;
                            case 11:
                                System.out.println("Группанын атын жазыныз ");
                                String name5 = scanner.next();
                                System.out.println("Сабактын атын жазыныз");
                                String stringg = scanner.next();
                                groupService.AddNewLessonToGroup(name5, new Lesson(stringg));
                                break;
                            case 12:
                                System.out.println("Сабактын атын жазыныз");
                                String s = scanner.next();
                                lessonService.GetLessonByName(s);
                                break;
                            case 13:
                                System.out.println("Группанын атын жазыныз");
                                String st = scanner.next();
                                System.out.println(groupService.GetAllLessonByGroupName(st));
                                break;
                            case 14:
                                System.out.println("Сабактын атын жазыныз ");
                                String sabakName = scanner.next();
                                System.out.println(lessonService.DeleteLesson(sabakName));
                                break;
                            case 15:
                                System.out.println("Группанын атын жазыныз");
                                String str = scanner.next();
                                System.out.println(groupService.DeleteGroup(str));
                                break;
                        }
                        break;
                    }
                }else {
                    System.out.println("email туура эмес");
                }
            }
        }
    }
}
