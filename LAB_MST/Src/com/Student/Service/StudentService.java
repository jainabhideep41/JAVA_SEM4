package com.student.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

import com.student.model.Student;
import com.student.util.InvalidMarksException;

public class StudentService {

    public void addStudent(Student s) throws InvalidMarksException {

        if (s.getMarks() < 0 || s.getMarks() > 100) {
            throw new InvalidMarksException("Marks must be between 0 and 100");
        }

        try {
            FileWriter fw = new FileWriter("students.txt", true);
            fw.write(s.toString() + "\n");
            fw.close();

            System.out.println("Student added successfully");

        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }

    public void displayStudents() {

        try {
            BufferedReader br = new BufferedReader(new FileReader("students.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
