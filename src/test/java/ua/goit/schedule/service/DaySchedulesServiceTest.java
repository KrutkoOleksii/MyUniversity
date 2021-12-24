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
import ua.goit.schedule.model.DaySchedule;
import ua.goit.schedule.model.GroupSchedule;
import ua.goit.schedule.model.StudyGroup;
import ua.goit.schedule.repository.DaySchedulesRepository;

@ContextConfiguration(classes = {DaySchedulesService.class})
@ExtendWith(SpringExtension.class)
class DaySchedulesServiceTest {
    @MockBean
    private DaySchedulesRepository daySchedulesRepository;

    @Autowired
    private DaySchedulesService daySchedulesService;

    @Test
    void testFindAll() {
        when(this.daySchedulesRepository.findAll()).thenReturn(null);
        assertNull(this.daySchedulesService.findAll());
        verify(this.daySchedulesRepository).findAll();
    }

    @Test
    void testFindById() {
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
        Optional<DaySchedule> ofResult = Optional.of(daySchedule);
        when(this.daySchedulesRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<DaySchedule> actualFindByIdResult = this.daySchedulesService.findById(123L);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(this.daySchedulesRepository).findById((Long) any());
        assertTrue(this.daySchedulesService.findAll().isEmpty());
    }

    @Test
    void testSave() {
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
        when(this.daySchedulesRepository.save((DaySchedule) any())).thenReturn(daySchedule);

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
        assertSame(daySchedule, this.daySchedulesService.save(daySchedule1));
        verify(this.daySchedulesRepository).save((DaySchedule) any());
        assertTrue(this.daySchedulesService.findAll().isEmpty());
    }

    @Test
    void testDeleteById() {
        doNothing().when(this.daySchedulesRepository).deleteById((Long) any());
        this.daySchedulesService.deleteById(123L);
        verify(this.daySchedulesRepository).deleteById((Long) any());
        assertTrue(this.daySchedulesService.findAll().isEmpty());
    }

    @Test
    void testGetDaySchedule() {
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
        when(this.daySchedulesRepository.getDaySchedule((DayOfWeek) any(), (GroupSchedule) any())).thenReturn(daySchedule);

        StudyGroup studyGroup1 = new StudyGroup();
        studyGroup1.setId(123L);
        studyGroup1.setName("Name");
        studyGroup1.setStudents(null);

        GroupSchedule groupSchedule1 = new GroupSchedule();
        groupSchedule1.setDaySchedules(null);
        groupSchedule1.setId(123L);
        groupSchedule1.setStudyGroup(studyGroup1);
        assertSame(daySchedule, this.daySchedulesService.getDaySchedule(DayOfWeek.MONDAY, groupSchedule1));
        verify(this.daySchedulesRepository).getDaySchedule((DayOfWeek) any(), (GroupSchedule) any());
        assertTrue(this.daySchedulesService.findAll().isEmpty());
    }
}

