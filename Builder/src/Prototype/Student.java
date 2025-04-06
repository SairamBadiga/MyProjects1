package Prototype;

public class Student implements Copy<Student> {
    private String name;
    private int batch;
    private int age;
    private String professor;
    private String section;
    private String course;
    private String location;

    public Student(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Student(Student student){
        this.age = student.age;
        this.batch = student.batch;
        this.professor = student.professor;
        this.section = student.section;
        this.course = student.course;
        this.location = student.location;
        this.name = student.name;


    }

    @Override
    public Student clone() {
        Student st = new Student(this);

        return st;
    }
}
