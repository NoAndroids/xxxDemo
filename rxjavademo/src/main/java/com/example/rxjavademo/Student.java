package com.example.rxjavademo;

import java.util.List;

/**
 * Created by Administrator on 2016/8/1.
 */
public class Student {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(String name) {

        this.name = name;
    }
    List<Courses> courses;

    public Student(String name, List<Courses> courses) {
        this.name = name;
        this.courses = courses;
    }

    public Student(List<Courses> courses) {
        this.courses = courses;
    }

    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }
}
