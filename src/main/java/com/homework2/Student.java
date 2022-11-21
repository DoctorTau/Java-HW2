package com.homework2;

public class Student {
    private String name;
    private Integer mark = null;

    public Student(String name) {
        this.name = name;
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
