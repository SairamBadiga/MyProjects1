package Prototype;

public class IntelligentStudent extends Student {
    int iq;
    int inteligentLevel;

    public IntelligentStudent() {

    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public int getInteligentLevel() {
        return inteligentLevel;
    }

    public void setInteligentLevel(int inteligentLevel) {
        this.inteligentLevel = inteligentLevel;
    }

    public IntelligentStudent(IntelligentStudent intelligentStudent) {
        super(intelligentStudent);
        this.iq = intelligentStudent.iq;
        this.inteligentLevel = intelligentStudent.inteligentLevel;

    }
    @Override
    public IntelligentStudent clone(){
        return new IntelligentStudent(this);

    }




}
