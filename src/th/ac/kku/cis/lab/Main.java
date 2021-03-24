package th.ac.kku.cis.lab;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        OOPClass oopClass = new OOPClass();
        //get student data from class
        ArrayList<Student> students = oopClass.getStudents();
        //display data
        for (Student student: students) {
            System.out.println(String.format("%s \t Grade %s",student.getStudentInfo(), oopClass.getStudentGrade(student)));
        }
    }
}
