package com.demo.model;

import com.jfinal.plugin.activerecord.Model;

public class Student extends Model<Student> {
    public static final Student dao = new Student();

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}