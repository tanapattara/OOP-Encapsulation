package th.ac.kku.cis.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

public class OOPClass {
    private ArrayList<StudentScore> students;

    public OOPClass() {
        students = new ArrayList<StudentScore>();
        loadStudentFromCSV();
    }

    public ArrayList<Student> getStudents() {
        ArrayList<Student> studentsList = new ArrayList<Student>();
        for (StudentScore studentScore: students) {
            studentsList.add(studentScore.student);
        }
        return studentsList;
    }

    public String getStudentGrade(Student student){
        String result = "F";
        for (StudentScore studentScore: students) {
            if(studentScore.student.getStudent_id() == student.getStudent_id()){
                result = studentScore.getStudentGrade();
            }
        }
        return result;
    }

    private void loadStudentFromCSV(){
        Path pathToFile = Paths.get("C:\\Users\\dell\\Documents\\name.csv");
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {

            String line = br.readLine();

            while (line != null) {
                String[] attributes = line.split(",");

                StudentScore studentFromCSV = createStudent(attributes);

                students.add(studentFromCSV);

                line = br.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public int getStudentCount(){
        return this.getStudents().size();
    }

    private StudentScore createStudent(String[] attributes){

        Student newStudent = new Student();
        newStudent.setStudent_id(attributes[0]);
        newStudent.setFirstname(attributes[1]);
        newStudent.setLastname(attributes[2]);
        newStudent.setEmail(attributes[3]);

        StudentScore studentScore = new StudentScore(newStudent);
        return studentScore;
    }

    private class StudentScore{
        private Student student;
        private Score score;

        StudentScore(Student stu){
            student = stu;
            score = new Score();
        }

        public String getStudentGrade() {
            double studentScore = score.getTotalScore();
            if(studentScore >= 80.0)
                return "A";
            else if(studentScore >= 75.0)
                return "B+";
            else if(studentScore >= 70.0)
                return "B";
            else if(studentScore >= 65.0)
                return "C+";
            else if(studentScore >= 60.0)
                return "C";
            else if(studentScore >= 55.0)
                return "D+";
            else if(studentScore >= 50.0)
                return "D";
            else
                return "F";
        }

    }
    private class Score{
        private double midtermScore;
        private double finalexamScore;
        private double assignmentScore;
        private String grade;

        int midterm_max = 40;
        int finalexam_max = 40;
        int assignment_max = 20;
        int min = 1;

        Score(){
            Random random = new Random();

            midtermScore = (double)(random.nextDouble() * (midterm_max - min));
            finalexamScore = (double)(random.nextDouble() * (finalexam_max - min));
            assignmentScore = (double)(random.nextDouble() * (assignment_max - min));
            grade = "F";
        }

        double getTotalScore(){
            return this.getMidtermScore() + this.getFinalexamScore() + this.getAssignmentScore();
        }

        public double getMidtermScore() {
            return midtermScore;
        }

        public double getFinalexamScore() {
            return finalexamScore;
        }

        public double getAssignmentScore() {
            return assignmentScore;
        }
    }
}
