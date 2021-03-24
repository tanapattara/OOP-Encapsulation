package th.ac.kku.cis.lab;

public class Student {
    private String firstname;
    private String lastname;
    private String student_id;
    private String email;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStudentInfo(){
        return String.format("Student %s, %s %s \t email:%s", this.getStudent_id(), this.getFirstname(), this.getLastname(), this.getEmail());
    }


}

