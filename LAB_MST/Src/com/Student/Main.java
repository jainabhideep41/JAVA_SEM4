package com.student;

import com.student.model.Student;
import com.student.service.StudentService;
import com.student.util.InvalidMarksException;

public class Main {

    public static void main(String[] args) {

        StudentService service = new StudentService();

        try {

            Student s1 = new Student(101, "Rahul", 85);
            Student s2 = new Student(102, "Anita", 95);

            service.addStudent(s1);
            service.addStudent(s2);

            System.out.println("\nStudent Records:");
            service.displayStudents();

        } catch (InvalidMarksException e) {
            System.out.println(e.getMessage());
        }
    }
}
