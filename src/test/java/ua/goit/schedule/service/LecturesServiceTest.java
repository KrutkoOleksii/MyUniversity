package ua.goit.schedule.service;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.DayOfWeek;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ua.goit.schedule.model.Audience;
import ua.goit.schedule.model.DaySchedule;
import ua.goit.schedule.model.GroupSchedule;
import ua.goit.schedule.model.Lecture;
import ua.goit.schedule.model.Person;
import ua.goit.schedule.model.Professor;
import ua.goit.schedule.model.Student;
import ua.goit.schedule.model.StudyGroup;
import ua.goit.schedule.model.Subject;
import ua.goit.schedule.repository.LecturesRepository;

@ContextConfiguration(classes = {LecturesService.class})
@ExtendWith(SpringExtension.class)
class LecturesServiceTest {
    @MockBean
    private DaySchedulesService daySchedulesService;

    @MockBean
    private GroupSchedulesService groupSchedulesService;

    @MockBean
    private LecturesRepository lecturesRepository;

    @Autowired
    private LecturesService lecturesService;

    @MockBean
    private StudentsService studentsService;

    @Test
    void testFindAll() {
        when(this.lecturesRepository.findAll()).thenReturn(null);
        assertNull(this.lecturesService.findAll());
        verify(this.lecturesRepository).findAll();
    }

    @Test
    void testFindById() {
        Audience audience = new Audience();
        audience.setId(123L);
        audience.setName("Name");

        StudyGroup studyGroup = new StudyGroup();
        studyGroup.setId(123L);
        studyGroup.setName("Name");
        studyGroup.setStudents(null);

        GroupSchedule groupSchedule = new GroupSchedule();
        groupSchedule.setDaySchedules(null);
        groupSchedule.setId(123L);
        groupSchedule.setStudyGroup(studyGroup);

        DaySchedule daySchedule = new DaySchedule();
        daySchedule.setDayOfWeek(DayOfWeek.MONDAY);
        daySchedule.setGroupSchedule(groupSchedule);
        daySchedule.setId(123L);
        daySchedule.setLectures(null);

        Person person = new Person();
        person.setId(123L);
        person.setName("Name");
        person.setSurname("Doe");

        Professor professor = new Professor();
        professor.setId(123L);
        professor.setPerson(person);

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Name");

        Lecture lecture = new Lecture();
        lecture.setAudience(audience);
        lecture.setDaySchedule(daySchedule);
        lecture.setId(123L);
        lecture.setProfessor(professor);
        lecture.setSubject(subject);
        Optional<Lecture> ofResult = Optional.of(lecture);
        when(this.lecturesRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<Lecture> actualFindByIdResult = this.lecturesService.findById(123L);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(this.lecturesRepository).findById((Long) any());
        assertTrue(this.lecturesService.findAll().isEmpty());
    }

    @Test
    void testSave() {
        Audience audience = new Audience();
        audience.setId(123L);
        audience.setName("Name");

        StudyGroup studyGroup = new StudyGroup();
        studyGroup.setId(123L);
        studyGroup.setName("Name");
        studyGroup.setStudents(null);

        GroupSchedule groupSchedule = new GroupSchedule();
        groupSchedule.setDaySchedules(null);
        groupSchedule.setId(123L);
        groupSchedule.setStudyGroup(studyGroup);

        DaySchedule daySchedule = new DaySchedule();
        daySchedule.setDayOfWeek(DayOfWeek.MONDAY);
        daySchedule.setGroupSchedule(groupSchedule);
        daySchedule.setId(123L);
        daySchedule.setLectures(null);

        Person person = new Person();
        person.setId(123L);
        person.setName("Name");
        person.setSurname("Doe");

        Professor professor = new Professor();
        professor.setId(123L);
        professor.setPerson(person);

        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Name");

        Lecture lecture = new Lecture();
        lecture.setAudience(audience);
        lecture.setDaySchedule(daySchedule);
        lecture.setId(123L);
        lecture.setProfessor(professor);
        lecture.setSubject(subject);
        when(this.lecturesRepository.save((Lecture) any())).thenReturn(lecture);

        Audience audience1 = new Audience();
        audience1.setId(123L);
        audience1.setName("Name");

        StudyGroup studyGroup1 = new StudyGroup();
        studyGroup1.setId(123L);
        studyGroup1.setName("Name");
        studyGroup1.setStudents(null);

        GroupSchedule groupSchedule1 = new GroupSchedule();
        groupSchedule1.setDaySchedules(null);
        groupSchedule1.setId(123L);
        groupSchedule1.setStudyGroup(studyGroup1);

        DaySchedule daySchedule1 = new DaySchedule();
        daySchedule1.setDayOfWeek(DayOfWeek.MONDAY);
        daySchedule1.setGroupSchedule(groupSchedule1);
        daySchedule1.setId(123L);
        daySchedule1.setLectures(null);

        Person person1 = new Person();
        person1.setId(123L);
        person1.setName("Name");
        person1.setSurname("Doe");

        Professor professor1 = new Professor();
        professor1.setId(123L);
        professor1.setPerson(person1);

        Subject subject1 = new Subject();
        subject1.setId(123L);
        subject1.setName("Name");

        Lecture lecture1 = new Lecture();
        lecture1.setAudience(audience1);
        lecture1.setDaySchedule(daySchedule1);
        lecture1.setId(123L);
        lecture1.setProfessor(professor1);
        lecture1.setSubject(subject1);
        assertSame(lecture, this.lecturesService.save(lecture1));
        verify(this.lecturesRepository).save((Lecture) any());
    }

    @Test
    void testDeleteById() {
        doNothing().when(this.lecturesRepository).deleteById((Long) any());
        this.lecturesService.deleteById(123L);
        verify(this.lecturesRepository).deleteById((Long) any());
        assertTrue(this.lecturesService.findAll().isEmpty());
    }

    @Test
    void testGetSchedule() {
        Person person = new Person();
        person.setId(123L);
        person.setName("Name");
        person.setSurname("Doe");

        StudyGroup studyGroup = new StudyGroup();
        studyGroup.setId(123L);
        studyGroup.setName("Name");
        studyGroup.setStudents(null);

        Student student = new Student();
        student.setId(123L);
        student.setPerson(person);
        student.setStudyGroup(studyGroup);
        Optional<Student> ofResult = Optional.of(student);
        when(this.studentsService.findById((Long) any())).thenReturn(ofResult);
        when(this.lecturesRepository.findByDaySchedule((DaySchedule) any())).thenReturn(null);

        StudyGroup studyGroup1 = new StudyGroup();
        studyGroup1.setId(123L);
        studyGroup1.setName("Name");
        studyGroup1.setStudents(null);

        GroupSchedule groupSchedule = new GroupSchedule();
        groupSchedule.setDaySchedules(null);
        groupSchedule.setId(123L);
        groupSchedule.setStudyGroup(studyGroup1);
        when(this.groupSchedulesService.findByStudyGroup((StudyGroup) any())).thenReturn(groupSchedule);

        StudyGroup studyGroup2 = new StudyGroup();
        studyGroup2.setId(123L);
        studyGroup2.setName("Name");
        studyGroup2.setStudents(null);

        GroupSchedule groupSchedule1 = new GroupSchedule();
        groupSchedule1.setDaySchedules(null);
        groupSchedule1.setId(123L);
        groupSchedule1.setStudyGroup(studyGroup2);

        DaySchedule daySchedule = new DaySchedule();
        daySchedule.setDayOfWeek(DayOfWeek.MONDAY);
        daySchedule.setGroupSchedule(groupSchedule1);
        daySchedule.setId(123L);
        daySchedule.setLectures(null);
        when(this.daySchedulesService.getDaySchedule((DayOfWeek) any(), (GroupSchedule) any())).thenReturn(daySchedule);
        assertNull(this.lecturesService.getSchedule(DayOfWeek.MONDAY, 123L));
        verify(this.studentsService).findById((Long) any());
        verify(this.lecturesRepository).findByDaySchedule((DaySchedule) any());
        verify(this.groupSchedulesService).findByStudyGroup((StudyGroup) any());
        verify(this.daySchedulesService).getDaySchedule((DayOfWeek) any(), (GroupSchedule) any());
        assertTrue(this.lecturesService.findAll().isEmpty());
    }
}

