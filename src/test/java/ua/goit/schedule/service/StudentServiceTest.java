package ua.goit.schedule.service;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ua.goit.schedule.model.Person;
import ua.goit.schedule.model.Student;
import ua.goit.schedule.model.StudyGroup;
import ua.goit.schedule.repository.StudentRepository;

@ContextConfiguration(classes = {StudentService.class})
@ExtendWith(SpringExtension.class)
class StudentServiceTest {
    @MockBean
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @Test
    void testFindAll() {
        when(this.studentRepository.findAll()).thenReturn(null);
        assertNull(this.studentService.findAll());
        verify(this.studentRepository).findAll();
    }

    @Test
    void testFindById() {
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
        when(this.studentRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<Student> actualFindByIdResult = this.studentService.findById(123L);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(this.studentRepository).findById((Long) any());
        assertTrue(this.studentService.findAll().isEmpty());
    }

    @Test
    void testSave() {
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
        when(this.studentRepository.save((Student) any())).thenReturn(student);

        Person person1 = new Person();
        person1.setId(123L);
        person1.setName("Name");
        person1.setSurname("Doe");

        StudyGroup studyGroup1 = new StudyGroup();
        studyGroup1.setId(123L);
        studyGroup1.setName("Name");
        studyGroup1.setStudents(null);

        Student student1 = new Student();
        student1.setId(123L);
        student1.setPerson(person1);
        student1.setStudyGroup(studyGroup1);
        assertSame(student, this.studentService.save(student1));
        verify(this.studentRepository).save((Student) any());
        assertTrue(this.studentService.findAll().isEmpty());
    }

    @Test
    void testDeleteById() {
        doNothing().when(this.studentRepository).deleteById((Long) any());
        this.studentService.deleteById(123L);
        verify(this.studentRepository).deleteById((Long) any());
        assertTrue(this.studentService.findAll().isEmpty());
    }
}

