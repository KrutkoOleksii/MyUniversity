package ua.goit.schedule.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="groupSchedule")
public class GroupSchedule implements BaseEntity<Long>{

    @Id
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="study_group_id")
    private StudyGroup studyGroup;

    @OneToMany
    private Set<DaySchedule> daySchedules;
}
