package com.homework2;

import java.util.ArrayList;
import java.util.Random;

public class StudentsGroup {
    private ArrayList<Student> studentsUnmarked;
    private ArrayList<Student> studentsMarked;

    private Student getRandomUnmarkedStudent() {
        Student student = studentsUnmarked.get(new Random().nextInt(studentsUnmarked.size()));
        setStudentPresence(student);
        return student;
    }

    private void setStudentPresence(Student student) {
        studentsMarked.add(student);
        studentsUnmarked.remove(student);
    }

    private void setStudentMark(Student student, int mark) {
        if (studentsMarked.contains(student))
            student.setMark(mark);
        else
            throw new IllegalArgumentException("Student " + student + " is absent");
    }

    public void markRandom() {
        if (studentsUnmarked.size() == 0) {
            System.out.println("There are no students to mark.\n");
            return;
        }
        String answer = "";
        Student student = getRandomUnmarkedStudent();
        System.out.println("Is student " + student.getName() + " present?\n" + "(y - Yes, n - No)");
        answer = GetPresenceStatusFromConsole(answer);
        if (answer.toLowerCase().charAt(0) == 'y') {
            SetMarkFromConsole(student);
        }
        System.out.println("Student " + student.getName() + " marked.");
    }

    private String GetPresenceStatusFromConsole(String answer) {
        while (true) {
            answer = App.scanner.nextLine();
            if (answer.equals("y") || answer.equals("n"))
                break;
            else
                System.out.println("Please enter 'y' or 'n'.");
        }
        return answer;
    }

    private void SetMarkFromConsole(Student student) {
        String answer;
        System.out.println("Set " + student.getName() + "'s mark");
        int mark;
        while (true) {
            answer = App.scanner.nextLine();
            try {
                mark = Integer.parseInt(answer);
                if (mark < 0 || mark > 10) {
                    System.out.println("Invalid mark");
                    continue;
                }
                break;
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid mark");
                continue;
            }
        }
        setStudentMark(student, mark);
    }

    public StudentsGroup() {
        studentsUnmarked = new ArrayList<Student>();
        studentsMarked = new ArrayList<Student>();
        studentsUnmarked.add(new Student("John"));
        studentsUnmarked.add(new Student("Mary"));
        studentsUnmarked.add(new Student("Robert"));
        studentsUnmarked.add(new Student("Michael"));
    }

    public void addStudent(Student student) {
        studentsUnmarked.add(student);
    }

    public String toString() {
        String result = "Group of " + studentsMarked.size() + " students:\n\n";
        for (Student student : studentsMarked) {
            result += student.toString() + "\n";
            result += "--------------------------------\n";
        }
        result = result.substring(0, result.length() - 1);
        return result;
    }
}
