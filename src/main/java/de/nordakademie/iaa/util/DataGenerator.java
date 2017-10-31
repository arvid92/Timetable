package de.nordakademie.iaa.util;

import de.nordakademie.iaa.model.*;
import de.nordakademie.iaa.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Component
@Transactional
public class DataGenerator {

    private CenturyService centuryService;
    private CohortService cohortService;
    private CourseService courseService;
    private DocentService docentService;
    private ExamService examService;
    private LectureService lectureService;
    private ManipleService manipleService;
    private RoomService roomService;
    private SeminarService seminarService;

    @Autowired
    public DataGenerator(CenturyService centuryService, CohortService cohortService, CourseService courseService, DocentService docentService, ExamService examService, LectureService lectureService, ManipleService manipleService, RoomService roomService, SeminarService seminarService) {
        this.centuryService = centuryService;
        this.cohortService = cohortService;
        this.courseService = courseService;
        this.docentService = docentService;
        this.examService = examService;
        this.lectureService = lectureService;
        this.manipleService = manipleService;
        this.roomService = roomService;
        this.seminarService = seminarService;
    }

    /**
     * Warning: Be careful when changing this order!
     */
    //    @PostConstruct
    public void createData() {
        createRooms();
        createDocents();
        createCourses();
        createSeminars();
        createLectures();
        createExams();
        createGroups();
    }

    private void createRooms() {
        roomService.saveRoom(new Room(20, "A", 40, "001", RoomType.COMPUTERROOM));
        roomService.saveRoom(new Room(15, "A", 40, "002", RoomType.LECTUREROOM));
        roomService.saveRoom(new Room(15, "A", 40, "003", RoomType.LECTUREROOM));
        roomService.saveRoom(new Room(15, "A", 40, "004", RoomType.LECTUREROOM));
        roomService.saveRoom(new Room(20, "A", 40, "101", RoomType.COMPUTERROOM));
        roomService.saveRoom(new Room(20, "A", 25, "102", RoomType.COMPUTERROOM));

        roomService.saveRoom(new Room(15, "D", 20, "001", RoomType.LECTUREROOM));
        roomService.saveRoom(new Room(15, "D", 20, "002", RoomType.LECTUREROOM));
        roomService.saveRoom(new Room(15, "D", 20, "003", RoomType.LECTUREROOM));
        roomService.saveRoom(new Room(15, "D", 20, "004", RoomType.LECTUREROOM));
        roomService.saveRoom(new Room(30, "D", 20, "005", RoomType.LECTUREROOM));
        roomService.saveRoom(new Room(15, "D", 20, "101", RoomType.LECTUREROOM));
        roomService.saveRoom(new Room(15, "D", 20, "102", RoomType.LECTUREROOM));
        roomService.saveRoom(new Room(15, "D", 20, "103", RoomType.LECTUREROOM));
        roomService.saveRoom(new Room(15, "D", 20, "104", RoomType.LECTUREROOM));
        roomService.saveRoom(new Room(30, "D", 20, "105", RoomType.LECTUREROOM));
    }

    private void createDocents() {
        docentService.saveDocent(new Docent("", "Uwe", "Adamczak", "", "", false, 30));
        docentService.saveDocent(new Docent("", "Martin", "Müller", "", "Dr.", false, 30));
        docentService.saveDocent(new Docent("", "Soenke", "Stange", "", "", false, 30));
        docentService.saveDocent(new Docent("", "Carlo ", "Düllings", "", "", false, 30));
        docentService.saveDocent(new Docent("", "Clemens", "Sietas", "", "", false, 30));
        docentService.saveDocent(new Docent("", "Anna Katharina", "Bartel", "", "", false, 30));
        docentService.saveDocent(new Docent("", "Andrea", "Denke", "", "Dr.", false, 30));
        docentService.saveDocent(new Docent("", "Michael ", "Bregulla", "", "", false, 30));
        docentService.saveDocent(new Docent("", "Kersten", "Steinke", "", "", false, 30));

        docentService.saveDocent(new Docent("stefan.reichert@nordakademie.de", "Stefan", "Reichert", "", "", false, 30));
        docentService.saveDocent(new Docent("stephan.anft@nordakademie.de", "Stephan ", "Anft", "", "", false, 30));
        docentService.saveDocent(new Docent("bjoern-helge.busch@nordakademie.de", "Björn-Helge", "Busch", "+49 (0) 4121 4090-40", "", false, 30));
        docentService.saveDocent(new Docent("ludolph@goldex.de", "Fred", "Ludolph", "+49 (0) 4121 4090-40", "", false, 30));
        docentService.saveDocent(new Docent("andrew.small@nordakademie.de", "Andrew", "Small", "+49 (0) 4121 4090-40", "M.A. (TESOL)", false, 30));
        docentService.saveDocent(new Docent("stover@nordakademie.de", "Jason", "Stover", "+49 (0) 4121 4090-40", "Diplom-Theologe", false, 30));

        docentService.saveDocent(new Docent("uwe.neuhaus@nordakademie.de", "Uwe", "Neuhaus", "04121 4090-543", "", true, 20));
        docentService.saveDocent(new Docent("joachim.sauer@nordakademie.de", "Joachim", "Sauer", "04121 4090-441", "Prof. Dr.", true, 30));
        docentService.saveDocent(new Docent("hinrich.schroeder@nordakademie.de", "Hinrich", "Schröder", "04018520656", "Prof. Dr.", true, 30));
        docentService.saveDocent(new Docent("michael.skall@nordakademie.de", "Michael", "Skall", "04121 4090-449", "Prof. Dr.", true, 30));
        docentService.saveDocent(new Docent("f.zimmermann@nordakademie.de", "Frank", "Zimmermann", "04121 4090-447", "Prof. Dr.", true, 30));
        docentService.saveDocent(new Docent("matthias.finck@nordakademie.de", "Matthias", "Finck", "04121 4090-445", "Prof. Dr.", true, 30));
        docentService.saveDocent(new Docent("frank.fuerstenberg@nordakademie.de", "Frank", "Fürstenberg", "+49 4121 4090-422", "Prof. Dr.-Ing.", true, 30));
    }

    private void createCourses() {
        courseService.saveCourse(new Course('I', 103, "Technische Grundlagen der Informatik 1", "TGdI 1"));
        courseService.saveCourse(new Course('I', 104, "Technische Grundlagen der Informatik 2", "TGdI 2"));
        courseService.saveCourse(new Course('I', 107, "Algorithmen und Datenstrukturen", "AlgoDat"));
        courseService.saveCourse(new Course('I', 128, "Englisch 1"));
        courseService.saveCourse(new Course('I', 129, "Englisch 2"));
        courseService.saveCourse(new Course('I', 115, "Betriebswirtschaftliche Anwendungen", "Betr. Anw."));
        courseService.saveCourse(new Course('I', 143, "Praxis der Softwareentwicklung", "PdSe"));
        courseService.saveCourse(new Course('I', 148, "Internet Anwendungsarchitekturen", "IAA"));
        courseService.saveCourse(new Course('I', 149, "Geschäftsprozessmodellierung und Qualitätsmanagement", "GPM und QM"));
        courseService.saveCourse(new Course('I', 150, "Seminar: Ausgewählte Kapitel der Wirtschaftsinformatik", "AKdW"));
        courseService.saveCourse(new Course('I', 151, "Softwaretechnik"));
        courseService.saveCourse(new Course('I', 154, "Allgemeine Volkswirtschaftslehre", "AVWL"));
        courseService.saveCourse(new Course('I', 155, "Allgemeine Betriebswirtschaftslehre", "ABWL"));
        courseService.saveCourse(new Course('I', 157, "Logistik / Operations Management", "Log./ OM"));
        courseService.saveCourse(new Course('I', 158, "Controlling"));
    }

    private void createSeminars() {
        seminarService.saveSeminar(new Seminar("Der Business Plan - Mit System zum Erfolg", 25));
        seminarService.saveSeminar(new Seminar("Wirksame Tools für erfolgreiches Projektmanagement", 20));
        seminarService.saveSeminar(new Seminar("Excel VBA für Einsteiger", 25));
        seminarService.saveSeminar(new Seminar("Emotionale Intelligenz", 25));
        seminarService.saveSeminar(new Seminar("Sourcecodeverwaltung mit Git und GitHub", 25));
        seminarService.saveSeminar(new Seminar("Zeit- und Selbstmanagement", 20));
        seminarService.saveSeminar(new Seminar("Große Dokumente in Word", 25));
        seminarService.saveSeminar(new Seminar("Networking Excellence", 20));
        seminarService.saveSeminar(new Seminar("Business-Knigge", 20));
    }

    private void createLectures() {
        courseService.listCourses().forEach(course -> lectureService.saveLecture(new Lecture(15, course)));
    }

    private void createExams() {
        courseService.listCourses().forEach(course -> examService.saveExam(new Exam(30, course)));
    }

    private void createGroups() {
        Century centuryI14a = new Century("I14a", 35);
        Century centuryI14b = new Century("I14b", 30);
        Century centuryW14a = new Century("W14a", 40);
        Century centuryW14b = new Century("W14b", 35);
        Arrays.asList(centuryI14a, centuryI14b, centuryW14a, centuryI14b).forEach(centuryService::saveCentury);

        Maniple manipleI = new Maniple("I14");
        Maniple manipleW = new Maniple("W14");
        Arrays.asList(manipleI, manipleW).forEach(manipleService::saveManiple);
        manipleI.setCenturies(Arrays.asList(centuryI14a, centuryI14b));
        manipleW.setCenturies(Arrays.asList(centuryW14a, centuryW14b));

        Cohort cohort14 = new Cohort("14");
        cohortService.saveCohort(cohort14);
        cohort14.setManiples(Arrays.asList(manipleI, manipleW));
    }

}