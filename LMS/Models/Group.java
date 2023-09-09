package LMS.Models;

import LMS.Enums.GroupName;
import TaskSession.List;

import java.util.LinkedList;

public class Group {
    private String groupName;
    private LinkedList<Lesson> lessons;
    private LinkedList<Student>studentList;

    public Group(String groupName, LinkedList<Lesson> lessons, LinkedList<Student> studentList) {
        this.groupName = groupName;
        this.lessons = lessons;
        this.studentList = studentList;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public LinkedList<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(LinkedList<Lesson> lessons) {
        this.lessons = lessons;
    }

    public LinkedList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(LinkedList<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Group " +
                "groupName = " + groupName +
                ", lessons = " + lessons +
                ", studentList = " + studentList+"\n";
    }
}
