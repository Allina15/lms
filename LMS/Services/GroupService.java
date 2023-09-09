package LMS.Services;

import LMS.Models.Group;
import LMS.Models.Lesson;
import LMS.Models.Person;
import LMS.Models.Student;

public interface GroupService {
     String AddNewGroup(Group group);
     void GetGroupByName(String GroupName);
     String UpdateGroupName(String gn,String GroupName);
     void GetAllGroups();
     String AddNewStudentToGroup(String groupName, Student newStudent);
     void GetAllStudentsByGroupName(String groupName);
     void AddNewLessonToGroup(String groupName, Lesson Lesson);
     String GetAllLessonByGroupName(String groupName);
     String DeleteGroup(String groupName);
}
