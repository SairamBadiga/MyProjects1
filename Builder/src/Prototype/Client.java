package Prototype;

public class Client {
    public static void main(String[] args) {
        IntelligentStudent first = new IntelligentStudent();
        first.setIq(6);
        first.setAge(4);
        first.setInteligentLevel(10);
        first.setBatch(24);
        first.setCourse("H");
        first.setLocation("Hyderabad");
        first.setProfessor("y");
        first.setName("Sky");
        StudentRegister register = new StudentRegister();
        register.addStudentRegister("first", first);

        Student testCase = register.getStudentRegister("first").clone();
        System.out.println(testCase.getName());
        System.out.println(testCase.getAge());
        System.out.println(testCase.getBatch());
        System.out.println(testCase.getCourse());
        System.out.println(testCase.getLocation());
        System.out.println(testCase.getProfessor());

    }
}
