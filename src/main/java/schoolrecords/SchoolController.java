package schoolrecords;

import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class SchoolController {
    private ClassRecords classRecords;
    private School school;
    private Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        SchoolController controller = new SchoolController();
        controller.school = new School(Paths.get( "src/test/resources/school.csv"));
        controller.classRecords = new ClassRecords("Alsó tagozat 1.A",new Random());

        controller.initClass();
        controller.runMenu();

    }

    private void runMenu() {
        System.out.println("Menü");
    }

    private  void initClass(){
        classRecords.addStudent("Kovács Rita");
        classRecords.addStudent("Nagy Béla");
        classRecords.addStudent("Varga Márton");
        Student firstStudent = classRecords.findStudentByName("Kovács Rita");
        firstStudent.addGrading(new Mark(MarkType.A, school.findSubjectByName("földrajz"), school.findTutorByName("Dienes Irén")));
        firstStudent.addGrading(new Mark(MarkType.C, school.findSubjectByName("matematika"), school.findTutorByName("Szabó László")));
        firstStudent.addGrading(new Mark(MarkType.D, school.findSubjectByName("földrajz"), school.findTutorByName("Dienes Irén")));
        Student secondStudent = classRecords.findStudentByName("Nagy Béla");
        secondStudent.addGrading(new Mark(MarkType.A, school.findSubjectByName("biológia"), school.findTutorByName("Dienes Irén")));
        secondStudent.addGrading(new Mark(MarkType.C, school.findSubjectByName("matematika"), school.findTutorByName("Tóth Ilona")));
        secondStudent.addGrading(new Mark(MarkType.D, school.findSubjectByName("ének-zene"), school.findTutorByName("Németh Lili")));
        Student thirdStudent = classRecords.findStudentByName("Varga Márton");
        thirdStudent.addGrading(new Mark(MarkType.A, school.findSubjectByName("fizika"), school.findTutorByName("Kiss József")));
        thirdStudent.addGrading(new Mark(MarkType.C, school.findSubjectByName("kémia"), school.findTutorByName("Kiss József")));
        thirdStudent.addGrading(new Mark(MarkType.D, school.findSubjectByName("földrajz"), school.findTutorByName("Tóth Ilona")));
    }
}
