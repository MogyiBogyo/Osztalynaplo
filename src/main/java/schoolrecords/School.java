package schoolrecords;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class School {
    private List<Subject> subjects = new ArrayList<>();
    private List<Tutor> tutors = new ArrayList<>();

    public School(Path path) {
        //File school = new File( "resources/school.scv");
        try{
            List<String> file = Files.readAllLines(path);
            load(file);
        }
        catch (IOException ioException){
            throw new IllegalStateException("Can't load subjects and tutors from file.", ioException);
        }
    }

    public void load(List<String> file){
        for (String item: file){
            String[] fileRow = item.split(";");
            loadSubject(fileRow[0]);
            loadTutor(fileRow[1], fileRow[0]);  //tanárnak tölteni kell a tárgyait is
        }
    }

    public void loadSubject(String subjectForLoad){
        boolean subjectExists = false;
        for (Subject subject : subjects){
            if (subject.getName().equals(subjectForLoad)){
               subjectExists = true;
               break;
            }
        }
        if (!subjectExists){
            subjects.add(new Subject(subjectForLoad));
        }
    }

    public void loadTutor(String tutorName, String tutorSubject){
        boolean tutorExists = false;
        Tutor tutor = new Tutor(tutorName, new ArrayList<>());

        for (Tutor t : tutors) {
            if (t.getName().equals(tutorName))  {
                tutorExists = true;
                tutor = t;
            }
        }
        if (!tutorExists){
            tutors.add(tutor);
        }
        if(!tutor.isTutorTeachingSubject(tutorSubject)){
            Subject subject = findSubjectByName(tutorSubject);
            tutor.addSubject(subject);
        }

    }

    public Tutor findTutorByName(String tutorName){
        for (Tutor tutor : tutors){
            if (tutor.getName().equals(tutorName)){
                return tutor;
            }
        }
        throw new IllegalArgumentException("Can't find tutor with this name!");
    }

    public Subject findSubjectByName(String subjectname){

        for (Subject subject : subjects) {
            if (subject.getName().equals(subjectname)) {
                return subject;
            }
        }
        throw new IllegalArgumentException("Can't find subject with this name!");
    }
}
