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
import ua.goit.schedule.repository.GroupSchedulesRepository;

@ContextConfiguration(classes = {GroupSchedulesService.class})
@ExtendWith(SpringExtension.class)
class GroupSchedulesServiceTest {
    @MockBean
    private GroupSchedulesRepository groupSchedulesRepository;

    @Autowired
    private GroupSchedulesService groupSchedulesService;

    @Test
    void testFindAll() {
        when(this.groupSchedulesRepository.findAll()).thenReturn(null);
        assertNull(this.groupSchedulesService.findAll());
        verify(this.groupSchedulesRepository).findAll();
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
        when(this.groupSchedulesRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<GroupSchedule> actualFindByIdResult = this.groupSchedulesService.findById(123L);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(this.groupSchedulesRepository).findById((Long) any());
        assertTrue(this.groupSchedulesService.findAll().isEmpty());
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
        when(this.groupSchedulesRepository.save((GroupSchedule) any())).thenReturn(groupSchedule);

        StudyGroup studyGroup1 = new StudyGroup();
        studyGroup1.setId(123L);
        studyGroup1.setName("Name");
        studyGroup1.setStudents(null);

        GroupSchedule groupSchedule1 = new GroupSchedule();
        groupSchedule1.setDaySchedules(null);
        groupSchedule1.setId(123L);
        groupSchedule1.setStudyGroup(studyGroup1);
        assertSame(groupSchedule, this.groupSchedulesService.save(groupSchedule1));
        verify(this.groupSchedulesRepository).save((GroupSchedule) any());
        assertTrue(this.groupSchedulesService.findAll().isEmpty());
    }

    @Test
    void testDeleteById() {
        doNothing().when(this.groupSchedulesRepository).deleteById((Long) any());
        this.groupSchedulesService.deleteById(123L);
        verify(this.groupSchedulesRepository).deleteById((Long) any());
        assertTrue(this.groupSchedulesService.findAll().isEmpty());
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
        when(this.groupSchedulesRepository.findByStudyGroup((StudyGroup) any())).thenReturn(groupSchedule);

        StudyGroup studyGroup1 = new StudyGroup();
        studyGroup1.setId(123L);
        studyGroup1.setName("Name");
        studyGroup1.setStudents(null);
        assertSame(groupSchedule, this.groupSchedulesService.findByStudyGroup(studyGroup1));
        verify(this.groupSchedulesRepository).findByStudyGroup((StudyGroup) any());
        assertTrue(this.groupSchedulesService.findAll().isEmpty());
    }
}

