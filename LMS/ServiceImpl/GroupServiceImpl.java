package LMS.ServiceImpl;

import LMS.Models.Group;
import LMS.Models.Lesson;
import LMS.Models.Person;
import LMS.Models.Student;
import LMS.Services.GroupService;

import java.util.LinkedList;
import java.util.Scanner;

public class GroupServiceImpl implements GroupService {
    private LinkedList<Group>groups;

    public GroupServiceImpl(LinkedList<Group> groups) {
        this.groups = groups;
    }

    public LinkedList<Group> getGroups() {
        return groups;
    }

    public void setGroups(LinkedList<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String AddNewGroup(Group group) {
        groups.add(group);
        return "Группа сакталды "+groups;
    }

    @Override
    public void GetGroupByName(String GroupName) {
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).getGroupName().equalsIgnoreCase(GroupName)){
                System.out.println(groups.get(i));
            }
        }
    }

    @Override
    public String UpdateGroupName(String gn,String GroupName) {
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).getGroupName().equalsIgnoreCase(gn)){
                groups.get(i).setGroupName(GroupName);
                return "Group name was updated";
            }
        }
        return null;
    }

    @Override
    public void GetAllGroups() {
        System.out.println(groups);
    }

    @Override
    public String AddNewStudentToGroup(String groupName, Student newStudent){
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).getGroupName().equalsIgnoreCase(groupName)){
                groups.get(i).getStudentList().add(newStudent);
                return "new student "+newStudent;
            }
        }
        return null;
    }

    @Override
    public void GetAllStudentsByGroupName(String groupName) {
        for (Group g:groups) {
            if (g.getGroupName().equalsIgnoreCase(groupName)){
                System.out.println(g.getStudentList());
            }
        }
    }

    @Override
    public void AddNewLessonToGroup(String groupName, Lesson Lesson) {
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).getGroupName().equalsIgnoreCase(groupName)){
                groups.get(i).getLessons().add(Lesson);
                System.out.println("Жаны сабак кошулду");
            }
        }
    }

    @Override
    public String GetAllLessonByGroupName(String groupName) {
        for (Group g:groups) {
            if (g.getGroupName().equalsIgnoreCase(groupName)){
                return groupName+" группасынын сабактары "+g.getLessons();
            }
        }
        return null;
    }

    @Override
    public String DeleteGroup(String groupName) {
        for (Group gr:groups) {
            if (gr.getGroupName().equalsIgnoreCase(groupName)){
                groups.remove(gr);
                return "Группа очурулду";
            }
        }
        return null;
    }
}
