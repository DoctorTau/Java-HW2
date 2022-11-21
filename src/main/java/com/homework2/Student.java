package com.homework2;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Student {
    private String name;
    private Integer mark = null;

    public Student() {
        name = "";
        mark = null;
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, Integer mark) {
        this.name = name;
        this.mark = mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public Integer getMark() {
        return mark;
    }

    public String toString() {
        return "Name: " + name + "\n" + "Mark: " + (mark == null ? "-" : mark.toString());
    }

    public void printToConsole() {
        System.out.println("Name: " + name);
        System.out.println("Mark: " + mark == null ? "-" : mark.toString());
    }
}
