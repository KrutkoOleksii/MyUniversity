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
import ua.goit.schedule.model.StudyGroup;
import ua.goit.schedule.model.Subject;
import ua.goit.schedule.repository.LectureRepository;

@ContextConfiguration(classes = {LectureService.class})
@ExtendWith(SpringExtension.class)
class DayScheduleServiceTest {
    @MockBean
    private LectureRepository lectureRepository;

    @Autowired
    private LectureService lectureService;

    @Test
    void testFindAll() {
        when(this.lectureRepository.findAll()).thenReturn(null);
        assertNull(this.lectureService.findAll());
        verify(this.lectureRepository).findAll();
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

        Subject subject = new Subject();
        subject.setId(123L);

        subject.setName("Name");

        DaySchedule daySchedule = new DaySchedule();

        daySchedule.setDayOfWeek(DayOfWeek.MONDAY);
        daySchedule.setId(123L);
        daySchedule.setStudyGroup(studyGroup);

        Optional<DaySchedule> ofResult = Optional.of(daySchedule);
        when(this.lectureRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<DaySchedule> actualFindByIdResult = this.lectureService.findById(123L);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(this.lectureRepository).findById((Long) any());
        assertTrue(this.lectureService.findAll().isEmpty());
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

        Subject subject = new Subject();
        subject.setId(123L);

        subject.setName("Name");

        DaySchedule daySchedule = new DaySchedule();

        daySchedule.setDayOfWeek(DayOfWeek.MONDAY);
        daySchedule.setId(123L);
        daySchedule.setStudyGroup(studyGroup);

        when(this.lectureRepository.save((DaySchedule) any())).thenReturn(daySchedule);

        Audience audience1 = new Audience();
        audience1.setId(123L);

        audience1.setName("Name");

        StudyGroup studyGroup1 = new StudyGroup();
        studyGroup1.setId(123L);
        studyGroup1.setName("Name");
        studyGroup1.setStudents(null);

        Subject subject1 = new Subject();
        subject1.setId(123L);

        subject1.setName("Name");

        DaySchedule daySchedule1 = new DaySchedule();

        daySchedule1.setDayOfWeek(DayOfWeek.MONDAY);
        daySchedule1.setId(123L);
        daySchedule1.setStudyGroup(studyGroup1);

        assertSame(daySchedule, this.lectureService.save(daySchedule1));
        verify(this.lectureRepository).save((DaySchedule) any());
        assertTrue(this.lectureService.findAll().isEmpty());
    }

    @Test
    void testDeleteById() {
        doNothing().when(this.lectureRepository).deleteById((Long) any());
        this.lectureService.deleteById(123L);
        verify(this.lectureRepository).deleteById((Long) any());
        assertTrue(this.lectureService.findAll().isEmpty());
    }
}

