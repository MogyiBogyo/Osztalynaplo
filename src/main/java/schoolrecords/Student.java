package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Mark> marks = new ArrayList<>();

    public Student(String name) {
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addGrading(Mark mark){
        System.out.println(mark);
        if ( mark == null ){
            throw new IllegalArgumentException("Mark must not be null!");
        }
        marks.add(mark);
    }

    public double calculateSubjectAverage(String subjectName){
        Subject subject = new Subject(subjectName);
        double average = 0.0;
        int count = 0;
        for (Mark mark: marks) {
            if (mark.getSubjectName().equals(subjectName)){
                average += mark.getMarkValue();
                count++;
            }
        }

        if(count == 0){
            return 0.0;
        }
        else{
            average = average / count;
        }
        return (double) Math.round(average * 100) / 100;
    }

    @Override
    public String toString() {
        StringBuilder student = new StringBuilder(name);
        student.append(" marks: ");
        for (Mark mark : marks){
            student.append(mark.toString());
            if (mark != marks.get(marks.size()-1) ){
                student.append(", ");
            }
        }
        return student.toString();
    }
}
