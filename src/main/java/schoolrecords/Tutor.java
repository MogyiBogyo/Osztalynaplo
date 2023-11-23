package schoolrecords;

import java.util.List;

public class Tutor {
    private String name;
    private List<Subject> taught;

    public Tutor(String name, List<Subject> taught) {
        if(name == null || taught == null){
            throw new IllegalArgumentException("Both name and taught list must be provided!");
        }
        this.name = name;
        this.taught = taught;
    }

    public String getName(){
        return name;
    }

    public void addSubject(Subject subject){

        taught.add(subject);
    }

    public boolean isTutorTeachingSubject(String subjectName){
        if (subjectName == null){
            throw new IllegalArgumentException("Subject must not be empty!");
        }
        for (Subject subject : taught){
            if (subject.getName().equals(subjectName)){
                return true;
            }
        }
        return  false;
    }
}
