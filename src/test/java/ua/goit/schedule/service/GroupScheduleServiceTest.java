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
import ua.goit.schedule.model.GroupSchedule;
import ua.goit.schedule.model.StudyGroup;
import ua.goit.schedule.repository.GroupScheduleRepository;

@ContextConfiguration(classes = {GroupScheduleService.class})
@ExtendWith(SpringExtension.class)
class GroupScheduleServiceTest {
    @MockBean
    private GroupScheduleRepository groupScheduleRepository;

    @Autowired
    private GroupScheduleService groupScheduleService;

    @Test
    void testFindAll() {
        when(this.groupScheduleRepository.findAll()).thenReturn(null);
        assertNull(this.groupScheduleService.findAll());
        verify(this.groupScheduleRepository).findAll();
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
        Optional<GroupSchedule> ofResult = Optional.of(groupSchedule);
        when(this.groupScheduleRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<GroupSchedule> actualFindByIdResult = this.groupScheduleService.findById(123L);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(this.groupScheduleRepository).findById((Long) any());
        assertTrue(this.groupScheduleService.findAll().isEmpty());
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
        when(this.groupScheduleRepository.save((GroupSchedule) any())).thenReturn(groupSchedule);

        StudyGroup studyGroup1 = new StudyGroup();
        studyGroup1.setId(123L);
        studyGroup1.setName("Name");
        studyGroup1.setStudents(null);

        GroupSchedule groupSchedule1 = new GroupSchedule();
        groupSchedule1.setDaySchedules(null);
        groupSchedule1.setId(123L);
        groupSchedule1.setStudyGroup(studyGroup1);
        assertSame(groupSchedule, this.groupScheduleService.save(groupSchedule1));
        verify(this.groupScheduleRepository).save((GroupSchedule) any());
        assertTrue(this.groupScheduleService.findAll().isEmpty());
    }

    @Test
    void testDeleteById() {
        doNothing().when(this.groupScheduleRepository).deleteById((Long) any());
        this.groupScheduleService.deleteById(123L);
        verify(this.groupScheduleRepository).deleteById((Long) any());
        assertTrue(this.groupScheduleService.findAll().isEmpty());
    }

    @Test
    void testFindByStudyGroup() {
        StudyGroup studyGroup = new StudyGroup();
        studyGroup.setId(123L);
        studyGroup.setName("Name");
        studyGroup.setStudents(null);

        GroupSchedule groupSchedule = new GroupSchedule();
        groupSchedule.setDaySchedules(null);
        groupSchedule.setId(123L);
        groupSchedule.setStudyGroup(studyGroup);
        when(this.groupScheduleRepository.findByStudyGroup((StudyGroup) any())).thenReturn(groupSchedule);

        StudyGroup studyGroup1 = new StudyGroup();
        studyGroup1.setId(123L);
        studyGroup1.setName("Name");
        studyGroup1.setStudents(null);
        assertSame(groupSchedule, this.groupScheduleService.findByStudyGroup(studyGroup1));
        verify(this.groupScheduleRepository).findByStudyGroup((StudyGroup) any());
        assertTrue(this.groupScheduleService.findAll().isEmpty());
    }
}

