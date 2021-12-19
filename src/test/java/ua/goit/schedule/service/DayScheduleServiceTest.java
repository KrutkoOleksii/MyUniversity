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
import ua.goit.schedule.repository.DayScheduleRepository;

@ContextConfiguration(classes = {DayScheduleService.class})
@ExtendWith(SpringExtension.class)
class DayScheduleServiceTest {
    @MockBean
    private DayScheduleRepository dayScheduleRepository;

    @Autowired
    private DayScheduleService dayScheduleService;

    @Test
    void testFindAll() {
        when(this.dayScheduleRepository.findAll()).thenReturn(null);
        assertNull(this.dayScheduleService.findAll());
        verify(this.dayScheduleRepository).findAll();
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
        when(this.dayScheduleRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<DaySchedule> actualFindByIdResult = this.dayScheduleService.findById(123L);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(this.dayScheduleRepository).findById((Long) any());
        assertTrue(this.dayScheduleService.findAll().isEmpty());
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
        when(this.dayScheduleRepository.save((DaySchedule) any())).thenReturn(daySchedule);

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
        assertSame(daySchedule, this.dayScheduleService.save(daySchedule1));
        verify(this.dayScheduleRepository).save((DaySchedule) any());
        assertTrue(this.dayScheduleService.findAll().isEmpty());
    }

    @Test
    void testDeleteById() {
        doNothing().when(this.dayScheduleRepository).deleteById((Long) any());
        this.dayScheduleService.deleteById(123L);
        verify(this.dayScheduleRepository).deleteById((Long) any());
        assertTrue(this.dayScheduleService.findAll().isEmpty());
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
        when(this.dayScheduleRepository.getDaySchedule((DayOfWeek) any(), (GroupSchedule) any())).thenReturn(daySchedule);

        StudyGroup studyGroup1 = new StudyGroup();
        studyGroup1.setId(123L);
        studyGroup1.setName("Name");
        studyGroup1.setStudents(null);

        GroupSchedule groupSchedule1 = new GroupSchedule();
        groupSchedule1.setDaySchedules(null);
        groupSchedule1.setId(123L);
        groupSchedule1.setStudyGroup(studyGroup1);
        assertSame(daySchedule, this.dayScheduleService.getDaySchedule(DayOfWeek.MONDAY, groupSchedule1));
        verify(this.dayScheduleRepository).getDaySchedule((DayOfWeek) any(), (GroupSchedule) any());
        assertTrue(this.dayScheduleService.findAll().isEmpty());
    }
}

