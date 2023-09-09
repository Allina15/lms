package LMS.ServiceImpl;

import LMS.Models.Group;
import LMS.Models.Lesson;
import LMS.Services.LessonService;

import java.util.LinkedList;

public class LessonServiceImpl implements LessonService {
    LinkedList<Lesson>lessons = new LinkedList<>();
    LinkedList<Group>groups = new LinkedList<>();

    public LessonServiceImpl(LinkedList<Lesson> lessons, LinkedList<Group> groups) {
        this.lessons = lessons;
        this.groups = groups;
    }

    public LinkedList<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(LinkedList<Lesson> lessons) {
        this.lessons = lessons;
    }

    public LinkedList<Group> getGroups() {
        return groups;
    }

    public void setGroups(LinkedList<Group> groups) {
        this.groups = groups;
    }

    @Override
    public void GetLessonByName(String lessonName) {
        for (Lesson l:lessons) {
            if (l.getName().equalsIgnoreCase(lessonName)){
                System.out.println(l);
            }
        }
    }

    @Override
    public String DeleteLesson(String lessonName) {
        for (Lesson g:lessons) {
            if (g.getName().equalsIgnoreCase(lessonName)){
                lessons.remove(g);
                return "Сабак очурулду";
            }
        }
        return null;
    }
}
