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
import ua.goit.schedule.repository.StudyGroupRepository;

@ContextConfiguration(classes = {StudyGroupService.class})
@ExtendWith(SpringExtension.class)
class StudyGroupServiceTest {
    @MockBean
    private StudyGroupRepository studyGroupRepository;

    @Autowired
    private StudyGroupService studyGroupService;

    @Test
    void testFindAll() {
        when(this.studyGroupRepository.findAll()).thenReturn(null);
        assertNull(this.studyGroupService.findAll());
        verify(this.studyGroupRepository).findAll();
    }

    @Test
    void testFindById() {
        StudyGroup studyGroup = new StudyGroup();
        studyGroup.setId(123L);
        studyGroup.setName("Name");
        studyGroup.setStudents(null);
        Optional<StudyGroup> ofResult = Optional.of(studyGroup);
        when(this.studyGroupRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<StudyGroup> actualFindByIdResult = this.studyGroupService.findById(123L);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(this.studyGroupRepository).findById((Long) any());
        assertTrue(this.studyGroupService.findAll().isEmpty());
    }

    @Test
    void testSave() {
        StudyGroup studyGroup = new StudyGroup();
        studyGroup.setId(123L);
        studyGroup.setName("Name");
        studyGroup.setStudents(null);
        when(this.studyGroupRepository.save((StudyGroup) any())).thenReturn(studyGroup);

        StudyGroup studyGroup1 = new StudyGroup();
        studyGroup1.setId(123L);
        studyGroup1.setName("Name");
        studyGroup1.setStudents(null);
        assertSame(studyGroup, this.studyGroupService.save(studyGroup1));
        verify(this.studyGroupRepository).save((StudyGroup) any());
        assertTrue(this.studyGroupService.findAll().isEmpty());
    }

    @Test
    void testDeleteById() {
        doNothing().when(this.studyGroupRepository).deleteById((Long) any());
        this.studyGroupService.deleteById(123L);
        verify(this.studyGroupRepository).deleteById((Long) any());
        assertTrue(this.studyGroupService.findAll().isEmpty());
    }
}

