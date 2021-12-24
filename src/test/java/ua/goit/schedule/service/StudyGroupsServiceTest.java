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
import ua.goit.schedule.model.StudyGroup;
import ua.goit.schedule.repository.StudyGroupsRepository;

@ContextConfiguration(classes = {StudyGroupsService.class})
@ExtendWith(SpringExtension.class)
class StudyGroupsServiceTest {
    @MockBean
    private StudyGroupsRepository studyGroupsRepository;

    @Autowired
    private StudyGroupsService studyGroupsService;

    @Test
    void testFindAll() {
        when(this.studyGroupsRepository.findAll()).thenReturn(null);
        assertNull(this.studyGroupsService.findAll());
        verify(this.studyGroupsRepository).findAll();
    }

    @Test
    void testFindById() {
        StudyGroup studyGroup = new StudyGroup();
        studyGroup.setId(123L);
        studyGroup.setName("Name");
        studyGroup.setStudents(null);
        Optional<StudyGroup> ofResult = Optional.of(studyGroup);
        when(this.studyGroupsRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<StudyGroup> actualFindByIdResult = this.studyGroupsService.findById(123L);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(this.studyGroupsRepository).findById((Long) any());
        assertTrue(this.studyGroupsService.findAll().isEmpty());
    }

    @Test
    void testSave() {
        StudyGroup studyGroup = new StudyGroup();
        studyGroup.setId(123L);
        studyGroup.setName("Name");
        studyGroup.setStudents(null);
        when(this.studyGroupsRepository.save((StudyGroup) any())).thenReturn(studyGroup);

        StudyGroup studyGroup1 = new StudyGroup();
        studyGroup1.setId(123L);
        studyGroup1.setName("Name");
        studyGroup1.setStudents(null);
        assertSame(studyGroup, this.studyGroupsService.save(studyGroup1));
        verify(this.studyGroupsRepository).save((StudyGroup) any());
        assertTrue(this.studyGroupsService.findAll().isEmpty());
    }

    @Test
    void testDeleteById() {
        doNothing().when(this.studyGroupsRepository).deleteById((Long) any());
        this.studyGroupsService.deleteById(123L);
        verify(this.studyGroupsRepository).deleteById((Long) any());
        assertTrue(this.studyGroupsService.findAll().isEmpty());
    }
}

