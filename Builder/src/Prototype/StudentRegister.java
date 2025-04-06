package Prototype;

import java.util.HashMap;
import java.util.Map;

public class StudentRegister {
    Map<String, Student> studentRegister = new HashMap<>();

    public void addStudentRegister(String key, Student student) {
        studentRegister.put(key, student);
    }

    public Student getStudentRegister(String key) {
        return studentRegister.get(key);


    }

}
